plugins {
//    alias(libs.plugins.androidApplication) apply false
//    alias(libs.plugins.kotlinAndroid) apply false

    id("com.android.application") version "8.1.2" apply false
    id("com.android.library") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false


    //  id("org.jetbrains.kotlin.android") version "1.9.0" apply false  //        kotlinCompilerExtensionVersion = "1.5.1"
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
}
