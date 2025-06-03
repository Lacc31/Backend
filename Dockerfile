FROM openjdk:17-jdk-slim
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
EXPOSE 8080
CMD ["sh", "-c", "sleep 10 && java -jar target/*.jar"]
