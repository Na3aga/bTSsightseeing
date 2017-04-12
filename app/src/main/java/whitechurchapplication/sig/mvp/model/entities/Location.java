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
    private List<Object> imageList = null;

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

    public Location(String name,String shortDescription,double longitude,double latitude) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longitude = longitude;
        this.latitude = latitude;

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

    public List<Object> getImageList() {
        return imageList;
    }

    public void setImageList(List<Object> imageList) {
        this.imageList = imageList;
    }
}



