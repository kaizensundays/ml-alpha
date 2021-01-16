package com.kaizensundays.particles.ml

import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit
import kotlin.math.exp

/**
 * Created: Saturday 6/27/2020, 12:11 PM Eastern Time
 *
 * @author Sergey Chuykov
 */
@Suppress("unused")
@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 3, time = 3)
@Measurement(iterations = 3, time = 3)
@Fork(jvmArgsAppend = ["-Xmx1g"], value = 3)
open class Math3DifferentiatorBenchmark {

    private val points = 8
    private val step = 0.01

    private var tenExSquaredDifferentiator: Differentiator = NopDifferentiator()
    private var exCubedDifferentiator: Differentiator = NopDifferentiator()
    private var expExSquaredDifferentiator: Differentiator = NopDifferentiator()

    @Setup
    fun setup() {

        tenExSquaredDifferentiator = Math3Differentiator({ x: Double -> 10 * x * x }, points, step)
        exCubedDifferentiator = Math3Differentiator({ x: Double -> x * x * x }, points, step)
        expExSquaredDifferentiator = Math3Differentiator({ x: Double -> exp(x * x) }, points, step)
    }

    @Benchmark
    fun differentiateTenExSquared(): Double {

        return tenExSquaredDifferentiator.compute(1.37)
    }

    @Benchmark
    fun differentiateExCubed(): Double {

        return exCubedDifferentiator.compute(1.37)
    }

    @Benchmark
    fun differentiateExpExSquared(): Double {

        return expExSquaredDifferentiator.compute(1.37)
    }

}