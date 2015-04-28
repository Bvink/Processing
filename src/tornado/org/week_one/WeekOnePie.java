package tornado.org.week_one;

import processing.core.PApplet;

public class WeekOnePie extends PApplet {

    private double[] values = {15, 23, 58, 52, 35, 24};
    private String[] attributes = {"Val 1", "Val 2", "Val 3", "Val 4", "Val 5", "Val 6"};

    public void setup() {
        size(800, 400);
        background(255);
        noLoop();
    }

    public void draw() {
        background(255);
        pieChart(300, calcRadiance(values));
    }

    private int[] calcRadiance(double[] values) {
        double total = calcTotal(values);
        int[] newArray = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            newArray[i] = (int) Math.round((360*(values[i]/total)));
        }
        return newArray;
    }

    private double calcTotal(double[] values) {
        int total = 0;
        for (double i : values) {
            total+=i;
        }
        return total;
    }

    private void pieChart(float diameter, int[] data) {
        float lastAngle = 0;
        for (int i = 0; i < data.length; i++) {
            float gray = map(i, 0, data.length, 0, 255);
            fill(gray);
            arc(width / 4, height / 2, diameter, diameter, lastAngle, lastAngle + radians(data[i]));
            lastAngle += radians(data[i]);
            legend(gray, i);
        }
    }

    private void legend(float gray, int i) {
        stroke(0);
        fill(gray);
        rect(500, 20+i*20+(40*i), 30, 30);
        fill(0);
        text(attributes[i], 550, 40+i*20+(40*i));
    }
}
