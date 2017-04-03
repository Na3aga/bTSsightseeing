package whitechurchapplication.sig.mvp.model.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import whitechurchapplication.sig.mvp.model.rest.json.response.Location;

public interface HttpApi {

    String BASE_URL ="http://edu.bionic-university.com:2221/sightseeing-dev/";

    @GET("/locations")
    Call<List<Location>> getLocations();

}
