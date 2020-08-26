package io.github.dbgsprw.programmers

import io.github.dbgsprw.programmers.lockAndKey.Solution
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestLockAndKey {
    private val solution = Solution()
    private val key = arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 0), intArrayOf(0, 1, 1))
    private val invalidKey = arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 1, 0), intArrayOf(0, 1, 1))
    private val lock = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))

    @Test
    fun testSolution() {
        assertTrue(solution.solution(key, lock))
        assertTrue(solution.solution(key, arrayOf(intArrayOf(1))))
        assertFalse(solution.solution(invalidKey, lock))
    }

    @Test
    fun testCheckWithLocationAndAnyRotation() {
        assertTrue(solution.checkWithLocationAndAnyRotation(1, 1, key, lock))
        assertFalse(solution.checkWithLocationAndAnyRotation(1, 1, invalidKey, lock))
    }

    @Test
    fun testCheckWithLocation() {
        val rotatedKey = solution.rotate90(key)
        assertTrue(solution.checkWithLocation(1, 1, rotatedKey, lock))
        assertFalse(solution.checkWithLocation(1, 1, solution.rotate90(rotatedKey), lock))
    }

    @Test
    fun testRotate90() {
        assertTrue(
            arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 0, 0), intArrayOf(1, 0, 0)) contentDeepEquals
                    solution.rotate90(key)
        )
        assertTrue(
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 1)) contentDeepEquals
                    solution.rotate90(arrayOf(intArrayOf(1, 1), intArrayOf(0, 0)))
        )
    }

}