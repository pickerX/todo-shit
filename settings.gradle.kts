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

rootProject.name = "todo-shit"
include(
    ":app",
    ":model",
    ":feature:home",
    ":data:api",
    ":data:database",
    ":data:repository",
    ":base"
)