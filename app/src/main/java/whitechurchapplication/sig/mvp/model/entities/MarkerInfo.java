package whitechurchapplication.sig.mvp.model.entities;

public class MarkerInfo {

    private double longitude;
    private int id;
    private double latitude;
    private String name;
    private String phone;
    private String shortDescription;
    private String adress;

    public MarkerInfo() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public MarkerInfo(int id, double longitude, double latitude, String name, String shortDescription, String adress, String phone) {

        this.longitude = longitude;
        this.id = id;
        this.latitude = latitude;
        this.phone = phone;
        this.name = name;
        this.adress = adress;
        this.shortDescription = shortDescription;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
