package cberg.aoc2025

class Day6(input: Input) {

    private val input = input.lines()

    fun part1(): Long {
        val operators = input.last().trim().split(Regex(" +"))
        val numbers = input.dropLast(1).map { it.trim().split(Regex(" +")) }
        return operators.withIndex().sumOf { (col, operator) ->
            numbers.map { it[col].toLong() }.calc(operator)
        }
    }

    private fun List<Long>.calc(operator: String) = when (operator) {
        "+" -> reduce(Long::plus)
        "*" -> reduce(Long::times)
        else -> error("Unknown operator: $operator")
    }

    fun part2(): Long {
        var total = 0L
        val numbers = mutableListOf<Long>()
        val columnsRightToLeft = input.first().indices.reversed()
        for (col in columnsRightToLeft) {
            val topDownDigits = input.mapNotNull { it[col].digitToIntOrNull() }
            if (topDownDigits.isEmpty()) { // separator column
                continue
            }
            numbers += topDownDigits.joinToString("").toLong()

            val operator = input.last()[col]
            if (operator != ' ') {
                total += numbers.calc(operator.toString())
                numbers.clear()
            }
        }
        return total
    }

    fun part2Alt() = input.first().indices.map(::columnToString)
        .split(String::isEmpty) // separator column
        .sumOf { problem ->
            val operator = problem.first().last().toString()
            val numbers = problem.map { it.replace(operator, "").toLong() }
            numbers.calc(operator)
        }

    private fun columnToString(col: Int) = input.indices.map { row -> input[row][col] }
        .joinToString("")
        .replace(" ", "")
}
