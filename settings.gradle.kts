pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ReturnsScanner"

include(
    ":app",
    ":domain",
    ":data",
    ":core-common",
    ":core-ui",
    ":core-database",
    ":core-ml",
    ":core-camera",
    ":feature-scan",
    ":feature-list",
    ":feature-detail",
    ":feature-export"
)
