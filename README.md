# todoary


# 프로젝트 실행 방법

```shell
git clone https://github.com/grow-up-study/todoary

cd todoary
```

## application.yaml 작성

application.yaml 파일을 아래와 같이 작성한다.

```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: create
    show-sql: true
    properties:
      hibernate:
        format_sql: true
  datasource:
    username: sa
    url: jdbc:h2:mem:test;MODE=MYSQL
```
## 프로젝트 실행

```shell
./gradlew build

java -jar build/libs/todoary.jar
```
