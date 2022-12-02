package aoc.year2022.day2;

public enum Shape {
    ROCK(1),
    PAPER(2),
    SCISSOR(3);

    private static final int WIN_POINTS = 6;
    private static final int DRAW_POINTS = 3;
    private static final int LOSE_POINTS = 0;

    final int points;

    Shape(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public static Shape of(char sign) {
        return switch (sign) {
            case 'A','X' -> ROCK;
            case 'B','Y' -> PAPER;
            case 'C','Z' -> SCISSOR;
            default -> throw new IllegalStateException("Unexpected value: " + sign);
        };
    }

    public int fightWith(Shape opponent) {
        if (this.equals(opponent)) {
            return DRAW_POINTS + this.getPoints();
        }
        int battlePoints = switch(this) {
            case ROCK -> opponent.equals(SCISSOR) ? WIN_POINTS : LOSE_POINTS;
            case PAPER -> opponent.equals(ROCK) ? WIN_POINTS : LOSE_POINTS;
            case SCISSOR -> opponent.equals(PAPER) ? WIN_POINTS : LOSE_POINTS;
        };

        return battlePoints + this.getPoints();
    }
}
