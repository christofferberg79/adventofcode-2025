package cberg.aoc2025

import kotlin.math.max

class Day5(input: Input) {

    private val ranges: List<LongRange>
    private val ids: List<Long>

    init {
        val (rangesInput, idsInput) = input.lines().split { it.isEmpty() }
        ranges = rangesInput.map { it.split("-").let { (from, to) -> from.toLong()..to.toLong() } }
        ids = idsInput.map { it.toLong() }
    }

    fun part1() = ids.count { id -> ranges.any { range -> id in range } }

    fun part2(): Long {
        var last = 0L
        var ids = 0L
        for (range in ranges.sortedBy { it.first }) {
            if (range.last > last) {
                ids += range.last - max(last, range.first - 1)
                last = range.last
            }
        }
        return ids
    }
}
