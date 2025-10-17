plugins {
    id("java")
    id("idea")
    id ("com.github.ben-manes.versions") version "0.52.0"
    application
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("hexlet.code.App")
}


dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.apache.commons:commons-lang3:3.18.0")
}

tasks.test {
    useJUnitPlatform()
}
