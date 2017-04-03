package whitechurchapplication.sig.mvp.model.entities;

import java.util.List;

public class Location {

    private Integer id;
    private String name;
    private String address;
    private String phone;
    private Object shortDescription;
    private Object longDescription;
    private Double longitude;
    private Double latitude;
    private Integer version;
    private LocationType locationType;
    private List<Object> imageList = null;

    public Location(whitechurchapplication.sig.mvp.model.rest.json.response.Location location) {
        this.id = location.getId();
        //TODO add all
    }

    public Integer getId() {
//        if (id == null) return 1;
//        else return id;
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

    public Object getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(Object shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Object getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(Object longDescription) {
        this.longDescription = longDescription;
    }

    public Double getLongitude() {
        if (longitude == null) return 0.0;
        else return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        if (latitude == null) return 0.0;
        else return latitude;
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


