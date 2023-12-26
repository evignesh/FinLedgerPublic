plugins {
    id(libs.plugins.androidLibrary.get().pluginId)
}
apply<LibraryGradlePlugin>()

android {
    namespace = "com.evicky.utility"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.bundles.koin)

    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.ui.testing)
}