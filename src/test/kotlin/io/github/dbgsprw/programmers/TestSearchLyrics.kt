package io.github.dbgsprw.programmers

import io.github.dbgsprw.programmers.searchLyrics.Solution
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestSearchLyrics {

    @Test
    fun testInsert() {
        val trieNode = Solution.TrieNode()
        trieNode.insert("frodo")
        assertEquals(
            0,
            trieNode.children['f']?.children?.get('r')?.children?.get('o')
                ?.children?.get('d')?.children?.get('o')?.children?.size
        )
    }

    @Test
    fun testSearch() {
        val trieNode = Solution.TrieNode()
        trieNode.insert("frodo")
        trieNode.insert("front")
        assertEquals(1, trieNode.search("frodo"))
        assertEquals(2, trieNode.search("fr???"))
    }

    @Test
    fun testSolution() {
        val solution = Solution()
        assertTrue(
            intArrayOf(3, 2, 4, 1, 0) contentEquals solution.solution(
                arrayOf(
                    "frodo", "front", "frost", "frozen", "frame", "kakao"
                ),
                arrayOf(
                    "fro??", "????o", "fr???", "fro???", "pro?"
                )
            )
        )
    }

}