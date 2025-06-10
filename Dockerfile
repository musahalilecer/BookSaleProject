# 1. Maven ve Java 17 içeren imaj
FROM maven:3.9.6-eclipse-temurin-17-alpine

# 2. Çalışma dizini
WORKDIR /app

# 3. Projeyi kopyala
COPY . .

# 4. Maven ile build et
RUN mvn clean package -DskipTests

# 5. Uygulamayı başlat
ENTRYPOINT ["java", "-jar", "target/BookSaleProject-0.0.1-SNAPSHOT.jar"]