package whitechurchapplication.sig.mvp.model.entities;

import java.util.List;

public class Location {

    private Integer id;
    private String name;
    private String address;
    private String phone;
    private String shortDescription;
    private String longDescription;
    private Double longitude;
    private Double latitude;
    private Integer version;
    private LocationType locationType;
    private List<ImageList> imageList = null;

    public Location(){

    }

    public Location(whitechurchapplication.sig.mvp.model.rest.json.response.Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.address = location.getAddress();
        this.phone = location.getPhone();
        this.shortDescription = (String) location.getShortDescription();//TODO change Location.response OBJ to STRNG
        this.longDescription = (String) location.getLongDescription();
        this.longitude = location.getLongitude();
        this.latitude = location.getLatitude();
        this.version = location.getVersion();
//        locationType = location.getLocationType();

    }

    public Location(int id,String name,String shortDescription,double longitude,double latitude,String address) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public List<ImageList> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImageList> imageList) {
        this.imageList = imageList;
    }

}



