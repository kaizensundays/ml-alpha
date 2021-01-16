package com.kaizensundays.particles.ml

import org.apache.commons.math3.analysis.UnivariateFunction
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure
import org.apache.commons.math3.analysis.differentiation.FiniteDifferencesDifferentiator

/**
 * Created: Saturday 6/27/2020, 10:04 AM Eastern Time
 *
 * @author Sergey Chuykov
 */
class Math3Differentiator(f: (x: Double) -> Double, points: Int, step: Double) : Differentiator {

    private val fdf = FiniteDifferencesDifferentiator(points, step)
            .differentiate(UnivariateFunction { x -> f(x) })

    override fun compute(value: Double): Double {

        val ds = fdf.value(DerivativeStructure(1, 1, 0, value))

        return ds.allDerivatives[1]
    }

}