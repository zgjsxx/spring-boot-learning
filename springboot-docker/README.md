# spring-boot-learning
spring-boot-learning


mvn package docker:build

docker run -p 8080:8080 --name springboot-docker \
-v /alldata/app/springboot-docker/logs:/var/logs \
-d springboot/springboot-docker:latest
