## Dropwizard microservice template

##### Build
```
./gradlew clean test fatCapsule
java -jar build/libs/information-service-capsule.jar server src/main/resources/app-config.yml
```

##### Admin Connector
```
http://localhost:7115/healthcheck
http://localhost:7115/metrics
```

##### Endpoints
```
http://localhost:7015/api/info
http://localhost:7015/api/swagger
```

#### Travis CI Status

[![Build Status](https://travis-ci.org/happysathya/dropwizard-microservice-template.svg?branch=master)](https://travis-ci.org/happysathya/dropwizard-microservice-template)