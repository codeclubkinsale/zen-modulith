FROM eclipse-temurin:25
ARG JAR_FILE=target/*.jar

RUN mkdir /home/nobody
WORKDIR /home/nobody

COPY ${JAR_FILE} app.jar

USER 65534
ENTRYPOINT ["java","-jar","app.jar"]