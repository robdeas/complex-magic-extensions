plugins {
    kotlin("jvm") version "1.9.10" // Kotlin JVM plugin
    application // For JVM run configuration
}

group = "tech.robd"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17)) // Set the Java target to 17
    }
}

dependencies {
    // Kotest dependencies for testing
    testImplementation("io.kotest:kotest-runner-junit5:5.7.2") // Kotest runner for JUnit 5
    testImplementation("io.kotest:kotest-assertions-core:5.7.2") // Kotest core assertions
    testImplementation("io.kotest:kotest-property:5.7.2") // Kotest property testing (optional)

    implementation("space.kscience:kmath-complex-jvm:0.3.1")
    implementation("space.kscience:kmath-core-jvm:0.3.1")




}

application {
    // Set the main class for the Kotlin application
    mainClass.set("tech.robd.MainKt") // Adjust to your actual main class
}

tasks.withType<Test> {
    useJUnitPlatform() // Use JUnit 5 for Kotest
}
