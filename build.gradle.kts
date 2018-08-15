
plugins {
    `kotlin-dsl`
    `java-library`
    `eclipse`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    // https://mvnrepository.com/artifact/net.java.dev.jna/jna
    compileOnly ("net.java.dev.jna:jna:4.5.2")

    // Use JUnit test framework
    testImplementation("junit:junit:4.12")
}

// In this section you declare where to find the dependencies of your project
repositories {
    jcenter()
    mavenCentral()
}
