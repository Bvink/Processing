package tornado.org.week_two;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;
import processing.core.PApplet;
import processing.core.PShape;
import tornado.org.week_two.constants.Constants;
import tornado.org.week_two.objects.Quake;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WeekTwoMapIceland extends PApplet {

    private final int SCREEN_WIDTH = 1186;
    private final int SCREEN_HEIGHT = 841;
    private final int MAX_DEPTH = 20;
    PShape iceland;
    List<Quake> quakes = new ArrayList<>();

    public void setup(){
        size(SCREEN_WIDTH, SCREEN_HEIGHT);
        iceland = loadShape(Constants.ICE_LOCATION);
        readJSON(getJSON());
        noLoop();
    }

    public void draw() {
        background(0);
        shape(iceland);
        drawCircles();
        drawLegend();
    }

    private void drawCircles() {
        for (Quake q : quakes) {
            fill(lerpColor(color(255, 255, 255), color(255, 0, 0), ((float) q.getDepth()) / MAX_DEPTH), 200);
            float s = (float) q.getSize();
            float lat = getLat(q);
            float lon = getLong(q);
            ellipse(lat, lon, amplify(s), amplify(s));
        }
    }

    private void drawLegend() {
        fill(0);
        gradientRect((float) (SCREEN_WIDTH*0.75), (float) (SCREEN_HEIGHT*0.95), (float) (SCREEN_WIDTH*0.2), 10);
        float b = getMaxQuakeSize();
        fill(color(255, 0, 0));
        stroke(0);
        ellipse((float) (SCREEN_WIDTH*0.77), (float) (SCREEN_HEIGHT*0.85), amplify(b), amplify(b));
        fill(0);
        text("=", (float) (SCREEN_WIDTH*0.85), (float) (SCREEN_HEIGHT*0.85));
        text(b + " richter", (float) (SCREEN_WIDTH*0.90), (float) (SCREEN_HEIGHT*0.85));
    }

    private float amplify(float f) {
        return (f+1)*30;
    }

    private float getMaxQuakeSize() {
        List<Double> list = new ArrayList<>();
        for (Quake q : quakes) {
            list.add(q.getSize());
        }
        double max = Collections.max(list);
        return (float) max;
    }

    private void gradientRect(float x, float y, float w, float h) {
        for (int i = (int) x; i <= x+w; i++) {
            float inter = map(i, x, x + w, 0, 1);
            stroke(lerpColor(color(255, 255, 255), color(255, 0, 0), inter), 200);
            line(i, y, i, y+h);
        }

        text(0, x, y-5);
        text(MAX_DEPTH, x+w-10, y-5);
        text("depth", (x+(w/2))-10, y-5);
    }

    private float getLat(Quake q) {
        return map((float) q.getLatitude(), 66.8f, 63.1f, 0, SCREEN_WIDTH);
    }

    private float getLong(Quake q) {
        return map((float) q.getLongitude(), -25, -13, 0, SCREEN_HEIGHT);
    }

    private String getJSON() {
        String jsonloc = "C:\\Users\\Calamity\\IdeaProjects\\Processing\\src\\tornado\\org\\week_two\\data\\ijsland-metingen.json";
        StringBuilder s = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(jsonloc));
            String stringRead = br.readLine();
            while (stringRead != null) {
                s.append(stringRead);
                s.append("\n");
                stringRead = br.readLine();
            }
        } catch(Exception e) {
            e.printStackTrace();
            s.append("error");
        }
        return s.toString();
    }

    private void readJSON(String s) {
        JsonParser parser = new JsonParser();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonElement el = parser.parse(s);
        s = gson.toJson(el);

        JSONObject obj = new JSONObject(s);
        JSONArray arr = obj.getJSONArray("results");
        for (int i = 0; i < arr.length(); i++) {
            obj = arr.getJSONObject(i);
            Quake quake = new Quake(
                    obj.getString("timestamp"),
                    obj.getDouble("latitude"),
                    obj.getDouble("longitude"),
                    obj.getDouble("depth"),
                    obj.getDouble("size"),
                    obj.getDouble("quality"),
                    obj.getString("humanReadableLocation")
            );
            quakes.add(quake);
        }
    }
}
