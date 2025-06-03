# Etapa de construcción
FROM maven:3.9.4-openjdk-17-slim AS builder

# Define directorio de trabajo
WORKDIR /app

# Copia archivos de configuración de Maven
COPY pom.xml .

# Descarga dependencias (para aprovechar cache de Docker)
RUN mvn dependency:go-offline -B

# Copia código fuente
COPY src ./src

# Compila la aplicación
RUN mvn clean package -DskipTests

# Etapa de producción
FROM openjdk:17-jdk-slim

# Define directorio de trabajo
WORKDIR /app

# Crea usuario no root por seguridad
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

# Copia el JAR compilado desde la etapa anterior
COPY --from=builder /app/target/TFConectados-*.jar app.jar

# Expone puerto 8080
EXPOSE 8080

# Variables de entorno por defecto
ENV JAVA_OPTS="-Xmx512m -Xms256m"
ENV SPRING_PROFILES_ACTIVE=prod

# Comando para ejecutar la aplicación
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
