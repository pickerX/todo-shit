import io.km.todo.buildsrc.Configs
import io.km.todo.buildsrc.Libs

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlinx-serialization")
    id("dagger.hilt.android.plugin")
}

apply {
    from("../../deps_shared.gradle")
    from("../../deps_test.gradle")
    from("../../ktlint.gradle")
}

android {
    compileSdk = Configs.compileSdkVersion
    defaultConfig {
        minSdk = Configs.minSdkVersion
        targetSdk = Configs.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    // module
    api(project(":model"))

    // network
    api(Libs.Network.retrofit)
    api(Libs.Network.retrofitConverter)
    api(Libs.Network.serializationJson)
    api(Libs.Network.okhttp)
    debugImplementation(Libs.Network.loggingInterceptor)
    testImplementation(Libs.Network.mockWebServer)
}