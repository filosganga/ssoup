import sbt._
import Keys._
import java.net.URL

object SSoup extends Build {
   
   val project = (Project("ssoup", file(".")) settings(
     organization := "org.filippodeluca.ssoup",
     name := "ssoup",
     version := "1.0-SNAPSHOT",
     scalaVersion := "2.10.1",
     licenses := Seq("Apache License, Version 2.0"->new URL("http://www.apache.org/licenses/LICENSE-2.0.html")),
     libraryDependencies ++= dependencies,
     autoCompilerPlugins := true
   ) settings(publishSettings:_*))
   
   def publishSettings: Seq[Setting[_]] = Seq(
     // If we want on maven central, we need to be in maven style.
     publishMavenStyle := true,
     publishArtifact in Test := false,
     // The Nexus repo we're publishing to.
     publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository"))),
     // Maven central cannot allow other repos.  We're ok here because the artifacts we
     // we use externally are *optional* dependencies.
     pomIncludeRepository := { x => false },
     // Maven central wants some extra metadata to keep things 'clean'.
     pomExtra := (
 	    <licenses>
 		    <license>
 			    <name>Apache License, Version 2.0</name>
 			    <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
 			    <distribution>repo</distribution>
 		    </license>
 	    </licenses>
       <scm>
         <url>git@github.com:filosganga/scala-wurfl.git</url>
         <connection>scm:git:git@github.com:filosganga/scala-wurfl.git</connection>
       </scm>
       <developers>
         <developer>
           <id>filosganga</id>
           <name>Filippo De Luca</name>
           <url>http://filippodeluca.com</url>
         </developer>
       </developers>)
   )
   
   def dependencies = Seq(
     "org.jsoup" % "jsoup" % "1.7.2",

     "org.specs2" % "specs2_2.10" % "1.14" % "test",
     "org.mockito" % "mockito-all" % "1.9.0" % "test"
   )
   
   
}