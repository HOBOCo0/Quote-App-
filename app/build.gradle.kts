plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.quoteapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.quoteapp"
        minSdk = 24
        targetSdk = 34
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
    buildFeatures{
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    val room_version = "2.6.1"
    // for room-DB
    implementation("androidx.room:room-runtime:$room_version")
    //Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")
    // for kapt (this is an annotation processor )
    kapt("androidx.room:room-compiler:$room_version")
    // coroutines core implementation
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
    // coroutines android specific
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0-RC")

    val lifecycle_version = "2.8.3"

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // to use live data
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    // for json parsing
//    implementation("com.google.code.gson:gson:2.8.6")



    // glide to load images
//    implementation ("com.github.bumptech.glide:glide:4.16.0")
}