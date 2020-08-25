package io.github.dbgsprw.programmers.encodeString

class Solution {

    fun solution(s: String): Int {
        return (1..(s.length))
            .map { encodeString(s, it).length }
            .min()!!
    }

    fun encodeString(s: String, chunkSize: Int): String {
        var currentString = s.subSequence(0, chunkSize)
        var encodedString = ""
        var count = 0
        for (i in 0..s.length step chunkSize) {
            if (i + chunkSize > s.length) {
                encodedString += getEncodedChunk(currentString.toString(), count)
                encodedString += s.subSequence(i, s.length)
                break
            }

            if (currentString == s.subSequence(i, i + chunkSize)) {
                count++
            } else {
                encodedString += getEncodedChunk(currentString.toString(), count)
                currentString = s.subSequence(i, i + chunkSize)
                count = 1
            }
        }
        return encodedString
    }

    fun getEncodedChunk(chunk: String, count: Int): String {
        var encodedChunk = ""
        encodedChunk += if (count > 1) count.toString() else ""
        return encodedChunk + chunk
    }
}
