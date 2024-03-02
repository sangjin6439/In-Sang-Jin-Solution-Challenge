FROM openjdk:17-jdk-slim as build

# 애플리케이션 파일이 포함될 디렉토리 생성
#WORKDIR /app

COPY ./build/libs/*.jar ./app.jar
COPY ./src/main/resources/application.yml ./application.yml

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]