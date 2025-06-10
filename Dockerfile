# 1. Java base image
FROM eclipse-temurin:17-jdk-alpine

# 2. Çalışma dizini
WORKDIR /app

# 3. Maven wrapper varsa onu çalıştır, yoksa normal mvn kullan
COPY . .

# 4. Maven ile jar üret
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests

# 5. Uygulamayı başlat
ENTRYPOINT ["java", "-jar", "target/BookSaleProject-0.0.1-SNAPSHOT.jar"]
