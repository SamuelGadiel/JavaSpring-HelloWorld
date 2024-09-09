FROM eclipse-temurin:17-jre

ADD /infrastructure/build/libs/main.jar /main.jar

ADD /opentelemetry-javaagent.jar /opentelemetry-javaagent.jar


ENTRYPOINT java -javaagent:/opentelemetry-javaagent.jar -jar /main.jar