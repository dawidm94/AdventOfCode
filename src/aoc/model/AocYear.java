package aoc.model;

public enum AocYear {
    YEAR2020("year2020"),
    YEAR2021("year2021"),
    YEAR2022("year2022");

    AocYear(String year) {
        this.year = year;
    }

    private String year;

    public String toString() {
        return year;
    }
}
