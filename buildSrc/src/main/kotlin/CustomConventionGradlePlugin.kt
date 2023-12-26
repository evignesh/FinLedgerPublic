import org.gradle.api.Plugin
import org.gradle.api.Project

enum class ModuleType {
    Application,
    AndroidLibrary,
    JavaOrKotlinLibrary
}

class ApplicationGradlePlugin: Plugin<Project> {
    override fun apply(project: Project) {
        applyCommonPlugins(project)
        project.configureAndroidWithCompose(ModuleType.Application)
    }
}

class LibraryGradlePlugin: Plugin<Project> {
    override fun apply(project: Project) {
        applyCommonPlugins(project)
        project.configureAndroidWithCompose(ModuleType.AndroidLibrary)
    }
}

internal fun applyCommonPlugins(project: Project) {
    project.apply {
        plugin("kotlin-android")
        plugin("kotlin-kapt")
    }
}

