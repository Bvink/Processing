package tornado.org.week_one;

import processing.core.PApplet;

public class WeekOneStart extends PApplet {

    int distX = 50;
    int distY = 300;

    final int mulitplicationFactor = 3;
    final int barWidth = 20;
    final int calcWidth = barWidth*2;
    final int lineEvery = 10;
    final int valueOffset = 20;

    int[] values ={15, 23, 58, 52, 35, 24, 74, 22};

    public void setup() {
        size(400,400);
        background(255);
        noLoop();
    }

    public void draw () {

        stroke(0, 0, 0);


        for (int i = 0; i < (calcWidth * values.length); i+=calcWidth) {
            float gray = map(i/calcWidth, 0, values.length, 0, 255);
            fill(gray);
            rect (i+distX+barWidth, distY, barWidth, -values[i/calcWidth]*mulitplicationFactor);
            fill(0);
            text (String.valueOf(values[i/calcWidth]), i+distX+(barWidth), distY+valueOffset);
        }

        stroke(0, 0, 0);

        for (int i = 0; i <= Math.floor(getHighestVal(values)/lineEvery); i++) {
            line (distX+barWidth, distY - lineEvery*i*mulitplicationFactor,
                    distX+values.length*calcWidth, distY - lineEvery*i*mulitplicationFactor);
            text(i == 0 ? "00" : String.valueOf(i*lineEvery), distX, distY - lineEvery*i*mulitplicationFactor);
        }
    }

    private int getHighestVal(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}