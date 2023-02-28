# prometheus-grafana-tutorial

### Environment

- kotlin, spring 2.7.x
- prometheus, grafana with docker
- exporter
    - spring actuator, micrometer

### How to run

> docker 로 실행되는 spring application, mysql, prometheus, grafana
> prometheus, grafana datasource 도 연결 됩니다.

```shell
> run.sh
```

![image](https://user-images.githubusercontent.com/55722186/221808471-ded7209c-8597-449f-a116-1b5ab2485d61.png)

## 1. spring application (prometheus-grafana-tutorial)

### GC 를 일으키기 위한 부하 자동 생성 `LoadGenerator`

- heap 메모리 점유를 위한 로직 구현
- 최대 메모리를 128M 로 설정

### Database row 생성을 위한 API

```http request
POST http://localhost:8080/api/v1/redeemcode
```

- 무작위 금액의 redeemcode row insert

### actuator 세팅

- actuator 확인
    - http://127.0.0.1:8080/actuator
- prometheus 메트릭 수집 url with micrometer
    - http://127.0.0.1:8080/actuator/prometheus

## 2. prometheus

> http://localhost:9090/

1. status > targets 에 application 정상 여부 확인
   ![image](https://user-images.githubusercontent.com/55722186/209476697-1df8fab6-2d6f-48a3-9a25-e6e4e2799759.png)
2. graph 탭에서 메트릭 조회 가능
    - `jvm_memory_used_bytes{job="prometheus-grafana-tutorial"}`
      ![image](https://user-images.githubusercontent.com/55722186/209476774-1ba67059-ca33-4aa1-908e-a2d4d75115ba.png)

## 3. grafana

> http://localhost:3000/  
> admin / admin

### dashboard 구성

1. Wiki > monitor [Link](https://github.com/Hyune-s-lab/prometheus-grafana-tutorial/wiki/monitor)
    - json import
2. dashboard 확인
   ![image](https://user-images.githubusercontent.com/55722186/221810183-d676623e-7d8a-4459-861d-ec5a22a5df5b.png)

## 4. 기타

### datasource url 을 `localhost` 가 아닌 `host.docker.internal` 로 설정한 이유

[`시행 착오 2 - 도커 컨테이너에서 localhost 를 쓰면 어떻게 될까?` 항목 참고](https://hyune-c.tistory.com/54)
![image](https://user-images.githubusercontent.com/55722186/209913740-445a81b5-c61b-434d-a237-a45a92f1a4cd.png)
