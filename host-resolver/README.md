Command for building and running docker image:

docker build --build-arg JAR_FILE=/build/libs/host-resolver-spring-boot-app-0.0.1-SNAPSHOT.jar 
             --build-arg ENTRYPOINT_FILE=java-app-entrypoint.sh -t host-resolver-spring-boot-app . 
             && docker run -p 8111:8111 --name host-resolver-spring-boot-app host-resolver-spring-boot-app 
