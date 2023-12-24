plugins {
//    alias(libs.plugins.application)
//    alias(libs.plugins.kotlinAndroid)
//    alias(libs.plugins.ksp)
//    alias(libs.plugins.hiltAndroid)

    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")   // ksp
//    id("kotlin-kapt")   // kapt
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.dinesh.android"
    compileSdk = 34
//    compileSdkPreview = "UpsideDownCake"

//    signingConfigs {
//        create("release"){
//            storeFile = file("${rootProject.projectDir}/dinesh28-release-key.jks")
//            storePassword = "dinesh28Android"
//            keyAlias = "dinesh28-key-alias"
//            keyPassword = "dinesh28Android"
//        }
//        getByName("debug") {
//            storeFile = file("${rootProject.projectDir}/dinesh28-release-key.jks")
//            storePassword = "dinesh28Android"
//            keyAlias = "dinesh28-key-alias"
//            keyPassword = "dinesh28Android"
//        }
//    }

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
//            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            testCoverage {
                enableUnitTestCoverage = false
                enableAndroidTestCoverage = false
            }
        }
        debug {
//            signingConfig = signingConfigs.getByName("debug")
//            applicationIdSuffix = ".debug"
            isMinifyEnabled = false
            isShrinkResources = false
            testCoverage {
                enableUnitTestCoverage = true
                enableAndroidTestCoverage = true
            }
        }
    }

//    flavorDimensions.add("versions")
//    productFlavors {
//        create("freeVersion") {     //  if (BuildConfig.FLAVOR == "freeVersion")
//            dimension = "versions"
//            applicationIdSuffix = ".free"
////            applicationId = "com.dinesh.free"
////            versionNameSuffix = "-free"
//        }
//        create("paidVersion") {
//            dimension = "versions"
//            applicationIdSuffix = ".paid"
////            applicationId = "com.dinesh.paid"
////            versionNameSuffix = "-paid"
//        }
//    }

//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_17
//        targetCompatibility = JavaVersion.VERSION_17
//    }
//    kotlinOptions {
//        jvmTarget = JavaVersion.VERSION_17.toString()
//    }
    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    lint {
        //  https://developer.android.com/studio/write/lint#snapshot
        baseline = file("lint-baseline.xml")

        disable += "TypographyFractions" + "TypographyQuotes"
        enable += "RtlHardcoded" + "RtlCompat" + "RtlEnabled"
        checkOnly += "NewApi" + "InlinedApi"
        // If set to true, turns off analysis progress reporting by lint.
        quiet = true
        // If set to true (default), stops the build if errors are found.
        abortOnError = false
        // If set to true, lint only reports errors.
        ignoreWarnings = true
        // If set to true, lint also checks all dependencies as part of its analysis.
        // Recommended for projects consisting of an app with library dependencies.
        checkDependencies = true
    }

}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.11.0")

    implementation("androidx.compose.material3:material3:1.2.0-beta01")
    implementation("androidx.compose.material3:material3-android:1.2.0-beta01")
    implementation("androidx.compose.material3:material3-window-size-class:1.2.0-beta01")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

//    val composeVersion = "1.5.4"
    val composeVersion = "1.6.0-beta03"
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-graphics:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.ui:ui-geometry:$composeVersion")
    implementation("androidx.compose.foundation:foundation-layout:$composeVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation("androidx.compose.animation:animation-core:$composeVersion")
    implementation("androidx.compose.animation:animation:$composeVersion")
    implementation("androidx.compose.ui:ui-text:$composeVersion")
    implementation("androidx.compose.ui:ui-util:$composeVersion")
    implementation("androidx.compose.ui:ui-viewbinding:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.material:material-icons-core:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")

    // androidTestImplementation
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    // testImplementation
    testImplementation("junit:junit:4.13.2")

    // debugImplementation
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")


    //  Room components    	2.5.2   -->  2.6.0-alpha03
    implementation("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    //  ViewModel & LiveData
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.6.2")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:retrofit-mock:2.9.0")

    // Gson
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Gson Converter
    implementation("com.google.code.gson:gson:2.10.1") // Used to convert Java Object into JSON representation

    // HTTP
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.12")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.12")

    // Chucker
    debugImplementation("com.github.chuckerteam.chucker:library:4.0.0")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:4.0.0")

    // Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    implementation("androidx.navigation:navigation-compose:2.7.6")  // Navigation Compose

    // Paging
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.paging:paging-runtime-ktx:3.2.1")

    // Animation
    implementation("com.airbnb.android:lottie:6.2.0")   // Lottie
    implementation("com.facebook.shimmer:shimmer:0.5.0")    //  Shimmer

    // Location Services
    implementation("com.google.android.gms:play-services-location:21.0.1")

    // RecyclerView
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // Volley
    implementation("com.android.volley:volley:1.2.1")

    //  Dagger
    implementation("com.google.dagger:dagger:2.50")
    implementation("com.google.dagger:dagger-android:2.50")
    implementation("com.google.dagger:dagger-android-support:2.50")
    ksp("com.google.dagger:dagger-compiler:2.50")

    //  Hilt
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    implementation("com.google.dagger:hilt-android:2.50")
    ksp("com.google.dagger:hilt-android-compiler:2.50")
    ksp("androidx.hilt:hilt-compiler:1.1.0")

    // WorkManager
    implementation("androidx.work:work-runtime-ktx:2.9.0")
}


