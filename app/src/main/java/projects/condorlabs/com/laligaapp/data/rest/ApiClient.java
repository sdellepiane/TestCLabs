package projects.condorlabs.com.laligaapp.data.rest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import projects.condorlabs.com.laligaapp.BuildConfig;
import projects.condorlabs.com.laligaapp.data.entity.TeamEntity;
import projects.condorlabs.com.laligaapp.data.entity.response.NextFiveEventsResponse;
import projects.condorlabs.com.laligaapp.data.entity.response.TeamListResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ApiClient {

    public LaLigaInterface getLaLigaInterface() {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BuildConfig.HOST)
                .client(getBasicClientInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(LaLigaInterface.class);
    }

    public interface LaLigaInterface {

        @GET("search_all_teams.php")
        Call<TeamListResponse> getTeamList(@Query("l") String leagueName);

        @GET("eventsnext.php")
        Call<NextFiveEventsResponse> getNextFiveEvents(@Query("id") int id);
    }

    public static OkHttpClient getBasicClientInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(logging);
        builder.readTimeout(30, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();
        return client;
    }
}
