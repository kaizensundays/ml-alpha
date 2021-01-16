package com.kaizensundays.particles.ml

/**
 * Created: Saturday 6/27/2020, 11:34 AM Eastern Time
 *
 * @author Sergey Chuykov
 */
abstract class TestSupport {

    val delta = 0.0000001

    fun vectors(f: (Double) -> Double, from: Double, to: Double, step: Double): List<DoubleArray> {

        val xx = mutableListOf<DoubleArray>()

        var x = from

        while (x <= to) {

            val y = f.invoke(x)

            xx.add(doubleArrayOf(x, y))

            x += step
        }

        return xx
    }

}