plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.0.0"
}

group = "dev.marfien"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("com.github.tomas-langer.cli:cli-progress:1.0.0")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "dev.marfien.thelistener.TheListener"
    }
}

tasks.register("install") {
    dependsOn(tasks.shadowJar)
    doLast {
        copy {
            from(tasks.shadowJar.get().archiveFile)
            into("/opt/thelistener/bin/")
            rename { "the-listener.jar" }
        }
    }
    doLast {
        copy {
            from("src/main/shell/listen")
            into("/usr/local/sbin/")
        }
    }
}