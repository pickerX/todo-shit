package io.km.todo.buildsrc

object Configs {
    const val versionName = "1.0.0"
    const val versionCode = 1
    const val packageName = "io.km.todo.shit"
    const val compileSdkVersion = 33
    const val targetSdkVersion = 33
    const val minSdkVersion = 23
}

object Versions {
    // library
    const val buildGradle = "7.0.0"
    const val kotlin = "1.6.21"
    const val coroutine = "1.5.2"
    const val compose = "1.0.1"
    const val lifecycle = "2.4.0"
    const val navigation = "2.3.5"
    const val room = "2.3.0"
    const val dagger = "2.40"
    const val androidHilt = "1.0.0"
    const val retrofit = "2.9.0"
    const val okhttp = "4.9.0"
    const val markdown = "4.6.2"
}

object Plugins {
    // plugin
    const val buildGradle = "com.android.tools.build:gradle:${Versions.buildGradle}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val safeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.dagger}"
    const val kotlinSerialization =
        "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
}

object Libs {
    // desugar
    const val desugar = "com.android.tools:desugar_jdk_libs:1.1.5"

    object Kotlin {
        // kotlin
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val kotlinSerialization =
            "org.jetbrains.kotlin.plugin.serialization:${Versions.kotlin}"
    }

    object Coroutines {
        // coroutine
        const val coroutineCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
        const val coroutineAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
        const val coroutineTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"
    }

    object Androidx {
        // androidx
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val material = "com.google.android.material:material:1.4.0"
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val activityKtx = "androidx.activity:activity-ktx:1.4.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.6"
    }

    object Compose {
        // compose
        const val activityCompose = "androidx.activity:activity-compose:1.3.0"
        const val navigationCompose = "androidx.navigation:navigation-compose:2.4.2"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
        const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha02"
        const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val composeCompiler = "androidx.compose.compiler:compiler:${Versions.compose}"
        const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
        const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"
        const val composeAnimation = "androidx.compose.animation:animation:${Versions.compose}"
        const val composeIconsCore =
            "androidx.compose.material:material-icons-core:${Versions.compose}"
        const val composeIconsExtended =
            "androidx.compose.material:material-icons-extended:${Versions.compose}"
    }

    object Navigation {
        // navigation
        const val navCommonKtx = "androidx.navigation:navigation-common-ktx:${Versions.navigation}"
        const val navRuntimeKtx =
            "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
        const val navFragmentKtx =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val navDfm =
            "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
    }

    object Lifecycle {
        // lifecycle
        const val lifecycleRuntime =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
        const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    }

    object Material3 {
        const val core = "com.google.android.material:material:1.6.0-alpha03"
        const val compose = "androidx.compose.material3:material3:1.0.0-alpha10"
    }

    object Dagger {
        // dependency injection
        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
        const val daggerHilt = "com.google.dagger:hilt-android:${Versions.dagger}"
        const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.dagger}"
        const val daggerHiltTesting = "com.google.dagger:hilt-android-testing:${Versions.dagger}"
    }

    object Network {
        // network
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
    }

    object Storage {
        // storage
        const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    }

    object Image {
        // image
        const val coil = "io.coil-kt:coil:1.4.0"
        const val coilCompose = "io.coil-kt:coil-compose:1.4.0"
    }

    object Markdown {
        // markdown
        const val markdownCore = "io.noties.markwon:core:${Versions.markdown}"
        const val markdownTable = "io.noties.markwon:ext-tables:${Versions.markdown}"
        const val markdownImage = "io.noties.markwon:image-coil:${Versions.markdown}"
    }

    object Test {
        // test
        const val junit = "junit:junit:4.13.2"
        const val mockk = "io.mockk:mockk:1.12.0"
        const val truth = "com.google.truth:truth:1.1.3"
        const val archCore = "androidx.arch.core:core-testing:2.1.0"

        // android test
        const val testCore = "androidx.test:core:1.4.0"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        const val extJunitKtx = "androidx.test.ext:junit-ktx:1.1.3"
        const val extTruth = "androidx.test.ext:truth:1.4.0"
        const val benchmark = "androidx.benchmark:benchmark-junit4:1.0.0"
    }

    object Lint {
        // lint
        const val ktlint = "com.pinterest:ktlint:0.42.1"
    }
}