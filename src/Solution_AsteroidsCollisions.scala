import scala.collection.mutable

object Solution_AsteroidsCollisions {
  def asteroidCollision(asteroids: Array[Int]): Array[Int] = {
    val asteroidsAfterCollisions = processAsteroidCollisions(asteroids)
    asteroidsAfterCollisions.toArray.reverse
  }

  def processAsteroidCollisions(asteroids: Array[Int]): mutable.Stack[Int] = {
    println(s"Processing asteroids: ${asteroids.mkString("Array(", ", ", ")")}")
    var asteroidsAfterCollisions = mutable.Stack[Int]()
    asteroids.foreach({ asteroid =>
      if (asteroidsAfterCollisions.isEmpty) {

        /** first asteroid */
        asteroidsAfterCollisions.push(asteroid)
      } else {

        /** new asteroid logic */
        val previousAsteroid = asteroidsAfterCollisions.top
        if (asteroid > 0 && previousAsteroid > 0) {

          /** both asteroids going right - increase asteroid stack */
          asteroidsAfterCollisions.push(asteroid)
        } else if (asteroid < 0 && previousAsteroid < 0) {

          /** both asteroids going left - increase asteroid stack */
          asteroidsAfterCollisions.push(asteroid)
        } else if (previousAsteroid < 0 && asteroid > 0) {

          /** no asteroids will meet each other */
          asteroidsAfterCollisions.push(asteroid)
        } else {

          /** asteroid collision */
          val asteroidNewMass = asteroidMassAfterCollision(previousAsteroid, asteroid)

          if (asteroidNewMass == 0) {

            /** annihilation - remove current asteroid */
            if (asteroidsAfterCollisions.nonEmpty) asteroidsAfterCollisions.pop()
          } else {
            asteroidsAfterCollisions.update(0, asteroidNewMass)

            /** recalculate existing asteroids with new asteroid of opposite direction */
            asteroidsAfterCollisions = processAsteroidCollisions(asteroidsAfterCollisions.toArray.reverse)
          }
        }
      }
    })
    asteroidsAfterCollisions
  }

  def asteroidMassAfterCollision(previousAsteroid: Int, asteroid: Int): Int = {
    if (previousAsteroid.abs > asteroid.abs) {
      previousAsteroid
    } else if (previousAsteroid.abs < asteroid.abs) {
      asteroid
    } else {

      /** same mass - annigilation */
      0
    }
  }
}
