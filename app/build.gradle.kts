plugins {
    alias(libs.plugins.android.application)
    // Apply the Google services plugin
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.projectappoint"
    compileSdk = 36

    defaultConfig {
        applicationId = "com..projectappoint"
        minSdk = 31
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.firebase.database)
    implementation(libs.firebase.storage)
    implementation(libs.firebase.auth)
    implementation(libs.constraintlayout)

    // Firebase services
    implementation(platform(libs.firebase.bom))
    implementation(libs.google.firebase.firestore)
    implementation(libs.firebase.storage)
    //noinspection UseTomlInstead
    implementation("com.google.firebase:firebase-messaging")
    //noinspection UseTomlInstead
    implementation("com.google.firebase:firebase-analytics")

    // Optional: for Google sign-in
    //noinspection UseTomlInstead
    implementation("com.google.android.gms:play-services-auth:21.4.0")

    // Test dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}