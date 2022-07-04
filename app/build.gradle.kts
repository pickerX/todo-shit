import io.km.todo.buildsrc.Libs.Material3

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

apply {
    from("../deps_androidx.gradle")
    from("../deps_compose.gradle")
    from("../deps_shared.gradle")
    from("../deps_test.gradle")
    from("../ktlint.gradle")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "io.km.todo.shit"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true

        // Disable unused AGP features
        aidl = false
        renderScript = false
        shaders = false
    }
}

dependencies {
    implementation(project(":base"))

    implementation(Material3.core)
    implementation(Material3.compose)
}