import dev.slne.surf.surfapi.gradle.util.withSurfApiBukkit

plugins {
    id("dev.slne.surf.surfapi.gradle.paper-plugin")
}

surfPaperPluginApi {
    mainClass("dev.slne.surf.chestprotect.SurfChestProtectPaper")
    generateLibraryLoader(false)
    authors.add("Jo_field")

    runServer {
        withSurfApiBukkit()
    }
}

dependencies {
    api(libs.surf.database)
}