package tornado.org.week_two.objects;

public class Quake {

    private String timestamp;
    private double latitude;
    private double longitude;
    private double depth;
    private double size;
    private double quality;
    private String humanReadableLocation;

    public Quake(String timestamp, double latitude, double longitude, double depth, double size, double quality, String humanReadableLocation) {
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.depth = depth;
        this.size = size;
        this.quality = quality;
        this.humanReadableLocation = humanReadableLocation;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getDepth() {
        return depth;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setQuality(Double quality) {
        this.quality = quality;
    }

    public double getQuality() {
        return quality;
    }

    public void setHumanReadableLocation(String humanReadableLocation) {
        this.humanReadableLocation = humanReadableLocation;
    }

    public String getHumanReadableLocation() {
        return humanReadableLocation;
    }
}

