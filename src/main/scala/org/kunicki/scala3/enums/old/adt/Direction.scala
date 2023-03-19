package org.kunicki.scala3.enums.old.adt

sealed abstract class Direction(val name: String, val bearing: Int):
  val compassPoint: Int = (bearing / 11.25).toInt

object Direction:
  case object N extends Direction("North", 0)

  case object S extends Direction("South", 180)

  case object E extends Direction("East", 90)

  case object W extends Direction("West", 270)

  val values: Set[Direction] = Set(N, S, E, W)

  private val byName =
    values.map(d => (d.getClass.getSimpleName.stripSuffix("$"), d)).toMap

  def withName(name: String): Direction = byName(name)
  def withNameOption(name: String): Option[Direction] = byName.get(name)

@main
def test: Unit =
  // parameters
  println(Direction.S.compassPoint)

  // exhaustiveness check
  def matchTest(d: Direction) = d match
    case Direction.N => println("north")

  // look up value by name
  println(Direction.withName("N"))
  println(Direction.withNameOption("A"))

  // look up all values
  println(Direction.values)
