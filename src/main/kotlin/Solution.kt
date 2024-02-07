import kotlin.math.sqrt

/**
 *  직사각형 넓이 구하기
 *  1.좌표 순으로 정렬
 *  2.이후 두변의 길이를 구하여 계산
 */

class Solution {
    private fun distance(a: Pair<Int, Int>, b: Pair<Int, Int>): Int {
        val x : Double = a.first - b.first.toDouble()
        val y : Double = a.second -b.second.toDouble()
        return sqrt(x*x + y*y).toInt()
    }

    fun solution(dots: Array<IntArray>): Int {
        var answer: Int = 0
        var cooList = mutableListOf<Pair<Int, Int>>()
        dots.forEach { dot ->
            cooList.add(Pair(dot[0], dot[1]))
        }
        // 여러개의 조건에 따른 정렬
        cooList = cooList.sortedWith(compareBy({it.first},{it.second})).toMutableList()
        // 0 ~ 1 0 ~ 2
        answer = distance(cooList[0],cooList[1]) * distance(cooList[0],cooList[2])
        return answer
    }
}

fun main() {
    val a = Solution()
    a.solution(
        arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(2, 2),
            intArrayOf(1, 2)
        )
    ) // 1

    a.solution(
        arrayOf(
            intArrayOf(-1, -1),
            intArrayOf(1, 1),
            intArrayOf(1, -1),
            intArrayOf(-1, 1)
        )
    ) // 4
}