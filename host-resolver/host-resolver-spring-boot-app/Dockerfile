FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ARG ENTRYPOINT_FILE
ADD ${JAR_FILE} app.jar
COPY ${ENTRYPOINT_FILE} /docker-entrypoint.sh
ENV APP_PROFILE default
RUN ["chmod", "+x", "/docker-entrypoint.sh"]
ENTRYPOINT ["/docker-entrypoint.sh"]