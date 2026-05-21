//////plugins {
//////    alias(libs.plugins.android.application)
//////    alias(libs.plugins.kotlin.android)
//////    alias(libs.plugins.kotlin.compose)
//////}
//////
//////android {
//////    namespace = "com.example.focus_flow"
//////    compileSdk {
//////        version = release(36)
//////    }
//////
//////    defaultConfig {
//////        applicationId = "com.example.focus_flow"
//////        minSdk = 24
//////        targetSdk = 36
//////        versionCode = 1
//////        versionName = "1.0"
//////
//////        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//////    }
//////
//////    buildTypes {
//////        release {
//////            isMinifyEnabled = false
//////            proguardFiles(
//////                getDefaultProguardFile("proguard-android-optimize.txt"),
//////                "proguard-rules.pro"
//////            )
//////        }
//////    }
//////    compileOptions {
//////        sourceCompatibility = JavaVersion.VERSION_11
//////        targetCompatibility = JavaVersion.VERSION_11
//////    }
//////    kotlinOptions {
//////        jvmTarget = "11"
//////    }
//////    buildFeatures {
//////        compose = true
//////    }
//////}
//////
//////dependencies {
//////    implementation(libs.androidx.core.ktx)
//////    implementation(libs.androidx.lifecycle.runtime.ktx)
//////    implementation(libs.androidx.activity.compose)
//////    implementation(platform(libs.androidx.compose.bom))
//////    implementation(libs.androidx.compose.ui)
//////    implementation(libs.androidx.compose.ui.graphics)
//////    implementation(libs.androidx.compose.ui.tooling.preview)
//////    implementation(libs.androidx.compose.material3)
//////    testImplementation(libs.junit)
//////    androidTestImplementation(libs.androidx.junit)
//////    androidTestImplementation(libs.androidx.espresso.core)
//////    androidTestImplementation(platform(libs.androidx.compose.bom))
//////    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
//////    debugImplementation(libs.androidx.compose.ui.tooling)
//////    debugImplementation(libs.androidx.compose.ui.test.manifest)
//////}
////
////
////plugins {
////    id("com.android.application")
////    id("org.jetbrains.kotlin.android")
////    id("kotlin-kapt")
////    id("androidx.navigation.safeargs.kotlin")
////}
////
////android {
////    namespace = "com.focusflow"
////    compileSdk = 34
////
////    defaultConfig {
////        applicationId = "com.focusflow"
////        minSdk = 24
////        targetSdk = 34
////        versionCode = 1
////        versionName = "1.0"
////
////        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
////    }
////
////    buildTypes {
////        release {
////            isMinifyEnabled = false
////            proguardFiles(
////                getDefaultProguardFile("proguard-android-optimize.txt"),
////                "proguard-rules.pro"
////            )
////        }
////    }
////
////    buildFeatures {
////        compose = true
////    }
////
////    composeOptions {
////        kotlinCompilerExtensionVersion = "1.5.4"
////    }
////
////    compileOptions {
////        sourceCompatibility = JavaVersion.VERSION_17
////        targetCompatibility = JavaVersion.VERSION_17
////    }
////
////    kotlinOptions {
////        jvmTarget = "17"
////        freeCompilerArgs = listOf("-Xjvm-default=enable", "-Xopt-in=kotlin.RequiresOptIn")
////    }
////    kapt {
////        javacOptions {
////            option("-Xmaxerrs", 500)
////        }
////        useBuildCache = true
////        // Fix for JDK 17+ module access
////        arguments {
////            arg("kapt.use.jvm.compiler.argument", "true")
////        }
////    }
//
//
////}
////
////dependencies {
////    implementation("androidx.core:core-ktx:1.12.0")
////    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
////    implementation("androidx.activity:activity-compose:1.8.0")
////
////    // Compose BOM
////    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
////    implementation("androidx.compose.ui:ui")
////    implementation("androidx.compose.ui:ui-graphics")
////    implementation("androidx.compose.ui:ui-tooling-preview")
////    implementation("androidx.compose.material3:material3")
////    implementation("androidx.compose.material:material-icons-extended")
////
////    // Navigation Compose
////    implementation("androidx.navigation:navigation-compose:2.7.5")
////
////    // ViewModel Compose
////    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
////    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
////
////    // Room
////    implementation("androidx.room:room-runtime:2.6.1")
////    implementation("androidx.room:room-ktx:2.6.1")
////    kapt("androidx.room:room-compiler:2.6.1")
////
////
////    // WorkManager
////    implementation("androidx.work:work-runtime-ktx:2.9.0")
////
////    // MPAndroidChart
////    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
////
////    // Coroutines
////    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
////
////    implementation("com.google.accompanist:accompanist-pager:0.32.0")
////    implementation("com.google.accompanist:accompanist-pager-indicators:0.32.0")
////}
//
//
//plugins {
//    id("com.android.application")
//    id("org.jetbrains.kotlin.android")
//    id("kotlin-kapt")
//    id("androidx.navigation.safeargs.kotlin")
//}
//
//android {
//    namespace = "com.focusflow"
//    compileSdk = 34
//
//    defaultConfig {
//        applicationId = "com.focusflow"
//        minSdk = 24
//        targetSdk = 34
//        versionCode = 1
//        versionName = "1.0"
//    }
//
//    buildFeatures {
//        compose = true
//    }
//
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.5.4"
//    }
//
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_17
//        targetCompatibility = JavaVersion.VERSION_17
//    }
//
//    kotlinOptions {
//        jvmTarget = "17"
//        freeCompilerArgs = listOf("-Xjvm-default=all-compatibility")
//    }
//    // ✅ KAPT FIX FOR JDK 17+
//    kapt {
//        useBuildCache = true
//        javacOptions {
//            option("-Xmaxerrs", 500)
//        }
//        arguments {
//            arg("kapt.use.jvm.compiler.argument", "true")
//        }
//    }
//}
//
//dependencies {
//    implementation("androidx.core:core-ktx:1.12.0")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
//    implementation("androidx.activity:activity-compose:1.8.0")
//
//    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
//    implementation("androidx.compose.ui:ui")
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    implementation("androidx.compose.material3:material3")
//    implementation("androidx.compose.material:material-icons-extended")
//
//    implementation("androidx.navigation:navigation-compose:2.7.5")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
//
//    // Room
//    implementation("androidx.room:room-runtime:2.6.1")
//    implementation("androidx.room:room-ktx:2.6.1")
//    kapt("androidx.room:room-compiler:2.6.1")
//
//    // WorkManager
//    implementation("androidx.work:work-runtime-ktx:2.9.0")
//
//    // MPAndroidChart
//    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
//
//    // Coroutines
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
//
//    // Accompanist (for Onboarding)
//    implementation("com.google.accompanist:accompanist-pager:0.32.0")
//    implementation("com.google.accompanist:accompanist-pager-indicators:0.32.0")
//}

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "1.9.0-1.0.13"  // KSP plugin
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.focusflow"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.focusflow"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = listOf("-Xjvm-default=all-compatibility")
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.0")

    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")

    implementation("androidx.navigation:navigation-compose:2.7.5")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    // Room with KSP (no kapt)
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")   // KSP instead of kapt

    // WorkManager
    implementation("androidx.work:work-runtime-ktx:2.9.0")

    // MPAndroidChart
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Accompanist
    implementation("com.google.accompanist:accompanist-pager:0.32.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.32.0")
}