/*

dependencies {
    implementation(libs.bundles.android)
    implementation(libs.bundles.compose)
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))

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

    // Gson
    implementation(libs.bundles.gson)

    // HTTP
    implementation(libs.bundles.okhttp)

    // Chucker
    debugImplementation(libs.chucker.debug)
    releaseImplementation(libs.chucker.release)

    // Navigation Component
    implementation(libs.bundles.navigation)

    // Paging
    implementation(libs.bundles.paging)

    // Animation
    implementation(libs.bundles.animation)

    // Location Services
    implementation(libs.play.services.location)

    // RecyclerView
    implementation(libs.androidx.swiperefreshlayout)

    // Volley
    implementation(libs.volley)

    androidTestImplementation(libs.bundles.android.test)
    debugImplementation(libs.bundles.debug)
    testImplementation(libs.bundles.test)

    //  Dagger
    implementation(libs.bundles.dagger)
    ksp(libs.dagger.compiler)

    //  Hilt
    implementation(libs.bundles.hilt)
    ksp(libs.bundles.hilt.compiler)

    // WorkManager
    implementation(libs.work.manager)
}

 */

/*
[versions]
agp = "8.2.0"
kotlin = "1.9.22"
ksp = "1.9.21-1.0.16"
hilt = "2.50"

core-ktx = "1.12.0"
activity-compose = "1.8.2"
appcompat = "1.6.1"
constraintlayout = "2.1.4"
material = "1.11.0"

material3 = "1.2.0-beta01"
kotlinx-coroutines = "1.7.3"

compose-bom = "2023.10.01"
#compose = "1.5.4"
compose = "1.6.0-beta03"

test-junit = "1.1.5"
espresso-core = "3.5.1"
junit = "4.13.2"

room = "2.6.1"
lifecycle = "2.6.2"
glide = "4.16.0"
retrofit = "2.9.0"
okhttp = "5.0.0-alpha.12"
chucker = "4.0.0"

converter-gson = "2.9.0"
gson = "2.10.1"

navigation = "2.7.6"
lottie = "6.2.0"
volley = "1.2.1"
swiperefreshlayout = "1.1.0"

lifecycle-extensions = "2.2.0"
paging-runtime-ktx = "3.2.1"

play-services-location = "21.0.1"
shimmer = "0.5.0"

dagger = "2.50"

hilt-android = "2.50"
hilt-compiler = "1.1.0"

work-manager = "2.9.0"


[libraries]
#   implementation
androidx-core-ktx = { module = "androidx.core:core-ktx", version.ref = "core-ktx" }
androidx-activity-compose = { module = "androidx.activity:activity-compose", version.ref = "activity-compose" }
androidx-appcompat = { module = "androidx.appcompat:appcompat", version.ref = "appcompat" }
androidx-constraintlayout = { module = "androidx.constraintlayout:constraintlayout", version.ref = "constraintlayout" }
material = { module = "com.google.android.material:material", version.ref = "material" }

androidx-material3 = { module = "androidx.compose.material3:material3", version.ref = "material3" }
androidx-material3-android = { module = "androidx.compose.material3:material3-android", version.ref = "material3" }
androidx-material3-window-size = { module = "androidx.compose.material3:material3-window-size-class", version.ref = "material3" }

kotlinx-coroutines = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-android", version.ref = "kotlinx-coroutines" }

androidx-compose-bom = { module = "androidx.compose:compose-bom", version.ref = "compose-bom" }
androidx-ui = { module = "androidx.compose.ui:ui", version.ref = "compose" }
androidx-ui-graphics = { module = "androidx.compose.ui:ui-graphics", version.ref = "compose" }
androidx-ui-tooling-preview = { module = "androidx.compose.ui:ui-tooling-preview", version.ref = "compose" }
androidx-foundation = { module = "androidx.compose.foundation:foundation", version.ref = "compose" }
androidx-ui-geometry = { module = "androidx.compose.ui:ui-geometry", version.ref = "compose" }
androidx-foundation-layout = { module = "androidx.compose.foundation:foundation-layout", version.ref = "compose" }
androidx-runtime-livedata = { module = "androidx.compose.runtime:runtime-livedata", version.ref = "compose" }
androidx-animation-core = { module = "androidx.compose.animation:animation-core", version.ref = "compose" }
androidx-animation = { module = "androidx.compose.animation:animation", version.ref = "compose" }
androidx-ui-text = { module = "androidx.compose.ui:ui-text", version.ref = "compose" }
androidx-ui-util = { module = "androidx.compose.ui:ui-util", version.ref = "compose" }
androidx-ui-viewbinding = { module = "androidx.compose.ui:ui-viewbinding", version.ref = "compose" }
androidx-material = { module = "androidx.compose.material:material", version.ref = "compose" }
androidx-material-icons-core = { module = "androidx.compose.material:material-icons-core", version.ref = "compose" }
androidx-material-icons-extended = { module = "androidx.compose.material:material-icons-extended", version.ref = "compose" }

#  androidTestImplementation
androidx-ui-test-junit4 = { module = "androidx.compose.ui:ui-test-junit4", version.ref = "compose" }
androidx-espresso-core = { module = "androidx.test.espresso:espresso-core", version.ref = "espresso-core" }
androidx-junit = { module = "androidx.test.ext:junit", version.ref = "test-junit" }

#  testImplementation
junit = { module = "junit:junit", version.ref = "junit" }

#  debugImplementation
androidx-ui-tooling = { module = "androidx.compose.ui:ui-tooling", version.ref = "compose" }
androidx-ui-test-manifest = { module = "androidx.compose.ui:ui-test-manifest", version.ref = "compose" }

#  ViewModel & LiveData
androidx-lifecycle-runtime-ktx = { module = "androidx.lifecycle:lifecycle-runtime-ktx", version.ref = "lifecycle" }
androidx-lifecycle-viewmodel-ktx = { module = "androidx.lifecycle:lifecycle-viewmodel-ktx", version.ref = "lifecycle" }
androidx-lifecycle-viewmodel-compose = { module = "androidx.lifecycle:lifecycle-viewmodel-compose", version.ref = "lifecycle" }
androidx-lifecycle-livedata-ktx = { module = "androidx.lifecycle:lifecycle-livedata-ktx", version.ref = "lifecycle" }
androidx-lifecycle-viewmodel-savedstate = { module = "androidx.lifecycle:lifecycle-viewmodel-savedstate", version.ref = "lifecycle" }
androidx-lifecycle-runtime-compose = { module = "androidx.lifecycle:lifecycle-runtime-compose", version.ref = "lifecycle" }

#  Room components
androidx-room-runtime = { module = "androidx.room:room-runtime", version.ref = "room" }
androidx-room-compiler = { module = "androidx.room:room-compiler", version.ref = "room" }
androidx-room-ktx = { module = "androidx.room:room-ktx", version.ref = "room" }

#  Glide
glide = { module = "com.github.bumptech.glide:glide", version.ref = "glide" }
compiler = { module = "com.github.bumptech.glide:compiler", version.ref = "glide" }

#  Retrofit
retrofit = { module = "com.squareup.retrofit2:retrofit", version.ref = "retrofit" }
retrofit-mock = { module = "com.squareup.retrofit2:retrofit-mock", version.ref = "retrofit" }

#  Gson
converter-gson = { module = "com.squareup.retrofit2:converter-gson", version.ref = "converter-gson" }
gson = { module = "com.google.code.gson:gson", version.ref = "gson" }

#  HTTP
okhttp = { module = "com.squareup.okhttp3:okhttp", version.ref = "okhttp" }
logging-interceptor = { module = "com.squareup.okhttp3:logging-interceptor", version.ref = "okhttp" }

#  Chucker
chucker-debug = { module = "com.github.chuckerteam.chucker:library", version.ref = "chucker" }
chucker-release = { module = "com.github.chuckerteam.chucker:library-no-op", version.ref = "chucker" }

#  Navigation Component
androidx-navigation-fragment-ktx = { module = "androidx.navigation:navigation-fragment-ktx", version.ref = "navigation" }
androidx-navigation-ui-ktx = { module = "androidx.navigation:navigation-ui-ktx", version.ref = "navigation" }
androidx-navigation-compose = { module = "androidx.navigation:navigation-compose", version.ref = "navigation" }

#  Paging
androidx-lifecycle-extensions = { module = "androidx.lifecycle:lifecycle-extensions", version.ref = "lifecycle-extensions" }
androidx-paging-runtime-ktx = { module = "androidx.paging:paging-runtime-ktx", version.ref = "paging-runtime-ktx" }

#  Animation
lottie = { module = "com.airbnb.android:lottie", version.ref = "lottie" }   # Lottie
shimmer = { module = "com.facebook.shimmer:shimmer", version.ref = "shimmer" }  # Shimmer

#  Location Services
play-services-location = { module = "com.google.android.gms:play-services-location", version.ref = "play-services-location" }

#  RecyclerView
androidx-swiperefreshlayout = { module = "androidx.swiperefreshlayout:swiperefreshlayout", version.ref = "swiperefreshlayout" }

#  Volley
volley = { module = "com.android.volley:volley", version.ref = "volley" }

#  Dagger
dagger = { module = "com.google.dagger:dagger", version.ref = "dagger" }
dagger-compiler = { module = "com.google.dagger:dagger-compiler", version.ref = "dagger" }
dagger-android-support = { module = "com.google.dagger:dagger-android-support", version.ref = "dagger" }
dagger-android = { module = "com.google.dagger:dagger-android", version.ref = "dagger" }

#  Hilt
hilt-android = { module = "com.google.dagger:hilt-android", version.ref = "hilt-android" }
androidx-hilt-navigation-compose = { module = "androidx.hilt:hilt-navigation-compose", version.ref = "hilt-compiler" }
hilt-android-compiler = { module = "com.google.dagger:hilt-android-compiler", version.ref = "hilt-android" }
hilt-compiler = { module = "androidx.hilt:hilt-compiler", version.ref = "hilt-compiler" }

#  WorkManager
work-manager = { module = "androidx.work:work-runtime-ktx", version.ref = "work-manager" }


[plugins]
application = { id = "com.android.application", version.ref = "agp" }
library = { id = "com.android.library", version.ref = "agp" }
kotlinAndroid = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
ksp = { id = "com.google.devtools.ksp", version.ref = "ksp" }
hiltAndroid = { id = "com.google.dagger.hilt.android", version.ref = "hilt" }



[bundles]
android = ["androidx-core-ktx", "androidx-activity-compose", "androidx-appcompat", "androidx-constraintlayout", "material",
    "androidx-material3", "androidx-material3-android", "androidx-material3-window-size", "kotlinx-coroutines"]

compose = ["androidx-ui", "androidx-ui-graphics", "androidx-ui-tooling-preview", "androidx-foundation",
    "androidx-ui-geometry", "androidx-foundation-layout", "androidx-runtime-livedata", "androidx-animation-core",
    "androidx-animation", "androidx-ui-text", "androidx-ui-util", "androidx-ui-viewbinding", "androidx-material",
    "androidx-material-icons-core", "androidx-material-icons-extended"]

lifecycle = ["androidx-lifecycle-runtime-ktx", "androidx-lifecycle-viewmodel-ktx", "androidx-lifecycle-viewmodel-compose",
    "androidx-lifecycle-livedata-ktx", "androidx-lifecycle-viewmodel-savedstate", "androidx-lifecycle-runtime-compose"]

room = ["androidx-room-runtime", "androidx-room-ktx"]
retrofit = ["retrofit", "retrofit-mock"]
gson = ["converter-gson", "gson"]
okhttp = ["okhttp", "logging-interceptor"]
navigation = ["androidx-navigation-fragment-ktx", "androidx-navigation-ui-ktx", "androidx-navigation-compose"]
paging = ["androidx-lifecycle-extensions", "androidx-paging-runtime-ktx"]
animation = ["lottie", "shimmer"]

android-test = ["androidx-ui-test-junit4", "androidx-espresso-core", "androidx-junit"]
debug = ["androidx-ui-tooling", "androidx-ui-test-manifest"]
test = ["junit"]

dagger = ["dagger", "dagger-android-support", "dagger-android"]

hilt = ["hilt-android", "androidx-hilt-navigation-compose"]
hilt-compiler = ["hilt-android-compiler", "hilt-compiler"]

 */