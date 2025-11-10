// Import statements should be at the top of the file

lateinit var jvmTarget: String

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.projectappoint"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.projectappoint"
        minSdk = 31
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        signingConfig = signingConfigs.getByName("debug")
        proguardFiles()
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
        // The JavaVersion class is now imported at the top of the file
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
    }

    dependenciesInfo {
        includeInApk = true
        includeInBundle = true
    }
    buildToolsVersion = "35.0.0"// 'dependenciesInfo' is not a standard block in the 'android' DSL.
    // This may cause an error and has been removed.
    // If you need to control dependencies in your APK/Bundle,
    // this is usually handled by the dependency configuration itself (e.g., 'implementation' vs 'compileOnly').

    // 'buildToolsVersion' is deprecated and should be removed. The Android Gradle Plugin
    // uses a default version, or you can specify it in 'local.properties'.
    // 'ndkVersion' should be defined in 'local.properties' or have a value here.
    // Removing them unless you have a specific reason.
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.database)
    implementation(libs.animated.vector.drawable)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}