package tornado.org.week_two;

import processing.core.PApplet;
import processing.core.PShape;
import tornado.org.week_two.constants.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WeekTwoMapUSA extends PApplet {

    PShape usa;
    Map<String, Float> map = new HashMap<String, Float>();

    public void setup() {
        size(1280, 791);
        loadTSV();
        usa = loadShape(Constants.USA_LOCATION);
        noLoop();
    }

    public void draw() {
        background(0);
        shape(usa);
        for (PShape p : usa.getChildren()) {
            p.disableStyle();
            Float f = map.get(p.getName());
            fill(f != null ? lerpColor(color(255, 255, 255), color(255, 0, 0), f / Collections.max(map.values())) : color(0,0,0));
            noStroke();
            shape(p);
        }
    }

    private void loadTSV() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(Constants.TSV_LOCATION));
            String stringRead = br.readLine();
            while (stringRead != null) {
                String[] elements = stringRead.split("\\t");
                map.put(elements[0], Float.parseFloat(elements[1]));
                stringRead = br.readLine();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
