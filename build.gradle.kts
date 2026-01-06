plugins {
// These lines should never read apply true ON THE FRAMEWORK, they should only be true if this is the robot project for the year(i.e. Rebuilt2026)    
    id("org.frc1410.tooling.build.java") apply false    
    id("edu.wpi.first.GradleRIO") version "2025.3.2" apply false
}

allprojects {
    group = "org.frc1410"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.frc1410.tooling.build.java")
}