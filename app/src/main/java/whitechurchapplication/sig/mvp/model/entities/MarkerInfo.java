package whitechurchapplication.sig.mvp.model.entities;

public class MarkerInfo {

    private double longitude;
    private double latitude;
    private String name;
    private String shortDescription;

    public MarkerInfo() {
    }

    public MarkerInfo(double longitude, double latitude, String name, String shortDescription) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.shortDescription = shortDescription;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
