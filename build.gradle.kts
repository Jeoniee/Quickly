import org.gradle.api.JavaVersion

plugins {
    id("java")
    id("war")
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE" // Spring Boot 버전에 맞는 버전 사용
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("javax.servlet:javax.servlet-api:4.0.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation ("org.springframework.security:spring-security-config:5.5.3")
}

