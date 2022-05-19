package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Exercise;
import com.example.MadPtApi.domain.Member;
import com.example.MadPtApi.domain.Record;
import com.example.MadPtApi.dto.recordDto.RecordDto;
import com.example.MadPtApi.dto.recordDto.DailyRecordResponseDto;
import com.example.MadPtApi.dto.recordDto.RecordSaveRequestDto;
import com.example.MadPtApi.repository.ExerciseRepository;
import com.example.MadPtApi.repository.MemberRepository;
import com.example.MadPtApi.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final ExerciseRepository exerciseRepository;

    /**
     * 운동 정보 저장
     */
    @Transactional
    public int saveRecord(Long memberId, RecordSaveRequestDto recordSaveRequestDto) {
        // 회원 엔티티
        Member member = memberRepository.findByClientId(memberId);

        int breakTime = recordSaveRequestDto.getBreakTime();
        List<RecordDto> recordDtoList = recordSaveRequestDto.getRecordDtoList();
        List<Record> recordList = new ArrayList<>();

        // Record 엔티티 생성
        for (RecordDto dto : recordDtoList) {
            // Exercise Entity 조회
            Exercise exercise = exerciseRepository.findById(dto.getExerciseId()).orElseThrow(() -> new IllegalArgumentException("no such exercise data"));

            // 소모 칼로리 계산
            Long totalExerciseTime = (dto.getEndTime() - dto.getStartTime()); // 밀리초
            double burnedKcal = calculateBurnedKcal(totalExerciseTime, dto.getRealTime(), member.getWeight());

            // timestamp -> LocalDateTime
            LocalDateTime startTime = timestampConverter(dto.getStartTime());
            LocalDateTime endTime = timestampConverter(dto.getEndTime());

            // Record Entity 생성
            Record record = Record.builder()
                    .exercise(exercise)
                    .startTime(startTime)
                    .endTime(endTime)
                    .realTime(dto.getRealTime())
                    .reps(dto.getReps())
                    .sets(dto.getSets())
                    .avgScore(dto.getAvgScore())
                    .breakTime(breakTime)
                    .burnedKcal(burnedKcal)
                    .build();
            record.setMember(member);

            recordList.add(record);

        }
        // 저장
        List<Record> savedRecordList = recordRepository.saveAll(recordList);

        return savedRecordList.size();
    }

    /**
     * 일별 소모 칼로리 조회
     */
    public double getDailyBurnedKcal(Long clientId, Long date) {
        List<DailyRecordResponseDto> recordList = findRecord(clientId, date);
        double totalBurnedKcal = 0;
        for (DailyRecordResponseDto dto : recordList) {
            totalBurnedKcal += dto.getBurnedKcal();
        }
        return Math.round(totalBurnedKcal * 100) / 100.0;
    }

    /**
     * 일별 운동 정보 조회
     */
    public List<DailyRecordResponseDto> findRecord(Long clientId, Long date) {
        // 회원 엔티티 조회
        Member member = memberRepository.findByClientId(clientId);// member 조회 안되면 예외 처리 필요

        // timestamp 변환
        Timestamp timestamp = new Timestamp(date);
        LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
        LocalDateTime startOfDay = localDate.atStartOfDay();
        LocalDateTime endOfDay = LocalTime.MAX.atDate(localDate);

        List<Record> recordList = recordRepository.findRecordByMemberIdAndRecordDate(member.getId(), startOfDay, endOfDay);
        List<DailyRecordResponseDto> recordResponseDtoList = new ArrayList<>();
        for (Record record : recordList) {
            Timestamp startTime = Timestamp.valueOf(record.getStartTime());
            DailyRecordResponseDto recordResponseDto = DailyRecordResponseDto.builder()
                    .exerciseName(record.getExercise().getExerciseName())
                    .startTime(startTime.getTime())
                    .reps(record.getReps())
                    .sets(record.getSets())
                    .burnedKcal(record.getBurnedKcal())
                    .build();
            recordResponseDtoList.add(recordResponseDto);
        }

        return recordResponseDtoList;
    }
    /**
     * 월별 소모 칼로리 조회
     */
    public HashMap<Integer, Double> monthlyBurnedKcal(Member member, int month, int days) {
        HashMap<Integer, Double> recordMap = new HashMap<>();

        for (int i = 1; i <= days; i++) {
            recordMap.put(i, (double) 0);
        }

        List<Record> recordList = recordRepository.findRecordsByMonth(member.getId(), month);

        for (Record record : recordList) {
            double burnedKcal = record.getBurnedKcal();
            int dayOfMonth = record.getStartTime().getDayOfMonth();
            recordMap.put(dayOfMonth, recordMap.getOrDefault(dayOfMonth, 0.0) + burnedKcal);
        }

        return recordMap;
    }

    /**
     * 칼로리 연산
     */
    public double calculateBurnedKcal(Long totalTime, Long realTime, double weight) {
        // realtime = 밀리세컨드
        // 1초 1000 밀리세컨드
        // 운동 MET = 3.4, 평상시 MET = 1
        double MET = 5;
        // 운동시 산소 소모량
        double oxygenConsumption = (3.5 * MET * weight * (int) (realTime / 60)) / 1000;

        // 평상시 산소 소모량
        oxygenConsumption += 3.5 * 1 * weight * (int) ((totalTime - realTime) / 60) / 1000;

        // 총 소모 칼로리
        double burnedKcal = oxygenConsumption * 5;

        return Math.round(burnedKcal * 100) / 100.0;
    }

    // timestamp -> LocalDateTime 변환 메소드
    private LocalDateTime timestampConverter(Long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), TimeZone.getDefault().toZoneId());
    }


}
