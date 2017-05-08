package whitechurchapplication.sig.mvp.model.entities;

import com.google.gson.annotations.SerializedName;

public class LocationType {

    @SerializedName("id")
    private Integer id;
    @SerializedName("type")
    private String type;

    public LocationType(whitechurchapplication.sig.mvp.model.rest.json.response.LocationType locationType) {
        this .id = locationType.getId();
        this .type = locationType.getType();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}




