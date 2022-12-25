# prometheus-grafana-tutorial

### Environment

- kotlin, spring 2.7.7
- exporter
    - spring actuator, micrometer
- prometheus v2.41.0 with docker

### How to run

> docker 로 실행되는 spring application, prometheus

```shell
> run.sh
```

![image](https://user-images.githubusercontent.com/55722186/209476676-0b6e9385-f6f8-4878-b2af-a6eed4f33af9.png)

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

...
