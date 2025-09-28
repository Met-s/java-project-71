import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("java")
    id("idea")
    id ("com.github.ben-manes.versions") version "0.52.0"
    id("org.sonarqube") version "6.3.1.5724"
    application
    jacoco
    checkstyle
//    alias(libs.plugins.sonarqube)
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("hexlet.code.App")
}

jacoco {
    toolVersion = "0.8.13"
    reportsDirectory = layout.buildDirectory.dir("customJacocoReportDir")
}

checkstyle {
    toolVersion = "10.12.4"
}

sonar {
    properties {
        property("sonar.projectKey", "Met-s_java-project-71")
        property("sonar.organization", "met-s")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

//sonar {
//    properties {
//        property("sonar.projectKey", "Met-s_java-project-71")
//        property("sonar.organization", "met-s")
////        property("sonar.host.url", "https://sonarcloud.io")
//    }
//}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.0.0")
    implementation("org.junit.platform:junit-platform-console:1.0.0")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("org.apache.commons:commons-lang3:3.18.0")

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
//    implementation("org.springframework.boot:spring-boot:3.1.4")

    implementation("info.picocli:picocli:4.7.7")
    annotationProcessor("info.picocli:picocli-codegen:4.7.7")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.20.0")
    implementation("com.fasterxml.jackson" +
            ".dataformat:jackson-dataformat-yaml:2.20.0")
    implementation("com.fasterxml.jackson.core:jackson-annotations:3.0-rc5")

}

tasks.test {
    useJUnitPlatform()
    testLogging {
        TestExceptionFormat.FULL
        events = setOf(TestLogEvent.FAILED, TestLogEvent.PASSED,
            TestLogEvent.SKIPPED)
        showStandardStreams = true
    }
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    reports {
        xml.required = true
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
    }
}
