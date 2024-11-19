plugins {
    id("java")
    id ("war")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("jakarta.ws.rs:jakarta.ws.rs-api:3.1.0")
    implementation ("org.keycloak:keycloak-core:20.0.1")
    implementation ("org.keycloak:keycloak-adapter-core:20.0.1")
    implementation ("jakarta.annotation:jakarta.annotation-api:2.1.1")
    implementation("org.keycloak:keycloak-saml-wildfly-adapter-dist-pom:25.0.5")
}

tasks.test {
    useJUnitPlatform()
}