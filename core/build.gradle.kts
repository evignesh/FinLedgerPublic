plugins {
    id(libs.plugins.androidLibrary.get().pluginId)
    id(libs.plugins.kotlinParcelize.get().pluginId)
}
apply<LibraryGradlePlugin>()

android {
    namespace = "com.evicky.core"
}

dependencies {
    implementation(project(":utility"))

    implementation(libs.androidx.core.ktx)

    implementation(libs.bundles.koin)

//    implementation(platform(libs.firebaseBom))
//    implementation(libs.firestore)

    implementation(libs.kotlinxSerializationJson)

    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.ui.testing)
}