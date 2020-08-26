package io.github.dbgsprw.programmers

import io.github.dbgsprw.programmers.convertParenthesis.Solution
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class TestConvertParenthesis {
    private val solution = Solution()

    @Test
    fun testSolution() {
        assertEquals("(()())()", solution.solution("(()())()"))
        assertEquals("()", solution.solution(")("))
        assertEquals("()(())()", solution.solution("()))((()"))
    }

    @Test
    fun testSplitString() {
        assertEquals(Pair(")(", "()"), solution.splitString(")(()"))
        assertEquals(Pair("))((", "()"), solution.splitString("))((()"))
    }

    @Test
    fun isRightString() {
        assertTrue(solution.isRightString("()"))
        assertTrue(solution.isRightString("()()"))
        assertFalse(solution.isRightString("())("))
    }

    @Test
    fun reverseString() {
        assertEquals("())(()", solution.reverseString(")(())("))
    }
}
