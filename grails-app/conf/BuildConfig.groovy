grails.work.dir = "target/workdir"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"

// Disable SCM notification
grails.release.scm.enabled = false

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        mavenCentral()
        mavenRepo "http://repo.grails.org/grails/libs-releases-local"
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

		compile('org.yaml:snakeyaml:1.8')
		compile("org.grails:grails-gdoc-engine:1.0.1") {
			excludes "jcl-over-slf4j"
		}
		compile('commons-lang:commons-lang:2.4')
		compile('com.lowagie:itext:2.1.0')
		compile('org.xhtmlrenderer:core-renderer:R8')
    }
	plugins {
		build ":rest-client-builder:1.0.2" {
			export = false
		}
		build ':release:2.0.3', {
			export = false
			excludes "rest-client-builder"
		}
	}
}
