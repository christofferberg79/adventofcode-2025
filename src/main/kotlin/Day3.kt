package cberg.aoc2025

class Day3(input: Input) {

    private val banks = input.lines().map { it.map { it.digitToInt() } }

    fun part1() = banks.sumOf { bank ->
        val i = (0..<bank.lastIndex).maxBy { bank[it] }
        val j = (i + 1..bank.lastIndex).maxBy { bank[it] }
        bank[i] * 10 + bank[j]
    }

    fun part2() = banks.sumOf { bank ->
        var joltage = 0L
        var start = 0
        for (n in 11 downTo 0) {
            val i = (start..bank.lastIndex - n).maxBy { bank[it] }
            joltage = joltage * 10 + bank[i]
            start = i + 1
        }
        joltage
    }
}