package io.github.dbgsprw.programmers.searchLyrics

class Solution {
    class TrieNode() {
        val children: HashMap<Char, TrieNode> = hashMapOf()
        var childCount = 0
        fun insert(word: String) {
            var trieNode = this
            word.forEach { char ->
                var child = trieNode.children[char] ?: {
                    val newTrieNode = TrieNode()
                    trieNode.children[char] = newTrieNode
                    newTrieNode
                }()
                trieNode.childCount++
                trieNode = child
            }
        }

        fun search(query: String): Int {
            val trieNode = this
            if (query.isEmpty()) {
                if (trieNode.children.isEmpty()) {
                    return 1
                }
                return 0
            }
            val char = query.first()
            if (char == '?') {
                return trieNode.childCount
            }
            return trieNode.children[char]?.search(query.substring(1)) ?: 0
        }
    }


    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        val trieMap: HashMap<Int, TrieNode> = hashMapOf()
        val reverseTrieMap: HashMap<Int, TrieNode> = hashMapOf()

        words.forEach {
            val length = it.length
            if (length !in trieMap.keys) {
                trieMap[length] = TrieNode()
                reverseTrieMap[length] = TrieNode()
            }
            trieMap[length]?.insert(it)
            reverseTrieMap[length]?.insert(it.reversed())
        }
        return queries.map {
            val length = it.length
            if (it.first() == '?') {
                reverseTrieMap[length]?.search(it.reversed()) ?: 0
            } else {
                trieMap[length]?.search(it) ?: 0
            }
        }.toIntArray()
    }

}
