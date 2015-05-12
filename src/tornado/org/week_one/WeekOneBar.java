package tornado.org.week_one;

import processing.core.PApplet;

public class WeekOneBar extends PApplet {

    private int[] values = {15, 23, 58, 52, 35, 24, 74, 22, 32, 11, 23, 64};

    private final int multiplicationFactor = 3;
    private final int barWidth = 20;
    private final int lineEvery = 10;
    private final int textOffset = 20;
    private final int valueOffset = 20;
    private final int borderOffsetX = 50;
    private final int borderOffsetY = 50;;

    private final int black = 0;
    private final int white = 255;

    private final int doubleWidth = barWidth * 2;
    private final int halfWidth = barWidth / 2;
    private final int distX = doubleWidth * values.length;
    private final int distY = (int) Math.floor(getHighestVal(values)) * multiplicationFactor;


    public void setup() {
        size(distX + (borderOffsetX * 2), distY + (borderOffsetY * 2));
        background(white);
        noLoop();
    }

    public void draw() {
        rectangles(values);
        lines(values);
    }

    private void rectangles(int[] values) {
        stroke(black);

        for (int i = 0; i < values.length; i++) {
            float gray = map(i, 0, values.length, black, white);
            fill(gray);
            rect(i* doubleWidth + borderOffsetX + halfWidth,
                    distY + borderOffsetY,
                    barWidth,
                    -values[i] * multiplicationFactor);

            fill(0);

            setTextRectangle(i);
        }
    }

    private void setTextRectangle(int i) {
        text(String.valueOf(values[i]),
                i * doubleWidth + borderOffsetX + halfWidth,
                distY + borderOffsetY + valueOffset);
    }

    private void lines(int[] values) {
        stroke(black);

        for (int i = 0; i <= Math.floor(getHighestVal(values) / lineEvery); i++) {
            line(borderOffsetX,
                    distY + borderOffsetY - lineEvery * i * multiplicationFactor,
                    borderOffsetX + values.length * doubleWidth,
                    distY + borderOffsetY - lineEvery * i * multiplicationFactor);

            setTextLine(i);
        }
    }

    private void setTextLine(int i) {
        text(String.valueOf(i * lineEvery),
                borderOffsetX - textOffset,
                distY + borderOffsetY - lineEvery * i * multiplicationFactor);
    }

    private int getHighestVal(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i  : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}