package whitechurchapplication.sig.mvp.model.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import whitechurchapplication.sig.mvp.model.rest.json.response.LocationsResponse;

/**
 * Created by macbookpro on 22.03.17.
 */

public interface HttpApi {

    String BASE_URL ="edu.bionic-university.com:2221/sightseeing/";

    @GET("/locations")
    Call<List<LocationsResponse>> getLocations();

}
