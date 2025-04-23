plugins {
    id("dev.slne.surf.surfapi.gradle.paper-plugin")
}

surfPaperPluginApi {
    mainClass("dev.slne.surf.chestprotect.SurfChestProtectPaper")
    generateLibraryLoader(false)
    authors.add("Jo_field")
    authors.add("TheBjoRedCraft")
}

dependencies {
    api(libs.surf.database)
}