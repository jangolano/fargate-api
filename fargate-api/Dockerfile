FROM --platform=linux/amd64 amazoncorretto:22-alpine

COPY build/libs/fargate-api-0.0.1-SNAPSHOT.jar /opt/fargate-api.jar

ENTRYPOINT ["java", "-jar", "/opt/fargate-api.jar"]