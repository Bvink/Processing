package tornado.org.week_two;

import processing.core.PApplet;
import processing.core.PShape;
import tornado.org.week_two.constants.Constants;
import tornado.org.week_two.objects.Quake;

import java.util.ArrayList;
import java.util.List;

public class WeekTwoMapIceland extends PApplet {

    PShape iceland;
    List<Quake> quakes = new ArrayList<>();

    public void setup(){
        size(1186, 841);
        iceland = loadShape(Constants.ICE_LOCATION);
        noLoop();
    }

    public void draw() {
        background(0);
        shape(iceland);
    }

    private void readJSON() {
        //Blah blah get stuff from json and put it in the map;
    }
}
