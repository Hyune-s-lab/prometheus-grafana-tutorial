# prometheus-grafana-tutorial

### Environment

- kotlin, spring 2.7.7
- exporter
    - spring actuator, micrometer
- prometheus v2.41.0 with docker
- grafana 9.3.2 with docker

### How to run

> docker 로 실행되는 spring application, prometheus, grafana

```shell
> run.sh
```

![image](https://user-images.githubusercontent.com/55722186/209907144-a7299729-f340-4ed5-8af9-ebdaa0896963.png)

## spring application (prometheus-grafana-tutorial)

### GC 를 일으키기 위한 부하 생성

- 최대 메모리를 128M 로 설정
- `LoadGenerator` heap 메모리 점유를 위한 로직 구현

### actuator 세팅

- actuator 확인
    - http://127.0.0.1:8080/actuator
- prometheus 메트릭 수집 url with micrometer
    - http://127.0.0.1:8080/actuator/prometheus

## prometheus

> http://localhost:9090/

1. status > targets 에 application 정상 여부 확인

![image](https://user-images.githubusercontent.com/55722186/209476697-1df8fab6-2d6f-48a3-9a25-e6e4e2799759.png)

2.graph 탭에서 메트릭 조회 가능

- `jvm_memory_used_bytes{job="prometheus-grafana-tutorial"}`

![image](https://user-images.githubusercontent.com/55722186/209476774-1ba67059-ca33-4aa1-908e-a2d4d75115ba.png)

## grafana

> http://localhost:3000/  
> admin / admin

### datasource 연결

1. Add data source
   ![image](https://user-images.githubusercontent.com/55722186/209907808-b893b863-bcc0-4b22-97bb-3baf845cc629.png)
2. Prometheus 선택
3. URL, Scrape interval 설정
   ![image](https://user-images.githubusercontent.com/55722186/209908036-72c22336-95e7-4be6-9c3e-1042d43cb4a1.png)

### dashboard 구성

1. New dashboard
   ![image](https://user-images.githubusercontent.com/55722186/209908153-b8aa192c-7f4c-4b7e-8e06-da2414bf2955.png)
2. Add a new panel
    - prometheus graph 에 사용한 쿼리를 입력합니다.
      ![image](https://user-images.githubusercontent.com/55722186/209908335-a3d44f5c-9999-4290-bdc2-ff3c4eefd0cd.png)
3. dashboard 확인
    - 필요에 따라 time range, refresh time 을 조절할 수 있습니다.
      ![image](https://user-images.githubusercontent.com/55722186/209908497-e35707aa-a687-406f-9728-a623f8048521.png)
