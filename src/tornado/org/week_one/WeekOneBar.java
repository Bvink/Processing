package tornado.org.week_one;

import processing.core.PApplet;

public class WeekOneBar extends PApplet {

    private int[] values = {15, 23, 58, 52, 35, 24, 74, 22, 32, 11, 23, 64};

    private final int mulitplicationFactor = 3;
    private final int barWidth = 20;
    private final int calcWidth = barWidth * 2;
    private final int lineEvery = 10;
    private final int textOffset = 20;
    private final int valueOffset = 20;
    private final int black = 0;
    private final int white = 255;

    private int distX = calcWidth * values.length;
    private int distY = (int) Math.floor(getHighestVal(values)) * mulitplicationFactor;
    private int offsetX = 50;
    private int offsetY = 50;


    public void setup() {
        size(distX + (offsetX * 2), distY + (offsetY * 2));
        background(white);
        noLoop();
    }

    public void draw() {
        rectangles(values);
        lines(values);
    }

    private void rectangles(int[] values) {
        stroke(black);

        for (int i = 0; i < (calcWidth * values.length); i += calcWidth) {
            float gray = map(i / calcWidth, 0, values.length, black, white);
            fill(gray);
            rect(i + offsetX,
                    distY + offsetY,
                    barWidth,
                    -values[i / calcWidth] * mulitplicationFactor);

            fill(0);

            text(String.valueOf(values[i / calcWidth]),
                    i + offsetX + (barWidth),
                    distY + offsetY + valueOffset);
        }
    }

    private void lines(int[] values) {
        stroke(black);

        for (int i = 0; i <= Math.floor(getHighestVal(values) / lineEvery); i++) {
            line(offsetX + barWidth,
                    distY + offsetY - lineEvery * i * mulitplicationFactor,
                    offsetX + values.length * calcWidth,
                    distY + offsetY - lineEvery * i * mulitplicationFactor);

            text(String.valueOf(i * lineEvery),
                    offsetX - textOffset,
                    distY + offsetY - lineEvery * i * mulitplicationFactor);
        }
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