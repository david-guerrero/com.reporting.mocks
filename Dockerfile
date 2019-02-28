FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY target /tmp/target/
COPY src /tmp/src/

FROM openjdk:8-jdk-alpine
ARG DEPENDENCY=/tmp/target/dependency
COPY --from=MAVEN_TOOL_CHAIN ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=MAVEN_TOOL_CHAIN ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=MAVEN_TOOL_CHAIN ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.reporting.mocks.MocksApplication"]