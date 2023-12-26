plugins {
    id(libs.plugins.androidLibrary.get().pluginId)
}
apply<LibraryGradlePlugin>()

android {
    namespace = "com.evicky.feature"
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = KOTLIN_COMPILER_EXTENSION_VERSION
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":utility"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.libs.debug.implementation)
    androidTestImplementation(libs.bundles.compose.ui.testing)

    implementation(libs.bundles.koin)

    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.ui.testing)
}