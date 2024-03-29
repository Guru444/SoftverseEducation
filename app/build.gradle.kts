plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}


android {
    namespace = "com.egitim.softverseeducation"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.egitim.softverseeducation"
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

    viewBinding{
        enable = true
    }
    dataBinding {
        enable = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Hawk Local stogery
    implementation("com.orhanobut:hawk:2.0.1")

    //İmage Load
    implementation("com.github.bumptech.glide:glide:4.16.0")


    implementation("androidx.webkit:webkit:1.9.0")


    //Lottie
    implementation("com.airbnb.android:lottie:3.4.0")

    implementation ("androidx.room:room-runtime:2.3.0")
    implementation ("androidx.room:room-ktx:2.3.0")
    kapt("androidx.room:room-compiler:2.3.0")


}


