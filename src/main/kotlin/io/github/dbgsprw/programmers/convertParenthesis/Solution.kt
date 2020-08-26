package io.github.dbgsprw.programmers.convertParenthesis


class Solution {
    fun solution(p: String): String {
        if (p == "") {
            return ""
        }
        val (u, v) = splitString(p)
        return if (isRightString(u)) {
            u + solution(v)
        } else {
            "(" + solution((v)) + ")" + reverseString(u.substring(1, u.length - 1))
        }
    }

    fun splitString(string: String): Pair<String, String> {
        var openCount = 0
        var closeCount = 0
        for (index in string.indices) {
            when (string[index]) {
                '(' -> openCount++
                ')' -> closeCount++
            }
            if (openCount == closeCount) {
                return Pair(
                    string.substring(0, index + 1),
                    string.substring(index + 1, string.length)
                )
            }
        }
        return Pair("", "")
    }

    fun isRightString(string: String): Boolean {
        var openCount = 0
        var closeCount = 0
        for (char in string) {
            when (char) {
                '(' -> openCount++
                ')' -> closeCount++
            }
            if (closeCount > openCount) {
                return false
            }
        }
        return true
    }

    fun reverseString(string: String): String {
        return string.map { if (it == ')') '(' else ')' }.joinToString("")
    }
}
