FROM openjdk:11-jre
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} application.jar

EXPOSE 8081
ENTRYPOINT exec java ${JAVA_OPTS} -jar /application.jar

# HOW TO BUILD
# run command via cmd/terminal `docker build -t conference .`

# HOW TO RUN
# `docker run -p 8081:8081 --name conference -d conference`