package com.kaizensundays.particles.ml

/**
 * Created: Saturday 6/27/2020, 12:14 PM Eastern Time
 *
 * @author Sergey Chuykov
 */
class NopDifferentiator : Differentiator {

    override fun compute(value: Double): Double {
        return 0.0
    }

}