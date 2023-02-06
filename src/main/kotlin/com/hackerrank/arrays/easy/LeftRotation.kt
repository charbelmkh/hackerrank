import kotlin.collections.*
import kotlin.io.*

/*
 * Complete the 'rotateLeft' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER d
 *  2. INTEGER_ARRAY arr
 */

fun rotateLeft(d: Int, arr: Array<Int>): Array<Int> {
    val leftShit = d % arr.size
    if (leftShit == 0) return arr
    val rotatedArray = Array(arr.size) { 0 }
    (arr.indices).forEach {
        val newPosition = (arr.size + it - leftShit) % arr.size
        rotatedArray[newPosition] = arr[it]
    }
    return rotatedArray
}

fun main(args: Array<String>) {
    val rotateLeft = rotateLeft(4, arrayOf(1, 2, 3, 4, 5))
    println(rotateLeft.contentToString())
}

