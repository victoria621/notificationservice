FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY target/notificationservice-0.0.1-SNAPSHOT.jar app.jar

RUN addgroup --system --gid 1000 appgroup && \
    adduser --system --uid 1000 --gid 1000 appuser

USER appuser

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]