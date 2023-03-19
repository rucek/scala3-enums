package org.kunicki.scala3.enums

import scala.util.Try

enum Direction(name: String, val bearing: Int) extends Enum[Direction]:
  case N extends Direction("North", 0)
  case S extends Direction("South", 180)
  case E extends Direction("East", 90)
  case W extends Direction("West", 270)

  def compassPoint: Int = (bearing / 11.25).toInt

object Direction:
  def withNameOption(name: String) = Try(Direction.valueOf(name)).toOption

@main
def test: Unit =
  // parameters
  println(Direction.S.compassPoint)

  // exhaustiveness check
  def matchingTest(d: Direction) = d match
    case Direction.N => println("north")

  // look up value by name
  println(Direction.valueOf("N"))
  println(Direction.withNameOption("A"))

  // look up all values
  println(Direction.values.toSet)
