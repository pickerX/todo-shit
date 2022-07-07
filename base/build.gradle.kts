import io.km.todo.buildsrc.Configs
import io.km.todo.buildsrc.Libs
import io.km.todo.buildsrc.Versions

plugins {
    id("com.android.library")
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

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
        viewBinding = true

        // Disable unused AGP features
        buildConfig = false
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }
}

dependencies {

    // module
    api(project(":data:repository"))

    // lifecycle
    api(Libs.Lifecycle.lifecycleRuntime)
    kapt(Libs.Lifecycle.lifecycleCompiler)
    api(Libs.Lifecycle.viewmodelKtx)

    // navigation
    api(Libs.Navigation.navCommonKtx)
    api(Libs.Navigation.navRuntimeKtx)
    api(Libs.Navigation.navFragmentKtx)
    api(Libs.Navigation.navUiKtx)
    api(Libs.Navigation.navDfm)

    // image
    api(Libs.Image.coil)
    api(Libs.Image.coilCompose)

    // material3
    api(Libs.Material3.compose)
}