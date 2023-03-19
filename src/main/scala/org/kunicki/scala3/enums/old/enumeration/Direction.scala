package org.kunicki.scala3.enums.old.enumeration

import scala.util.Try

object Direction extends Enumeration:
  type Direction = Value

  val N, S, E, W = Value

  def withNameOption(name: String): Option[Direction] =
    Try(withName(name)).toOption

//region other enumeration

object Other extends Enumeration:
  val X = Value

// the issue with Value
def foo(x: Direction.Value) = ???

// won't compile
//def foo(x: Other.Value) = ???

//endregion

@main
def test: Unit =
  // parameters - not supported

  // exhaustiveness check
  def matchTest(d: Direction.Direction) = d match
    case Direction.N => println("north")

  // look up value by name
  println(Direction.withName("N"))
  println(Direction.withNameOption("A"))

  // look up all values
  println(Direction.values)
