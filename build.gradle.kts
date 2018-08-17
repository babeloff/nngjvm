
plugins {
    `kotlin-dsl`
    `java-library`
    `eclipse`
    `idea`
    `maven-publish`
    `signing`
}

group = "babeloff"
version = "2018.08.20"

val sourcesJar by tasks.creating(Jar::class) {
    classifier = "sources"
    from(java.sourceSets["main"].allSource)
}

// val javadocJar by tasks.creating(Jar::class) {) {
//     classifier = "javadoc"
//     from(javadoc)
// }

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

publishing {
    (publications) {
        "nngjvm" (MavenPublication::class) {
            from(components ["java"])
            artifact(sourcesJar)
            pom {
                description = "JNA wrapped NNG"
                groupId = "babeloff"
                artifactId = "nngjvm"
                version = "2018.08.20"
            }
        }
    }
    repositories {
        maven  {
            var releasesRepoUrl = uri("$buildDir/repos/releases")
            var snapshotsRepoUrl = uri("$buildDir/repos/snapshots")
            url = if (version.toString().endsWith("SNAPSHOT",true))
                    snapshotsRepoUrl; else releasesRepoUrl;
        }
    }
}


dependencies {
    // https://mvnrepository.com/artifact/net.java.dev.jna/jna
    compileOnly ("net.java.dev.jna:jna:4.5.2")
    compileOnly ("com.nativelibs4java:bridj:0.7.0")

    // Use JUnit test framework
    testImplementation("junit:junit:4.12")
}

// In this section you declare where to find the dependencies of your project
repositories {
    jcenter()
    mavenCentral()
    mavenLocal()
}

//signing {
//    sign publishing.publications.mavenJava
//}


//javadoc {
//    if(JavaVersion.current().isJava9Compatible()) {
//        options.addBooleanOption("html5", true)
//    }
//}