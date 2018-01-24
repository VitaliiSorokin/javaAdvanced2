package tetris.figures;

public class Figure {
    private Pivot[] pivots;
    private Pivot dot;

    private int x;
    private int y;

    public Figure(Pivot[] pivots, Pivot dot) {
        this.pivots = pivots;
        this.dot = dot;
    }
}
