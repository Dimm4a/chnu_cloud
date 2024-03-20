FROM ubuntu:latest
LABEL authors="Dmytr"

ENTRYPOINT ["top", "-b"]

# Використовуємо за базовий образ OpenJDK для Java
FROM openjdk:latest

# Копіюємо скомпільований jar-файл у контейнер
COPY target/RESTservice-0.0.1-SNAPSHOT.jar /app/RESTservice-0.0.1-SNAPSHOT.jar

# Вказуємо робочий каталог
WORKDIR /app

# Вказуємо команду для запуску додатку при старті контейнера
CMD ["java", "-jar", "RESTservice-0.0.1-SNAPSHOT.jar"]