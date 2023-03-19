package org.kunicki.scala3.enums.old.enumeratum

import enumeratum._

sealed abstract class Direction(name: String, bearing: Int) extends EnumEntry:
  val compassPoint: Int = (bearing / 11.25).toInt

object Direction extends Enum[Direction]:
  override val values = findValues

  case object N extends Direction("North", 0)
  case object S extends Direction("South", 180)
  case object E extends Direction("East", 90)
  case object W extends Direction("West", 270)

@main
def test: Unit =
  // parameters
  println(Direction.S.compassPoint)

  // exhaustiveness check
  def matchingTest(d: Direction) = d match
    case Direction.N => println("north")

  // look up value by name
  println(Direction.withName("N"))
  println(Direction.withNameOption("A"))

  // look up all values
  println(Direction.values)
