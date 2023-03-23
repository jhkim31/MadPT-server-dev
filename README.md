# MadPT-server-dev

## [DB Container](/DB_container)
## [API Container](/API_container)
## [프로젝트 관리](/.github/PROJECT_GUIDE.md)
# MadPT 서버 개발 repo입니다.

## master branch

마스터 브랜치 이며 실행 가능한 제품 상태의 버전, 최종 release 버전만 이 브랜치로 올립니다.  
배포가 완료되면 태그로 버전을 붙입니다.

## hotfix branches

마스터 브랜치로 업로드 되기 전까지 미처 발견되지 못한, 사용상에 생긴 버그들을 급하게 픽스해야할때 사용할 브랜치 입니다.

## develop branch

개발 메인 브랜치 이며, 항상 사용하게될 브랜치 입니다. 이 개발 브랜치에서 특정 기능을 개발해야한다면 feature branch를 만들어 해당 기능을 만든 다음 develop branch로 pull request를 넣어 merge합니다.

develop branch에서 배포 가능한 수준까지 개발이 된다면 release branch로 업로드하여 최종 release까지 점검을 진행합니다.

## feature branches

기능을 개발하는 브랜치로, develop 브랜치에서 특정 기능을 개발해야 할때 이 브랜치를 만들어 기능을 개발 후 develop branch로 pull request를 올립니다.  
feature/{feature_name} 형태 입니다.

## release branches

배포를 준비하는 브랜치로 develop 브랜치에서 개발이 완료되면 이 브랜치로 옮겨, 배포를 위한 준비를 합니다. 만약 추가 개발이 필요하다면 이 브랜치에서 다시 develop 브랜치로 옮겨 개발 후 다시 release branch로 옮깁니다.
release/v{version} 형태 입니다.


# Github Actions
현재, 두가지 workflow가 존재합니다.

## 1. Docker 빌드 테스트 workflow
docker 컨테이너의 빌드를 테스트하는 워크플로우로, release브랜치의 push시 실행됩니다.

## 2. Docker 빌드 및 Dockerhub push workflow
빌드 테스트가 완료가 되면 master로 pull request를 달아 PR이 닫히게 되면 실행되게 됩니다.
