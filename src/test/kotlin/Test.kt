package cberg.aoc2025

import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun day1() {
        assertEquals(3, Day1(Input("day1_ex1")).part1())
        assertEquals(980, Day1(Input("day1")).part1())
        assertEquals(6, Day1(Input("day1_ex1")).part2())
        assertEquals(5961, Day1(Input("day1")).part2())
    }
}