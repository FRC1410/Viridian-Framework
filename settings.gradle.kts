//### DON'T TOUCH ME!!!!!, If you're here your're doing something wrong. THis file should never need to be modified ever. If you need to 
pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()

       val prefFile = File(".wpilib", "wpilib_preferences.json")
       val prefs = groovy.json.JsonSlurper().parseText(prefFile.readText()) as Map<String, Any>
       val frcYear = prefs.get("projectYear") as String
        //val frcYear = "2025"
        val os = System.getProperty("os.name").toLowerCase()

        val publicDir = if (os.startsWith("win")) {
            File(System.getenv("PUBLIC") ?: "C:\\Users\\Public")
        } else {
            File(System.getProperty("user.home"))
        }

        val frcHome = File(File(publicDir, "wpilib"), frcYear)

        // Add maven repo
        maven {
            name = "frcHome"
            url = File(frcHome, "maven").toURI()
        }
    }
}

includeBuild("build-logic")
include("framework", "robot")