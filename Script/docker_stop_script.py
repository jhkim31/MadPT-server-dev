import docker

client = docker.from_env()


for i in client.containers():
    if "api_v" in i["Names"][0]:
        stop_name = i["Names"][0][1:]
        client.stop(stop_name)


