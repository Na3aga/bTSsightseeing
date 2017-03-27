package whitechurchapplication.sig.mvp.model;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import whitechurchapplication.sig.mvp.model.rest.HttpApi;

/**
 * Created by macbookpro on 25.03.17.
 */

public class RetrofitGenerator {

    private static HttpApi apiService;

    public static HttpApi getApiService() {
        return apiService;
    }

    private static void genarateApi() {
        Retrofit retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl(HttpApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(HttpApi.class);


    }


}
