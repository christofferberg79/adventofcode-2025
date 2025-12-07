package cberg.aoc2025

import cberg.aoc2025.Dir.S
import cberg.aoc2025.Dir.SE
import cberg.aoc2025.Dir.SW

class Day7(input: Input) {

    private val grid = input.charGrid()

    fun part1(): Int {
        val splitters = mutableSetOf<Vector>()
        val beams = mutableListOf(grid.positionOf('S'))
        while (beams.isNotEmpty()) {
            val beam = beams.removeFirst()
            when (grid.getOrNull(beam)) {
                'S', '.' -> beams.add(beam + S)
                '^' -> {
                    if (splitters.add(beam)) {
                        beams.add(beam + SW)
                        beams.add(beam + SE)
                    }
                }
            }
        }
        return splitters.size
    }

    fun part2() = timelinesOf(grid.positionOf('S'))

    private val calculatedTimelines = mutableMapOf<Vector, Long>()

    private fun timelinesOf(beam: Vector): Long = calculatedTimelines.getOrPut(beam) {
        when (grid.getOrNull(beam)) {
            'S', '.' -> timelinesOf(beam + S)
            '^' -> timelinesOf(beam + SW) + timelinesOf(beam + SE)
            else -> 1
        }
    }
}
