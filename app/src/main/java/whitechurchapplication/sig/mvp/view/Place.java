package whitechurchapplication.sig.mvp.view;

public class Place {
    String name;
    String info;
    int photoId;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Place(String name, String info, int photoId, int id) {
        this.name = name;
        this.info = info;

        this.photoId = photoId;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

}