package whitechurchapplication.sig.mvp.model.rest.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by macbookpro on 27.03.17.
 */

class LocationType {

    @SerializedName("id")

    private Integer id;
    @SerializedName("type")

    private String type;

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


