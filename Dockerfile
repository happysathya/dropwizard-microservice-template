FROM frolvlad/alpine-oraclejdk8
WORKDIR /home/dev/code
COPY build/libs/information-service-capsule.jar information-service.jar
COPY src/main/resources/app-config.yml .

EXPOSE 7015

CMD ["java", "-jar","-Xms256m", "-Xmx768m", "information-service.jar", "server", "app-config.yml"]
