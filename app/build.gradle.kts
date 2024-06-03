plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.garon"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.garon"
        minSdk = 24
        targetSdk = 34
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    // 뷰 바인딩 활성화
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation ("jakarta.persistence:jakarta.persistence-api:3.0.0")
    implementation ("org.hibernate.orm:hibernate-core:5.6.3.Final")
    annotationProcessor ("org.projectlombok:lombok:1.18.20")

    implementation ("org.springframework.boot:spring-boot-starter-web")
    compileOnly ("org.projectlombok:lombok")
    annotationProcessor ("org.projectlombok:lombok")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")

    // DB 연동 라이브러리
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.mariadb.jdbc', name: 'mariadb-java-client', version: '2.4.1'")



}
