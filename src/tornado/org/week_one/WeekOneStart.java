package tornado.org.week_one;

import processing.core.PApplet;

public class WeekOneStart extends PApplet {

    int[] values = {15, 23, 58, 52, 35, 24, 74, 22, 32, 11, 23, 64};

    final int mulitplicationFactor = 3;
    final int barWidth = 20;
    final int calcWidth = barWidth * 2;
    final int lineEvery = 10;
    final int textOffset = 20;
    final int valueOffset = 20;
    final int black = 0;
    final int white = 255;

    int distX = calcWidth * values.length;
    int distY = (int) Math.floor(getHighestVal(values)) * mulitplicationFactor;
    int offsetX = 50;
    int offsetY = 50;


    public void setup() {
        size(distX + (offsetX * 2), distY + (offsetY * 2));
        System.out.println(lineEvery * values.length * mulitplicationFactor);
        background(white);
        noLoop();
    }

    public void draw() {

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
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}