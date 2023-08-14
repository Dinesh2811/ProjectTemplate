plugins {
//    alias(libs.plugins.androidApplication)
//    alias(libs.plugins.kotlinAndroid)
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")   // ksp
}

android {
    namespace = "com.dinesh.android"
    compileSdk = 34
    compileSdkPreview = "UpsideDownCake"

    defaultConfig {
        applicationId = "com.dinesh.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(JavaVersion.VERSION_17.toString().toInt())
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    signingConfigs {
        getByName("debug") {
//            storeFile = file("../keystore/debug.keystore")
//            storePassword = "android_storePassword"
//            keyAlias = "android_debug_key"
//            keyPassword = "android_keyPassword"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.ui:ui-graphics:1.5.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("com.google.android.material:material:1.11.0-alpha01")
    implementation("androidx.compose.material:material:1.5.0")
    implementation("androidx.compose.material3:material3:1.2.0-alpha05")
    implementation("androidx.compose.material3:material3-android:1.2.0-alpha05")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.0")

    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.0")

    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    testImplementation("junit:junit:4.13.2")


    //  Room components    	2.5.2   -->  2.6.0-alpha03
    implementation("androidx.room:room-runtime:2.6.0-alpha03")
    ksp("androidx.room:room-compiler:2.6.0-alpha03")
    implementation("androidx.room:room-ktx:2.6.0-alpha03")

    //  ViewModel & LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")

    // RecyclerView
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.0")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:retrofit-mock:2.9.0")

    // Gson
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Gson Converter
    implementation("com.google.code.gson:gson:2.10.1") // Used to convert Java Object into JSON representation

    // HTTP
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.8")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.8")

    // Lottie
    implementation("com.airbnb.android:lottie:6.1.0")

    // Volley
    implementation("com.android.volley:volley:1.2.1")

    // Paging
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.paging:paging-runtime-ktx:3.2.0")

    // Location Services
    implementation("com.google.android.gms:play-services-location:21.0.1")

}

/*

dependencies {
    implementation(libs.bundles.android)
    implementation(libs.bundles.material3)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.compose.material)
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.bundles.android.test.implementation)
    debugImplementation(libs.bundles.debug.implementation)
    testImplementation(libs.junit)


    //  ViewModel & LiveData
    implementation(libs.bundles.lifecycle)

    //  Room components
    implementation(libs.bundles.room)
    ksp(libs.androidx.room.compiler)    //  kapt or ksp

    // Glide
    implementation(libs.glide)
    annotationProcessor(libs.compiler)

    // Retrofit
    implementation(libs.bundles.retrofit)

    // HTTP
    implementation(libs.bundles.okhttp)

    // Gson
    implementation(libs.bundles.gson)

    // Navigation Component
    implementation(libs.bundles.navigation.ui)

    // Lottie
    implementation(libs.lottie)

    // Volley
    implementation(libs.volley)

    // RecyclerView
    implementation(libs.androidx.swiperefreshlayout)

    // Paging
    implementation(libs.bundles.paging)

    // Location Services
    implementation(libs.play.services.location)

    // Shimmer
    implementation(libs.shimmer)
}

*/


/*


[versions]
agp = "8.1.0"
kotlin = "1.8.22"

core-ktx = "1.10.1"
activity-compose = "1.7.2"
appcompat = "1.6.1"
constraintlayout = "2.1.4"
material = "1.11.0-alpha01"

test-junit = "1.1.5"
espresso-core = "3.5.1"
junit = "4.13.2"

material3 = "1.2.0-alpha05"

ui = "1.5.0"
compose-material = "1.5.0"
ui-test-junit4 = "1.5.0"
compose-bom = "2023.08.00"

room = "2.6.0-alpha03"  #   2.5.2   -->   2.6.0-alpha03
lifecycle = "2.6.1"
glide = "4.15.1"
retrofit = "2.9.0"
okhttp = "5.0.0-alpha.8"

converter-gson = "2.9.0"
gson = "2.10.1"

navigation = "2.7.0"
lottie = "6.1.0"
volley = "1.2.1"
swiperefreshlayout = "1.1.0"

lifecycle-extensions = "2.2.0"
paging-runtime-ktx = "3.2.0"

play-services-location = "21.0.1"
shimmer = "0.5.0"



[libraries]
#   implementation
androidx-core-ktx = { module = "androidx.core:core-ktx", version.ref = "core-ktx" }
androidx-activity-compose = { module = "androidx.activity:activity-compose", version.ref = "activity-compose" }
androidx-appcompat = { module = "androidx.appcompat:appcompat", version.ref = "appcompat" }
androidx-constraintlayout = { module = "androidx.constraintlayout:constraintlayout", version.ref = "constraintlayout" }
material = { module = "com.google.android.material:material", version.ref = "material" }

androidx-junit = { module = "androidx.test.ext:junit", version.ref = "test-junit" }
androidx-espresso-core = { module = "androidx.test.espresso:espresso-core", version.ref = "espresso-core" }
junit = { module = "junit:junit", version.ref = "junit" }

androidx-material3 = { module = "androidx.compose.material3:material3", version.ref = "material3" }
androidx-material3-android = { module = "androidx.compose.material3:material3-android", version.ref = "material3" }

androidx-ui = { module = "androidx.compose.ui:ui", version.ref = "ui" }
androidx-ui-graphics = { module = "androidx.compose.ui:ui-graphics", version.ref = "ui" }
androidx-ui-tooling-preview = { module = "androidx.compose.ui:ui-tooling-preview", version.ref = "ui" }

androidx-animation-core = { module = "androidx.compose.animation:animation-core", version.ref = "ui" }
androidx-animation = { module = "androidx.compose.animation:animation", version.ref = "ui" }
androidx-foundation = { module = "androidx.compose.foundation:foundation", version.ref = "ui" }
androidx-ui-geometry = { module = "androidx.compose.ui:ui-geometry", version.ref = "ui" }
androidx-foundation-layout = { module = "androidx.compose.foundation:foundation-layout", version.ref = "ui" }
androidx-runtime-livedata = { module = "androidx.compose.runtime:runtime-livedata", version.ref = "ui" }
androidx-ui-text = { module = "androidx.compose.ui:ui-text", version.ref = "ui" }
androidx-ui-util = { module = "androidx.compose.ui:ui-util", version.ref = "ui" }
androidx-ui-viewbinding = { module = "androidx.compose.ui:ui-viewbinding", version.ref = "ui" }

androidx-material = { module = "androidx.compose.material:material", version.ref = "compose-material" }
androidx-material-icons-core = { module = "androidx.compose.material:material-icons-core", version.ref = "compose-material" }
androidx-material-icons-extended = { module = "androidx.compose.material:material-icons-extended", version.ref = "compose-material" }

androidx-ui-test-junit4 = { module = "androidx.compose.ui:ui-test-junit4", version.ref = "ui-test-junit4" }
androidx-ui-tooling = { module = "androidx.compose.ui:ui-tooling", version.ref = "ui-test-junit4" }
androidx-ui-test-manifest = { module = "androidx.compose.ui:ui-test-manifest", version.ref = "ui-test-junit4" }

androidx-compose-bom = { module = "androidx.compose:compose-bom", version.ref = "compose-bom" }

#  Room components
androidx-room-runtime = { module = "androidx.room:room-runtime", version.ref = "room" }
androidx-room-compiler = { module = "androidx.room:room-compiler", version.ref = "room" }
androidx-room-ktx = { module = "androidx.room:room-ktx", version.ref = "room" }

#  ViewModel & LiveData
androidx-lifecycle-runtime-ktx = { module = "androidx.lifecycle:lifecycle-runtime-ktx", version.ref = "lifecycle" }
androidx-lifecycle-viewmodel-ktx = { module = "androidx.lifecycle:lifecycle-viewmodel-ktx", version.ref = "lifecycle" }
androidx-lifecycle-viewmodel-compose = { module = "androidx.lifecycle:lifecycle-viewmodel-compose", version.ref = "lifecycle" }
androidx-lifecycle-livedata-ktx = { module = "androidx.lifecycle:lifecycle-livedata-ktx", version.ref = "lifecycle" }
androidx-lifecycle-viewmodel-savedstate = { module = "androidx.lifecycle:lifecycle-viewmodel-savedstate", version.ref = "lifecycle" }
androidx-lifecycle-runtime-compose = { module = "androidx.lifecycle:lifecycle-runtime-compose", version.ref = "lifecycle" }

#  Glide
glide = { module = "com.github.bumptech.glide:glide", version.ref = "glide" }
compiler = { module = "com.github.bumptech.glide:compiler", version.ref = "glide" }

#  Retrofit
retrofit = { module = "com.squareup.retrofit2:retrofit", version.ref = "retrofit" }
retrofit-mock = { module = "com.squareup.retrofit2:retrofit-mock", version.ref = "retrofit" }

#  HTTP
okhttp = { module = "com.squareup.okhttp3:okhttp", version.ref = "okhttp" }
logging-interceptor = { module = "com.squareup.okhttp3:logging-interceptor", version.ref = "okhttp" }

#  Gson
converter-gson = { module = "com.squareup.retrofit2:converter-gson", version.ref = "converter-gson" }
gson = { module = "com.google.code.gson:gson", version.ref = "gson" }

#  Navigation Component
androidx-navigation-fragment-ktx = { module = "androidx.navigation:navigation-fragment-ktx", version.ref = "navigation" }
androidx-navigation-ui-ktx = { module = "androidx.navigation:navigation-ui-ktx", version.ref = "navigation" }

#  Paging
androidx-lifecycle-extensions = { module = "androidx.lifecycle:lifecycle-extensions", version.ref = "lifecycle-extensions" }
androidx-paging-runtime-ktx = { module = "androidx.paging:paging-runtime-ktx", version.ref = "paging-runtime-ktx" }

#  Lottie
lottie = { module = "com.airbnb.android:lottie", version.ref = "lottie" }

#  Volley
volley = { module = "com.android.volley:volley", version.ref = "volley" }

#  RecyclerView
androidx-swiperefreshlayout = { module = "androidx.swiperefreshlayout:swiperefreshlayout", version.ref = "swiperefreshlayout" }

#  Services Location
play-services-location = { module = "com.google.android.gms:play-services-location", version.ref = "play-services-location" }

#  Shimmer
shimmer = { module = "com.facebook.shimmer:shimmer", version.ref = "shimmer" }



[plugins]
androidApplication = { id = "com.android.application", version.ref = "agp" }
kotlinAndroid = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }



[bundles]
android = ["androidx-core-ktx", "androidx-activity-compose", "androidx-appcompat", "androidx-constraintlayout", "material"]
material3 = ["androidx-material3", "androidx-material3-android"]
compose = ["androidx-ui", "androidx-ui-graphics", "androidx-ui-tooling-preview", "androidx-animation-core",
    "androidx-animation", "androidx-foundation", "androidx-ui-geometry", "androidx-foundation-layout", "androidx-runtime-livedata",
    "androidx-ui-text", "androidx-ui-util", "androidx-ui-viewbinding"]
compose-material = ["androidx-material", "androidx-material-icons-core", "androidx-material-icons-extended"]
debug-implementation = ["androidx-ui-tooling", "androidx-ui-test-manifest"]
android-test-implementation = ["androidx-junit", "androidx-espresso-core", "androidx-ui-test-junit4"]
lifecycle = ["androidx-lifecycle-runtime-ktx", "androidx-lifecycle-viewmodel-ktx", "androidx-lifecycle-viewmodel-compose",
    "androidx-lifecycle-livedata-ktx", "androidx-lifecycle-viewmodel-savedstate", "androidx-lifecycle-runtime-compose"]

room = ["androidx-room-runtime", "androidx-room-ktx"]
retrofit = ["retrofit", "retrofit-mock"]
okhttp = ["okhttp", "logging-interceptor"]
gson = ["converter-gson", "gson"]
navigation-ui = ["androidx-navigation-fragment-ktx", "androidx-navigation-ui-ktx"]
paging = ["androidx-lifecycle-extensions", "androidx-paging-runtime-ktx"]


 */