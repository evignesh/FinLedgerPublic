import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

private const val COMPILE_SDK_VERSION = 34
private const val MIN_SDK_VERSION = 24
private const val TARGET_SDK_VERSION = 34
private const val VERSION_CODE = 1
private const val VERSION_NAME = "1.0"
const val KOTLIN_COMPILER_EXTENSION_VERSION = "1.5.6"
private const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

internal fun Project.configureAndroidWithCompose(moduleType: ModuleType) {
    when (moduleType) {
        ModuleType.Application -> {
            project.extensions.getByType(ApplicationExtension::class.java).apply {
                compileSdk = COMPILE_SDK_VERSION
                defaultConfig {
                    applicationId = "com.evicky.financeledger"
                    minSdk = MIN_SDK_VERSION
                    targetSdk = TARGET_SDK_VERSION
                    versionCode = VERSION_CODE
                    versionName = VERSION_NAME
                    testInstrumentationRunner = TEST_INSTRUMENTATION_RUNNER
                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
                buildFeatures {
                    compose = true
                }
                composeOptions {
                    kotlinCompilerExtensionVersion = KOTLIN_COMPILER_EXTENSION_VERSION
                }
            }
        }
        ModuleType.AndroidLibrary -> {
            project.extensions.getByType(LibraryExtension::class.java).apply {
                compileSdk = COMPILE_SDK_VERSION
                defaultConfig {
                    minSdk = MIN_SDK_VERSION
                    testInstrumentationRunner = TEST_INSTRUMENTATION_RUNNER
                    consumerProguardFiles("consumer-rules.pro")
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
            }
            // compose feature is enabled only for the library modules which requires it
        }
        ModuleType.JavaOrKotlinLibrary -> {
            // No-op
        }
    }
}