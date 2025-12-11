package cberg.aoc2025

class Day11(input: Input) {

    private val data = input.lines().associate { line ->
        line.split(": ").let { (from, to) -> from to to.split(" ") }
    }

    fun part1() = paths("you", "out")

    fun part2() = paths("svr", "dac") * paths("dac", "fft") * paths("fft", "out") +
            paths("svr", "fft") * paths("fft", "dac") * paths("dac", "out")

    private val memo = mutableMapOf<Pair<String, String>, Long>()

    private fun paths(from: String, to: String): Long = memo.getOrPut(from to to) {
        if (from == to) 1
        else data[from]?.sumOf { next -> paths(next, to) } ?: 0
    }
}