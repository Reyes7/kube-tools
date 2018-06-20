#!/bin/sh

java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=$APP_PROFILE -jar /app.jar