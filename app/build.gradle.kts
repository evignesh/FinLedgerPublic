plugins {
    id(libs.plugins.androidApplication.get().pluginId)
}
apply<ApplicationGradlePlugin>()

android {
    namespace = "com.evicky.financeledger"
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":feature"))
    implementation(project(":core"))
    implementation(project(":utility"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.libs.debug.implementation)
    androidTestImplementation(libs.bundles.compose.ui.testing)

    implementation(libs.bundles.koin)

    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.ui.testing)
}