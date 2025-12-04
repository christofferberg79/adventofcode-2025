package cberg.aoc2025

class Day4(input: Input) {

    private val grid = input.charGrid()

    fun part1() = grid.positions().count { it.canBeRemoved() }

    private fun Vector.canBeRemoved() = grid[this] == '@' && adjacentRolls(this) < 4

    private fun adjacentRolls(pos: Vector) = Dir.all.count { dir ->
        grid.getOrNull(pos + dir) == '@'
    }

    fun part2(): Int {
        var removed = 0
        do {
            val toRemove = grid.positions().filter { it.canBeRemoved() }
            toRemove.forEach { grid[it] = '.' }
            removed += toRemove.size
        } while (toRemove.isNotEmpty())
        return removed
    }
}