# Java 17 kullan
FROM eclipse-temurin:17-jdk-alpine

# Çalışma dizini
WORKDIR /app

# Jar dosyasını kopyala (dosya adını kendi jar dosyana göre değiştir)
COPY build/libs/BookSaleProject-0.0.1-SNAPSHOT.jar app.jar

# Spring Boot başlat
ENTRYPOINT ["java", "-jar", "app.jar"]