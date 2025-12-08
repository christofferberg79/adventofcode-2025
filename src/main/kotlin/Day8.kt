package cberg.aoc2025

class Day8(input: Input, n: Int = Int.MAX_VALUE) {
    private data class Box(val x: Long, val y: Long, val z: Long)

    private val boxes = input.lines()
        .map { line -> line.split(",").map { it.toLong() } }
        .map { (x, y, z) -> Box(x, y, z) }

    private val pairs = distances(boxes)
        .sortedBy { (_, dist) -> dist }
        .take(n)
        .map { (pair, _) -> pair }

    private val circuits = boxes
        .map { setOf(it) }
        .toMutableSet()

    private fun distances(boxes: List<Box>) = buildList {
        for (i in 0..<boxes.lastIndex)
            for (j in i + 1..boxes.lastIndex)
                add(boxes[i] to boxes[j] to sqDist(boxes[i], boxes[j]))
    }

    private fun sqDist(box1: Box, box2: Box) = sq(box2.x - box1.x) + sq(box2.y - box1.y) + sq(box2.z - box1.z)

    private fun sq(n: Long) = n * n

    fun part1(): Int {
        for ((box1, box2) in pairs) {
            connect(box1, box2)
        }
        return circuits.map { it.size }.sortedDescending().take(3).reduce(Int::times)
    }

    fun part2(): Long {
        for ((box1, box2) in pairs) {
            connect(box1, box2)
            if (circuits.size == 1) {
                return box1.x * box2.x
            }
        }
        error("No solution found")
    }

    private fun connect(box1: Box, box2: Box) {
        val c1 = circuits.first { box1 in it }
        val c2 = circuits.first { box2 in it }
        if (c1 !== c2) {
            circuits -= c1
            circuits -= c2
            circuits += c1 + c2
        }
    }
}