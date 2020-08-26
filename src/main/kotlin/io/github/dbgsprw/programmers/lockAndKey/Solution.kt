package io.github.dbgsprw.programmers.lockAndKey

class Solution {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val keyLastIndex = key.size - 1
        val lockLastIndex = lock.size - 1
        for (keyY in -keyLastIndex..lockLastIndex) {
            for (keyX in -keyLastIndex..lockLastIndex) {
                if (checkWithLocationAndAnyRotation(x = keyX, y = keyY, key = key, lock = lock)) {
                    return true
                }
            }
        }

        return false
    }

    fun checkWithLocationAndAnyRotation(y: Int, x: Int, key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        var currentKey = key
        repeat(4) {
            if (checkWithLocation(y, x, currentKey, lock)) {
                return true
            }
            currentKey = rotate90(currentKey)
        }

        return false
    }

    fun checkWithLocation(keyY: Int, keyX: Int, key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        for (y in lock.indices) {
            for (x in lock.indices) {
                val currentKeyY = y - keyY
                val currentKeyX = x - keyX
                if (currentKeyY in key.indices && currentKeyX in key.indices) {
                    if (lock[y][x] + key[currentKeyY][currentKeyX] != 1) return false
                } else {
                    if (lock[y][x] != 1) {
                        return false
                    }
                }
            }
        }
        return true
    }

    fun rotate90(key: Array<IntArray>): Array<IntArray> {
        val newArray = Array(key.size) {
            IntArray(key.size) { 0 }
        }
        for (i in key.indices) {
            for (j in key.indices) {
                newArray[j][key.size - i - 1] = key[i][j]
            }
        }
        return newArray
    }

}
