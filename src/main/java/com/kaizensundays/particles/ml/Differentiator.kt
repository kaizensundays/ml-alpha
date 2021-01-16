package com.kaizensundays.particles.ml

/**
 * Created: Saturday 6/27/2020, 11:21 AM Eastern Time
 *
 * @author Sergey Chuykov
 */
interface Differentiator {

    fun compute(value: Double): Double

}