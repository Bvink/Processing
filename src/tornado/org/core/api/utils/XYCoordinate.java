package tornado.org.core.api.utils;

public class XYCoordinate {

    private int x;
    private int y;

    public XYCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getCoordinate() {
        int[] c = {this.x, this.y};
        return c;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
