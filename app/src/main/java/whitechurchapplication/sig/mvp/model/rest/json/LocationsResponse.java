package whitechurchapplication.sig.mvp.model.rest.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by macbookpro on 27.03.17.
 */

public class LocationsResponse {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("address")

    private String address;
    @SerializedName("phone")

    private String phone;
    @SerializedName("shortDescription")

    private Object shortDescription;
    @SerializedName("longDescription")

    private Object longDescription;
    @SerializedName("longitude")

    private Double longitude;
    @SerializedName("latitude")

    private Double latitude;
    @SerializedName("version")

    private Integer version;
    @SerializedName("locationType")

    private LocationType locationType;
    @SerializedName("imageList")

    private List<Object> imageList = null;

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


