/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java library project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.5.1/userguide/building_java_projects.html
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:23.0.0")
    implementation(files("/Users/ignatov/src/toolbox/feature/gateway-plugin-api/build/classes/java/main/"))
}

//val generateJson = tasks.register<DefaultTask>("generateJson") {
//    val project = project.rootProject
//
//    val ext = Extension(
//        id = project.name,
//        version = project.version.toString(),
//        meta = Meta(
//            readableName = "Chunga Change",
//            description = "Chunga Changa plugin",
//            vendor = "JetBrains",
//        ),
//        compatibleVersionRange = CompatibleVersionRange(
//            from = "1.1",
//            to = "1.2",
//        )
//    )
//    val outputFile = File("${project.buildDir}/generated-json/extension.json")
//    outputFile.parentFile.mkdirs()
//    outputFile.writeText(ext.toJson())
//}

version = "0.4"

tasks.register<Zip>("createZip") {
    dependsOn(tasks.assemble)
    val compileClasspath = configurations.compileClasspath
    from(compileClasspath.get().files.filter { it.extension == "jar" })
    val name = "${rootProject.name}-${rootProject.version}"
    from(file("${rootProject.buildDir}/libs/$name.jar"))
    from(file("src/main/resources/icon.svg"))
    from(file("src/main/resources/extension.json"))
    archiveFileName.set("$name.zip")
    destinationDirectory.set(file("$buildDir/libs"))
}