plugins {
    id("java")
    id("idea")
    id ("org.sonarqube") version "7.0.1.6134"
    application
    checkstyle
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("hexlet.code.App")
}

checkstyle {
    toolVersion = "10.12.4"
}

jacoco {
    toolVersion = "0.8.13"
    reportsDirectory = layout.buildDirectory.dir("customJacocoReportDir")
}

sonar {
    properties {
        property ("sonar.projectKey", "Met-s_java-project-71")
        property ("sonar.organization", "met-s")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.junit.platform:junit-platform-console:1.13.1")
    implementation("org.apache.commons:commons-lang3:3.18.0")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }
