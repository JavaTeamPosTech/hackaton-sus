# ===== BUILD =====
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /build

# Copia POMs
COPY pom.xml .
COPY ms-contracts/pom.xml ms-contracts/pom.xml
COPY ms-maquina/pom.xml ms-maquina/pom.xml
COPY ms-operacao/pom.xml ms-operacao/pom.xml
COPY ms-operacao-maquina/pom.xml ms-operacao-maquina/pom.xml

# Copia código necessário
COPY ms-contracts/src ms-contracts/src
COPY ms-maquina/src ms-maquina/src
COPY ms-operacao/src ms-operacao/src
COPY ms-operacao-maquina/src ms-operacao-maquina/src

# Build apenas do serviço
RUN mvn clean package \
    -pl ms-maquina \
    -am \
    -DskipTests \
    -B

# ===== RUNTIME =====
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /build/ms-maquina/target/*.jar app.jar

EXPOSE 8081
CMD ["java", "-jar", "app.jar"]
