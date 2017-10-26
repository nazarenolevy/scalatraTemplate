import sbt.Keys.{javaOptions, _}
import sbt._

object TestSettings {

  lazy val UnitTest = config("unit") extend Test
  lazy val FunctionalTest = config("fun") extend Test

  val unitTestsSettings = Seq(
    parallelExecution in UnitTest := false,
    fork in UnitTest := true,
    scalaSource in UnitTest := baseDirectory.value / "src/test/unit",
    javaOptions in UnitTest += "-Dconfig.file=" + baseDirectory.value / "src/test/resources/application.conf"
  )


  val testConfigs = Seq(UnitTest)

  private val allTestsBaseSettings = testConfigs.flatMap(config => inConfig(config)(Defaults.testSettings))

  val allTestSettings = allTestsBaseSettings ++ TestSettings.unitTestsSettings

}
