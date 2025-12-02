package cberg.aoc2025

class Day1(input: Input) {

    private data class Instruction(val dir: Char, val dist: Int)

    private val instructions = input.lines().map { Instruction(it.first(), it.drop(1).toInt()) }

    private var count = 0
    private var dial = 50

    fun part1(): Int {
        for (i in instructions) {
            if (i.dir == 'L') {
                dial = (dial - i.dist).mod(100)
            } else {
                dial = (dial + i.dist).mod(100)
            }
            if (dial == 0) {
                count++
            }
        }
        return count
    }

    fun part2(): Int {
        for (i in instructions) {
            if (i.dir == 'L') {
                if (dial == 0) {
                    count += i.dist / 100
                } else if (i.dist >= dial) {
                    count += (i.dist - dial) / 100 + 1
                }
                dial = (dial - i.dist).mod(100)
            } else {
                count += (i.dist + dial) / 100
                dial = (dial + i.dist).mod(100)
            }
        }
        return count
    }
}