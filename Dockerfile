# 1. Java base image
FROM eclipse-temurin:17-jdk-alpine

# 2. Çalışma dizinine geç
WORKDIR /app

# 3. Proje dosyalarını kopyala
COPY . .

# 4. Gradle wrapper'a çalıştırma izni ver
RUN chmod +x ./gradlew

# 5. JAR üret
RUN ./gradlew build

# 6. JAR'ı çalıştır
ENTRYPOINT ["java", "-jar", "build/libs/BookSaleProject-0.0.1-SNAPSHOT.jar"]