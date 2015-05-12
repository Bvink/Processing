package tornado.org.week_two.objects;

public class Quake {

    private String timestamp;
    private Float latitude;
    private Float longitude;
    private Float depth;
    private Float size;
    private Float quality;
    private String humanReadableLocation;

    public Quake(String timestamp, Float latitude, Float longitude, Float depth, Float size, Float quality, String humanReadableLocation) {
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

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setDepth(Float depth) {
        this.depth = depth;
    }

    public Float getDepth() {
        return depth;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public Float getSize() {
        return size;
    }

    public void setQuality(Float quality) {
        this.quality = quality;
    }

    public Float getQuality() {
        return quality;
    }

    public void setHumanReadableLocation(String humanReadableLocation) {
        this.humanReadableLocation = humanReadableLocation;
    }

    public String getHumanReadableLocation() {
        return humanReadableLocation;
    }
}

