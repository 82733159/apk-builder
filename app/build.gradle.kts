plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.exthost"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.exthost"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            // keep debug simple
        }
    }

    buildFeatures {
        viewBinding = true
    }

    packaging {
        // keep extension files intact
        resources {
            excludes += setOf("META-INF/**")
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.webkit:webkit:1.10.0")
}

/* ---- Auto-added by CI fix ---- */
android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
/* ---- End CI fix ---- */
