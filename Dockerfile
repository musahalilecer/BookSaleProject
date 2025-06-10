FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

# Maven wrapper'ı çalıştırmak için izin ver
RUN chmod +x mvnw

# Maven wrapper ile build
RUN ./mvnw clean package -DskipTests

# JAR çalıştır
ENTRYPOINT ["java", "-jar", "target/BookSaleProject-0.0.1-SNAPSHOT.jar"]