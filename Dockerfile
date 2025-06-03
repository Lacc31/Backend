# Usar una imagen que ya tenga Maven y JDK
FROM openjdk:17-jdk-slim

# Instalar Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Define directorio de trabajo
WORKDIR /app

# Copia todo el proyecto
COPY . .

# Compila la aplicación
RUN mvn clean package -DskipTests

# Expone puerto 8080
EXPOSE 8080

# Variables de entorno por defecto
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Comando para ejecutar la aplicación (busca cualquier JAR en target)
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar target/*.jar"]
