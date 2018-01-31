package org.toolbox

import scala.io.Source
import scala.reflect.runtime.universe
import scala.tools.reflect.ToolBox

object Program extends App {
  // load script
  //compile script
  //call script method

  val source = Source.fromResource("script.text").mkString
  val tb = universe.runtimeMirror(getClass.getClassLoader).mkToolBox()

  val testClass = tb.compile(tb.parse(source))().asInstanceOf[Class[_]]
  val testClassConstructor = testClass.getDeclaredConstructors()(0)
  val instance = testClassConstructor.newInstance()
  instance.getClass.getDeclaredMethod("run").invoke(instance)


}
