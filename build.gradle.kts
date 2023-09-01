plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("com.opencsv:opencsv:5.8")
    implementation("org.json:json:20230618")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.2")
    compileOnly("org.projectlombok:lombok:1.18.28")
}

tasks.test {
    useJUnitPlatform()
}