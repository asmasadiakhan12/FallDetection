plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    signingConfigs {
        create("release") {
            storeFile = file("C:\\Users\\User\\AndroidStudioProjects\\SensorAcc\\myfirstapk.jks")
            storePassword = "123456"
            keyAlias = "key0"
            keyPassword = "123456"
        }
    }
    namespace = "com.example.sensoracc"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.sensoracc"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    packagingOptions {
        resources {
            excludes += setOf(
                "META-INF/INDEX.LIST",
                "META-INF/DEPENDENCIES",
                "META-INF/NOTICE",
                "META-INF/LICENSE",
                "META-INF/LICENSE.txt",
                "META-INF/NOTICE.txt",
                "google/protobuf/type.proto",
                "google/protobuf/field_mask.proto"
            )
        }
    }
}

dependencies {
    implementation("com.google.cloud:google-cloud-pubsub:1.113.7") {
        exclude(group = "com.google.protobuf", module = "protobuf-javalite")
    }
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.22")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.activity:activity-ktx:1.6.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("org.apache.commons:commons-math3:3.6.1")
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation("com.google.guava:guava:30.1.1-android")
    implementation("io.grpc:grpc-okhttp:1.42.1")
    implementation("io.grpc:grpc-protobuf:1.42.1")
    implementation("io.grpc:grpc-stub:1.42.1")
    implementation("io.grpc:grpc-auth:1.42.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
    implementation("com.google.auth:google-auth-library-oauth2-http:1.4.0") {
        exclude(group = "com.google.protobuf", module = "protobuf-javalite")
    }
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.2")
        classpath(kotlin("gradle-plugin", version = "1.8.22"))
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}


