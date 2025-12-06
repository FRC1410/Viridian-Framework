package org.frc1410.tooling.build


/**
 * Precompiled [java.gradle.kts][org.frc1410.tooling.build.Java_gradle] script plugin.
 *
 * @see org.frc1410.tooling.build.Java_gradle
 */
public
class JavaPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("org.frc1410.tooling.build.Java_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
