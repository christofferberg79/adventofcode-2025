package cberg.aoc2025

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Day9(input: Input) {
    private val points = input.lines()
        .map { line -> line.split(",").map { it.toInt() } }
        .map { (x, y) -> Vector(x, y) }

    private val rectangles = buildList {
        for (i in 0..<points.lastIndex) {
            for (j in i + 1..points.lastIndex) {
                add(points[i] to points[j])
            }
        }
    }

    private val lines = points.zipWithNext() + Pair(points.last(), points.first())

    fun part1() = rectangles.maxOf(::area)

    fun part2() = rectangles.filter(::isValid).maxOf(::area)

    private fun isValid(rect: Pair<Vector, Vector>) = lines.none { line -> doIntersect(line, rect) } && isInside(rect)

    private fun area(rect: Pair<Vector, Vector>) =
        (abs(rect.first.x - rect.second.x) + 1L) * (abs(rect.first.y - rect.second.y) + 1L)

    private fun doIntersect(line: Pair<Vector, Vector>, rect: Pair<Vector, Vector>): Boolean {
        val line = normalize(line)
        val rect = normalize(rect)
        return (line.first.x < rect.second.x && line.second.x > rect.first.x &&
                line.first.y < rect.second.y && line.second.y > rect.first.y)
    }

    private fun normalize(points: Pair<Vector, Vector>) = Pair(
        Vector(
            min(points.first.x, points.second.x),
            min(points.first.y, points.second.y)
        ),
        Vector(
            max(points.first.x, points.second.x),
            max(points.first.y, points.second.y)
        )
    )

    val horizontalLines = lines.filter { line -> line.first.y == line.second.y }.map { normalize(it) }

    private fun isInside(rect: Pair<Vector, Vector>): Boolean {
        val topLeft = normalize(rect).first
        return horizontalLines.count { line -> line.first.y < topLeft.y && topLeft.x in line.first.x..line.second.x } % 2 == 0
    }
}
