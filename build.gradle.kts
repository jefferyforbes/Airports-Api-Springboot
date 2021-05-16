import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.0-SNAPSHOT"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.0-RC"
    kotlin("plugin.spring") version "1.5.0-RC"
}

group = "multiverse-bootcamp"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
    google()
    jcenter()
}

dependencies {
//    Enabling the spring security library forces the api requester to provide authentication if they wish to make a
//    call otherwise it will return a 401 (Unauthorized) response
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
    implementation("org.springdoc:springdoc-openapi-ui:1.5.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.byteowls:jasypt-gradle-plugin:1.0.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
