package io.github.dbgsprw.programmers

import io.github.dbgsprw.programmers.encodeString.Solution
import org.junit.Test
import kotlin.test.assertEquals


class TestEncodeString {
    private val solution = Solution()

    @Test
    fun testGetEncodedChunk() {
        assertEquals("2a", solution.getEncodedChunk("a", 2))
        assertEquals("3ab", solution.getEncodedChunk("ab", 3))
    }

    @Test
    fun testEncodeString() {
        assertEquals("2a2ba3c", solution.encodeString("aabbaccc", 1))
    }

    @Test
    fun testSolution() {
        assertEquals(7, solution.solution("aabbaccc"))
        assertEquals(9, solution.solution("ababcdcdababcdcd"))
        assertEquals(8, solution.solution("abcabcdede"))
        assertEquals(14, solution.solution("abcabcabcabcdededededede"))
        assertEquals(17, solution.solution("xababcdcdababcdcd"))
    }
}
