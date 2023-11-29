plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.daggerretro"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.daggerretro"
        minSdk = 24
        targetSdk = 33
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

    //data binding
    buildFeatures {
        viewBinding=true
        dataBinding=true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Material Design
    implementation ("com.google.android.material:material:1.2.0-alpha02")

    //Dagger 2
    implementation ("com.google.dagger:dagger-android:2.20")
    implementation ("com.google.dagger:dagger-android-support:2.20")
    kapt ("com.google.dagger:dagger-android-processor:2.20")
    kapt ("com.google.dagger:dagger-compiler:2.20")

    //Retrofit 2
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.7.2")
    implementation ("com.squareup.retrofit2:converter-gson:2.7.2")
    implementation ("com.google.code.gson:gson:2.8.6")

    //RxJava & RxAndroid
    implementation ("io.reactivex.rxjava2:rxjava:2.2.16")
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    // ReactiveStreams support for LiveData
    implementation ("androidx.lifecycle:lifecycle-reactivestreams-ktx:2.2.0")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.13.0")

}


