package aoc.model;

public enum AocDay {
    DAY_1("day1"),
    DAY_2("day2"),
    DAY_3("day3"),
    DAY_4("day4"),
    DAY_5("day5"),
    DAY_6("day6"),
    DAY_7("day7"),
    DAY_8("day8"),
    DAY_9("day9"),
    DAY_10("day10"),
    DAY_11("day11"),
    DAY_12("day12"),
    DAY_13("day13"),
    DAY_14("day14"),
    DAY_15("day15"),
    DAY_16("day16"),
    DAY_17("day17"),
    DAY_18("day18"),
    DAY_19("day19"),
    DAY_20("day20"),
    DAY_21("day21"),
    DAY_22("day22"),
    DAY_23("day23"),
    DAY_24("day24"),
    DAY_25("day25"),
    DAY_26("day26"),
    DAY_27("day27"),
    DAY_28("day28"),
    DAY_29("day29"),
    DAY_30("day30"),
    DAY_31("day31");

    AocDay(String day) {
        this.day = day;
    }

    private String day;

    public String toString() {
        return day;
    }
}
