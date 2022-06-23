// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.1.3" apply false
    id("com.android.library") version "7.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.6.21" apply false
    id("org.jetbrains.kotlin.jvm") version "1.6.21" apply false

    kotlin("kapt") version "1.7.0"
}

buildscript {
    dependencies {
        classpath(io.km.todo.buildsrc.Plugins.buildGradle)
        classpath(io.km.todo.buildsrc.Plugins.kotlinGradle)
        classpath(io.km.todo.buildsrc.Plugins.daggerHilt)
        classpath(io.km.todo.buildsrc.Plugins.kotlinSerialization)
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}