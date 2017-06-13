package whitechurchapplication.sig.mvp.model.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageList {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("url")
    @Expose
    private String url;

    public ImageList(int id,String url){
        this .id = id;
        this .url = url;
    }

    public ImageList(ImageList imageList) {
//
//        for(int i = 0; i < imageList.size(); i++) {
//            this.id = imageList.get(i).getId();
//            this.url = imageList.get(i).getUrl();
//        }

        this .id = imageList.getId();
        this .url = imageList.getUrl();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        if (url==null){
            return "url";
        }
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}