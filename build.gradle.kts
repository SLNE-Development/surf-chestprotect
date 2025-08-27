import org.jetbrains.kotlin.gradle.dsl.KotlinJvmExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinBasePlugin

buildscript {
    repositories {
        gradlePluginPortal()
        maven("https://repo.slne.dev/repository/maven-public/") { name = "maven-public" }
    }
    dependencies {
        classpath("dev.slne.surf:surf-api-gradle-plugin:1.21.7+")
    }
}

allprojects {
    group = "dev.slne.surf.chestprotect"
    version = findProperty("version") as String

    afterEvaluate {
        plugins.withType<KotlinBasePlugin> {
            configure<KotlinJvmExtension> {
                jvmToolchain(24)
            }
        }
    }
}
