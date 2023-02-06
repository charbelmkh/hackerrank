import kotlin.math.max

/*
 * Complete the 'hourglassSum' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

fun hourglassSum(arr: Array<Array<Int>>): Int {
    var maxSum=Integer.MIN_VALUE
    for (i in 1..4) {
        for (j in 1..4) {
            val tempSum=(arr[i-1][j-1]+arr[i-1][j]+arr[i-1][j+1])+
                    (arr[i][j])+
                    (arr[i+1][j-1]+arr[i+1][j]+arr[i+1][j+1])
            maxSum= max(tempSum,maxSum)
        }
    }
    return maxSum
}

fun getHourglassSum(arr: Array<Array<Int>>,x:Int,j:Int):Int{
    if(arr.isEmpty()) return 0
    if(x+2>=arr.size || j+2>=arr[0].size)  return 0
    //println("new hourglasses")
    return (arr[x][j]+ arr[x][j+1]+arr[x][j+2] +
            arr[x+1][j+1]+
            arr[x+2][j]+ arr[x+2][j+1]+arr[x+2][j+2]
            )

}
fun main(args: Array<String>) {

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}