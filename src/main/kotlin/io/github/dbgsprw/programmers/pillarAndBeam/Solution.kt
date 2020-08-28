package io.github.dbgsprw.programmers.pillarAndBeam

class Solution {
    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        val status =
            Array(n + 2) { Array(n + 2) { Pair(first = false, second = false) } } // first = pillar, second = beam
        build_frame.forEach {
            var (x, y, what, how) = it
            x++
            y++

            if (how == 1) { // build
                if (checkBuild(x, y, what, status)) {
                    when (what) {
                        0 -> status[x][y] = Pair(true, status[x][y].second)
                        1 -> status[x][y] = Pair(status[x][y].first, true)
                    }
                }
            } else { // remove
                val previous = status[x][y]
                if (!doRemove(x, y, what, status)) {
                    status[x][y] = previous // recovery
                }
            }
        }
        var answer = arrayOf<IntArray>()
        for (x in status.indices) {
            for (y in status[x].indices) {
                if (status[x][y].first) {
                    answer += intArrayOf(x - 1, y - 1, 0)
                }

                if (status[x][y].second) {
                    answer += intArrayOf(x - 1, y - 1, 1)
                }
            }
        }
        return answer
    }

    fun checkBuild(x: Int, y: Int, what: Int, status: Array<Array<Pair<Boolean, Boolean>>>,
                   trueIfNotExist:Boolean = false): Boolean {
        return if (what == 0) {
            (trueIfNotExist && !status[x][y].first) ||
            y == 1 || status[x - 1][y].second || status[x][y].second || status[x][y - 1].first
        } else {
            (trueIfNotExist && !status[x][y].second) ||
            status[x + 1][y - 1].first || status[x][y - 1].first
                    || (status[x - 1][y].second && status[x + 1][y].second)
        }
    }

    fun doRemove(x: Int, y: Int, what: Int, status: Array<Array<Pair<Boolean, Boolean>>>): Boolean {
        return if (what == 0) {
            status[x][y] = Pair(false, status[x][y].second)
            checkBuild(x, y + 1, 0, status, trueIfNotExist = true) &&
                    checkBuild(x - 1, y + 1, 1, status, trueIfNotExist = true) &&
                    checkBuild(x, y + 1, 1, status, trueIfNotExist = true)
        } else {
            status[x][y] = Pair(status[x][y].first, false)
            checkBuild(x, y, 0, status, trueIfNotExist = true) &&
                    checkBuild(x + 1, y, 0, status, trueIfNotExist = true) &&
                    checkBuild(x - 1, y, 1, status, trueIfNotExist = true) &&
                    checkBuild(x + 1, y, 1, status, trueIfNotExist = true)
        }
    }
}
