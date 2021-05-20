import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.spring") version "1.4.32"
    kotlin("plugin.serialization") version "1.5.0"
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
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
    implementation("org.springdoc:springdoc-openapi-ui:1.5.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.byteowls:jasypt-gradle-plugin:1.0.1")
    implementation("org.litote.kmongo:kmongo:4.2.7")
    implementation("org.litote.kmongo:kmongo-async:4.2.7")
    implementation("org.litote.kmongo:kmongo-coroutine:4.2.7")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
    implementation("org.springframework.boot:spring-boot-starter-security:2.4.0")
    implementation("org.springframework.security:spring-security-core:5.4.2")
    implementation("org.springframework.security:spring-security-oauth2-jose:5.4.2")
    implementation("org.springframework.security:spring-security-oauth2-resource-server:5.4.2")
    implementation("io.jsonwebtoken:jjwt-api:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-orgjson:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.2")
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
