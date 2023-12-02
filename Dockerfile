# Usa una imagen de Java como base
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación al contenedor
COPY target/inditex-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que se ejecuta la aplicación (ajústalo según tus necesidades)
EXPOSE 8080

# Comando para ejecutar la aplicación cuando se inicia el contenedor
CMD ["java", "-jar", "app.jar"]