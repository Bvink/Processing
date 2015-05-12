package tornado.org.week_two;

import processing.core.PApplet;
import processing.core.PShape;
import tornado.org.week_two.constants.Constants;

public class WeekTwoMapIceland extends PApplet {

    PShape iceland;

    public void setup(){
        size(1186, 841);
        iceland = loadShape(Constants.ICE_LOCATION);
        noLoop();
    }

    public void draw() {
        background(0);
        shape(iceland);
    }
}
