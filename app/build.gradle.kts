plugins {
    id("com.android.application") //version "7.2.1"
    id("org.jetbrains.kotlin.android") //version "1.6.10"
    id("kotlin-kapt")
    id("kotlin-android-extensions")
    id("org.jetbrains.dokka")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.pix.dokkademo"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility =  JavaVersion.VERSION_1_8
        targetCompatibility =  JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }
}

tasks {
    val dokkaOutputDir = "${project.buildDir}/dokka"
    dokkaHtml {
        moduleName.set("dokka android demo api")
        outputDirectory.set(file(dokkaOutputDir))
    }
    register<Jar>("javadocJar") {
        archiveClassifier.set("javadoc")
        dependsOn(dokkaHtml)
        from(dokkaOutputDir)
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("org.jetbrains.dokka:android-documentation-plugin:1.7.10")
    implementation("org.jetbrains.dokka:kotlin-as-java-plugin:1.7.10")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}