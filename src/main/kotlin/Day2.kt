package cberg.aoc2025

import kotlin.math.max

class Day2(input: Input) {

    private val input = input.oneLine().split(",")
        .map { it.split("-") }

    fun part1() = input.sumOf { (a, b) ->
        val toDrop = max(a.length / 2, b.length / 2)
        val startA = a.dropLast(toDrop).ifEmpty { "1" }.toLong()
        val startB = b.dropLast(toDrop).toLong()
        (startA..startB)
            .map { it.toString().repeat(2).toLong() }
            .filter { it in a.toLong()..b.toLong() }
            .sum()
    }

    fun part2() = input.sumOf { (a, b) ->
        val toDropMin = max(a.length / 2, b.length / 2)
        val toDropMax = max(a.length, b.length) - 1
        val invalidIds = mutableSetOf<Long>()

        for (toDrop in toDropMin..toDropMax) {
            val startA = a.dropLast(toDrop).ifEmpty { "1" }.toLong()
            val startB = b.dropLast(toDrop).toLong()
            for (start in startA..startB) {
                val nMin = max(a.length / start.toString().length, 2)
                val nMax = b.length / start.toString().length
                for (n in nMin..nMax) {
                    val id = start.toString().repeat(n).toLong()
                    if (id in a.toLong()..b.toLong()) {
                        invalidIds += id
                    }
                }
            }
        }
        invalidIds.sum()
    }
}