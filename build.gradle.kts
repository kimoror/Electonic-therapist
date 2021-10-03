plugins {
    java
}

group = "kimoror.therapist"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.5.5")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.5.5")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.5")
//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}