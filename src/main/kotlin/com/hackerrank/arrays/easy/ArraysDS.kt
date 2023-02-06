package com.hackerrank.arrays.easy

import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'reverseArray' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY a as parameter.
 */

fun reverseArray(a: Array<Int>): Array<Int> {
    val reverseArray = IntArray(a.size)
    a.indices.forEach {
        reverseArray[it] = a[a.size - 1 - it]
    }
    return reverseArray.toTypedArray()

}

fun main(args: Array<String>) {
    val arrCount = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val res = reverseArray(arr)

    println(res.joinToString(" "))
}