plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {


    implementation ("com.google.api-client:google-api-client:2.0.0")
    implementation ("com.google.oauth-client:google-oauth-client-jetty:1.34.1")
    implementation ("com.google.apis:google-api-services-gmail:v1-rev20220404-2.0.0")
    implementation ("javax.mail:mail:1.4.7")
    implementation ("com.twilio.sdk:twilio:9.12.0")

    implementation ("javax.xml.bind:jaxb-api:2.3.1")
    implementation ("com.github.mcpat.apistubs:cdc-1.1.2-stub:1.0.1")
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