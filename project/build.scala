
import sbt._
import Keys._

import com.github.siasia.WebPlugin

object LiftPlayground extends Build {
    lazy val root = (
        Project("root", file("."))
        settings(
            name := "lift-playground",

            scalaVersion := "2.9.1",
            
            // This is where you'd set the log level. Believe it or not this is
            // not very useful.
            // logLevel := Level.Debug,
            
            // Oh how I wish...
            scalaSource in Compile <<= baseDirectory(_ / "code"),
            
            scalacOptions ++= Seq(
                    "-deprecation",
                    "-unchecked"
                ),

            libraryDependencies ++= Seq(
                "net.liftweb" % "lift-webkit_2.9.0" % "2.4-M3" % "compile->default",
                "net.liftweb" % "lift-openid_2.9.0" % "2.4-M3",
                "org.mortbay.jetty" % "jetty" % "6.1.22" % "jetty",
                "junit" % "junit" % "4.5" % "test->default",
                "org.scala-tools.testing" % "specs_2.9.0" % "1.6.8" % "test->default",
                "org.slf4j" % "slf4j-simple" % "1.6.1",
                "com.h2database" % "h2" % "1.3.159",
                "org.squeryl" % "squeryl_2.9.0" % "0.9.4"
            )
        )
        settings(
            WebPlugin.webSettings: _*
        )
        dependsOn matteform
    )
    
    lazy val matteform = RootProject(file("../matteform"))
}

