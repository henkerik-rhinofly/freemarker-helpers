resolvers ++= Seq(
  "http://cfmlprojects.org/artifacts/" at "http://cfmlprojects.org/artifacts/",
  "Rhinofly public Release Repository" at "http://maven-repository.rhinofly.net:8081/artifactory/libs-release-local",
  "Rhinofly public Snapshot Repository" at "http://maven-repository.rhinofly.net:8081/artifactory/libs-snapshot-local"
)

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

version := "0.2.0-SNAPSHOT"

name := "freemarker-helpers"

organization := "nl.rhinofly.railo"

libraryDependencies in Global ++= Seq("javax.servlet" % "javax.servlet-api" % "3.0.1",
   "org.eclipse.jetty" % "jetty-servlet" % "9.0.3.v20130506",
   "org.eclipse.jetty" % "jetty-webapp" % "9.0.3.v20130506",
   "org.getrailo" % "railo" % "4.3.0.001",
   "org.getrailo" % "railo-rc" % "4.3.0.001",
   "org.mortbay.jetty" % "jsp-2.1-glassfish" % "2.1.v20100127",
   "org.fusesource.jansi" % "jansi" % "1.11",
   "org.freemarker" % "freemarker" % "2.3.20"
  )

classpathTypes += "rc"

crossPaths := false

publishTo <<= version { (v: String) =>
  val rhinofly = "http://maven-repository.rhinofly.net:8081/artifactory/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at rhinofly + "libs-snapshot-local")
  else
    Some("releases"  at rhinofly + "libs-release-local")
}