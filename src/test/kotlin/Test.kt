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

    @Test
    fun day2() {
        assertEquals(1227775554, Day2(Input("day2_ex1")).part1())
        assertEquals(29818212493, Day2(Input("day2")).part1())
        assertEquals(4174379265, Day2(Input("day2_ex1")).part2())
        assertEquals(37432260594, Day2(Input("day2")).part2())
    }

    @Test
    fun day3() {
        assertEquals(357, Day3(Input("day3_ex1")).part1())
        assertEquals(17430, Day3(Input("day3")).part1())
        assertEquals(3121910778619, Day3(Input("day3_ex1")).part2())
        assertEquals(171975854269367, Day3(Input("day3")).part2())
    }

    @Test
    fun day4() {
        assertEquals(13, Day4(Input("day4_ex1")).part1())
        assertEquals(1553, Day4(Input("day4")).part1())
        assertEquals(43, Day4(Input("day4_ex1")).part2())
        assertEquals(8442, Day4(Input("day4")).part2())
    }
}