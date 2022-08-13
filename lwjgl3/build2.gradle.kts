

buildscript {
    repositories {
        mavenCentral()
        maven { url 'https://s01.oss.sonatype.org' }
        mavenLocal()
        google()
        gradlePluginPortal()
        maven { url 'https://oss.sonatype.org/content/repositories/snapshots/' }
        maven { url 'https://s01.oss.sonatype.org/content/repositories/snapshots/' }
    }
    dependencies {
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        classpath "org.wisepersist:gwt-gradle-plugin:$gwtPluginVersion"

        // This follows advice from https://blog.gradle.org/log4j-vulnerability
        constraints {
            classpath("org.apache.logging.log4j:log4j-core") {
                version {
                    strictly("[2.17, 3[")
                    prefer("2.17.0")
                }
                because("CVE-2021-44228, CVE-2021-45046, CVE-2021-45105: Log4j vulnerable to remote code execution and other critical security vulnerabilities")
            }
        }
    }
}

allprojects {
    apply plugin: 'eclipse'
    apply plugin: 'idea'
}

configure(subprojects) {
    apply plugin: 'java-library'
    apply plugin: 'kotlin'
    sourceCompatibility = 17
    compileJava {
        options.incremental = true
    }
    dependencies {
        // This follows advice from https://blog.gradle.org/log4j-vulnerability
        constraints {
            implementation("org.apache.logging.log4j:log4j-core") {
                version {
                    strictly("[2.17, 3[")
                    prefer("2.17.0")
                }
                because("CVE-2021-44228, CVE-2021-45046, CVE-2021-45105: Log4j vulnerable to remote code execution and other critical security vulnerabilities")
            }
        }
    }

}

subprojects {
    version = '0.0.1'
    ext.appName = 'carotcardskt'
    repositories {
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
        maven { url 'https://s01.oss.sonatype.org' }
        maven { url 'https://oss.sonatype.org/content/repositories/snapshots/' }
        maven { url 'https://s01.oss.sonatype.org/content/repositories/snapshots/' }
        maven { url 'https://jitpack.io' }
    }
}

eclipse.project.name = 'carotcardskt' + '-parent'
