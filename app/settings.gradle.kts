plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
rootProject.name = "java-project-71"
include("app")
project(":app").projectDir.mkdirs()
