package com.kaizensundays.particles.ml

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.exp

/**
 * Created: Saturday 6/27/2020, 10:03 AM Eastern Time
 *
 * @author Sergey Chuykov
 */
class Math3DifferentiatorTest : TestSupport() {

    private val points = 8
    private val step = 0.01

    @Test
    fun differentiateTenExSquared() {

        // (10*x^2)' = 20*x
        val f = { x: Double -> 10 * x * x }
        val d = Math3Differentiator(f, points, step)
        val df = { x: Double -> 20 * x }

        assertEquals(-10.0, d.compute(-0.5), delta)
        assertEquals(0.0, d.compute(0.0), delta)
        assertEquals(10.0, d.compute(0.5), delta)

        val vectors = vectors(df, -4.0, 4.0, 0.5)

        for (xy in vectors) {

            val arg = xy[0]
            val expected = xy[1]
            val actual = d.compute(arg)

            assertEquals(expected, actual, delta)
        }

    }

    @Test
    fun differentiateExCubed() {

        // (x^3)' = 3*x^2
        val f = { x: Double -> x * x * x }
        val d = Math3Differentiator(f, points, step)
        val df = { x: Double -> 3 * x * x }

        assertEquals(3.0, d.compute(-1.0), delta)
        assertEquals(0.0, d.compute(0.0), delta)
        assertEquals(3.0, d.compute(1.0), delta)

        val vectors = vectors(df, -4.0, 4.0, 0.5)

        for (xy in vectors) {

            val arg = xy[0]
            val expected = xy[1]
            val actual = d.compute(arg)

            assertEquals(expected, actual, delta)
        }

    }

    @Test
    fun differentiateExpExSquared() {

        // (exp(x^2))' = 2*exp(x^2)*x
        val f = { x: Double -> exp(x * x) }
        val d = Math3Differentiator(f, points, step)
        val df = { x: Double -> 2 * exp(x * x) * x }

        assertEquals(-5.43656365691809, d.compute(-1.0), delta)
        assertEquals(0.0, d.compute(0.0), delta)
        assertEquals(5.43656365691809, d.compute(1.0), delta)

        val vectors = vectors(df, -3.3, 3.3, 0.1)

        for (xy in vectors) {

            val arg = xy[0]
            val expected = xy[1]
            val actual = d.compute(arg)

            assertEquals(expected, actual, delta)
        }

    }

}