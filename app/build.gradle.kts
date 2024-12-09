plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "semerci.enis.toptanc"
    compileSdk = 35

    defaultConfig {
        applicationId = "semerci.enis.toptanc"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        // Daha yeni bir extension versiyonu
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // BOM sürümünü güncelledik
    implementation(platform("androidx.compose:compose-bom:2023.10.00"))

    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.activity:activity-compose:1.9.3")

    // Compose kütüphaneleri BOM üzerinden senkronize edilecek
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // ViewModel ile Compose entegrasyonu
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

    // Diğer kütüphaneler
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("org.jsoup:jsoup:1.15.3")

    implementation("com.squareup.okhttp3:okhttp:4.9.3")

    // Retrofit 2 ve Gson Converter
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // HTML parse için (eğer kullanıyorsanız)
    implementation("org.jsoup:jsoup:1.15.3")


}