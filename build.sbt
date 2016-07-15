import ScalaxbKeys._

lazy val commonSettings = Seq(
  organization  := "ch.bsisa.hyperbird",
//  scalaVersion  := "2.11.7"
  scalaVersion  := "2.10.6"
)

lazy val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.0.2"
lazy val scalaParser = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1"
lazy val dispatchV = "0.11.2"
lazy val dispatch = "net.databinder.dispatch" %% "dispatch-core" % dispatchV

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name          := "hb-geoxml",
    libraryDependencies ++= Seq(dispatch),
    libraryDependencies ++= {
      if (scalaVersion.value startsWith "2.11") Seq(scalaXml, scalaParser)
      else Seq()
    }).
  settings(scalaxbSettings: _*).
  settings(
    sourceGenerators in Compile += (scalaxb in Compile).taskValue,
    dispatchVersion in (Compile, scalaxb) := dispatchV,
    async in (Compile, scalaxb)           := true,

    contentsSizeLimit in (Compile, scalaxb) := 20, // Can be removed with Scala 2.11.x
    namedAttributes in (Compile, scalaxb) := true, // Can be removed with Scala 2.11.x

    packageName in (Compile, scalaxb)     := "ch.bsisa.hyperbird.model",
    protocolFileName in scalaxb in Compile := "geoXmlProtocol.scala",
    protocolPackageName in scalaxb in Compile := Option("ch.bsisa.hyperbird.model.proto")
    // packageNames in (Compile, scalaxb)    := Map(uri("http://schemas.microsoft.com/2003/10/Serialization/") -> "microsoft.serialization"),
    // logLevel in (Compile, scalaxb) := Level.Debug 
  )
