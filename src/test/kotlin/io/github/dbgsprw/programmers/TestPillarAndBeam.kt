package io.github.dbgsprw.programmers

import io.github.dbgsprw.programmers.pillarAndBeam.Solution
import org.junit.Test
import kotlin.test.assertTrue

class TestPillarAndBeam {
    private val solution = Solution()


    @Test
    fun testSolution() {
        assertTrue(
            arrayOf(
                intArrayOf(1, 0, 0), intArrayOf(1, 1, 1), intArrayOf(2, 1, 0),
                intArrayOf(2, 2, 1), intArrayOf(3, 2, 1), intArrayOf(4, 2, 1),
                intArrayOf(5, 0, 0), intArrayOf(5, 1, 0)
            ) contentDeepEquals solution.solution(
                5, arrayOf(
                    intArrayOf(1, 0, 0, 1),
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(2, 1, 0, 1),
                    intArrayOf(2, 2, 1, 1),
                    intArrayOf(5, 0, 0, 1),
                    intArrayOf(5, 1, 0, 1),
                    intArrayOf(4, 2, 1, 1),
                    intArrayOf(3, 2, 1, 1)
                )
            )
        )
        assertTrue(
            arrayOf(
                intArrayOf(0, 0, 0), intArrayOf(0, 1, 1), intArrayOf(1, 1, 1),
                intArrayOf(2, 1, 1), intArrayOf(3, 1, 1), intArrayOf(4, 0, 0)
            ) contentDeepEquals solution.solution(
                5, arrayOf(
                    intArrayOf(0, 0, 0, 1),
                    intArrayOf(2, 0, 0, 1),
                    intArrayOf(4, 0, 0, 1),
                    intArrayOf(0, 1, 1, 1),
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(2, 1, 1, 1),
                    intArrayOf(3, 1, 1, 1),
                    intArrayOf(2, 0, 0, 0),
                    intArrayOf(1, 1, 1, 0),
                    intArrayOf(2, 2, 0, 1)
                )
            )
        )
    }
}