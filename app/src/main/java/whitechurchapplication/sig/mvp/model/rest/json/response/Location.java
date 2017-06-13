package whitechurchapplication.sig.mvp.model.rest.json.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import whitechurchapplication.sig.mvp.model.entities.*;
import whitechurchapplication.sig.mvp.model.entities.ImageList;

public class Location {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("longDescription")
    @Expose
    private String longDescription;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("version")
    @Expose
    private long version;
    @SerializedName("deleted")
    @Expose
    private Boolean deleted;
    @SerializedName("locationType")
    @Expose
    private whitechurchapplication.sig.mvp.model.rest.json.response.LocationType locationType;
    @SerializedName("imageList")
    @Expose
    private List<whitechurchapplication.sig.mvp.model.rest.json.response.ImageList> imageList = null;

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

    public long getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public whitechurchapplication.sig.mvp.model.rest.json.response.LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(whitechurchapplication.sig.mvp.model.rest.json.response.LocationType locationType) {
        this.locationType = locationType;
    }

    public List<whitechurchapplication.sig.mvp.model.rest.json.response.ImageList> getImageList() {
        return imageList;
    }

    public void setImageList(List<whitechurchapplication.sig.mvp.model.rest.json.response.ImageList> imageList) {
        this.imageList = imageList;
    }
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


}

