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

    @Test
    fun day5() {
        assertEquals(3, Day5(Input("day5_ex1")).part1())
        assertEquals(613, Day5(Input("day5")).part1())
        assertEquals(14, Day5(Input("day5_ex1")).part2())
        assertEquals(336495597913098, Day5(Input("day5")).part2())
    }

    @Test
    fun day6() {
        assertEquals(4277556, Day6(Input("day6_ex1")).part1())
        assertEquals(4771265398012, Day6(Input("day6")).part1())
        assertEquals(3263827, Day6(Input("day6_ex1")).part2())
        assertEquals(10695785245101, Day6(Input("day6")).part2())
        assertEquals(3263827, Day6(Input("day6_ex1")).part2Alt())
        assertEquals(10695785245101, Day6(Input("day6")).part2Alt())
    }

    @Test
    fun day7() {
        assertEquals(21, Day7(Input("day7_ex1")).part1())
        assertEquals(1622, Day7(Input("day7")).part1())
        assertEquals(40, Day7(Input("day7_ex1")).part2())
        assertEquals(10357305916520, Day7(Input("day7")).part2())
    }
}