package cberg.aoc2025

class Day10(input: Input) {

    private data class Machine(val lights: List<Boolean>, val buttons: List<List<Int>>)

    private val machines = input.lines().map { line ->
        line.split(" ").let { parts ->
            Machine(
                lights = parts.first().let { it.drop(1).dropLast(1).map { it == '#' } },
                buttons = parts.drop(1).dropLast(1).map { it.drop(1).dropLast(1).split(",").map { it.toInt() } }
            )
        }
    }

    fun part1() = machines.sumOf { machine ->
        val todo = mutableListOf(machine.lights.map { false } to 0)
        val done = mutableSetOf(todo.single().first)
        while (todo.isNotEmpty()) {
            val (lights, count) = todo.removeFirst()
            for (button in machine.buttons) {
                val newLights = toggle(lights, button)
                val newCount = count + 1
                if (newLights == machine.lights) {
                    return@sumOf newCount
                } else if (done.add(newLights)) {
                    todo.add(newLights to newCount)
                }
            }
        }
        error("No solutions found")
    }

    private fun toggle(lights: List<Boolean>, button: List<Int>) =
        lights.mapIndexed { index, light -> light.xor(index in button) }

    fun part2() = 0
}
