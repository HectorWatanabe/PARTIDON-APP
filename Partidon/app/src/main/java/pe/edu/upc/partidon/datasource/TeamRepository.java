package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.GsonBuilder;

import java.util.List;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import pe.edu.upc.partidon.models.Team;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hector on 18/06/2017.
 */

public class TeamRepository {


    private final PartidonService service;
    private Context context;

    public TeamRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.partidon.pe.hu/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        service = retrofit.create(PartidonService.class);
    }




    public interface TeamsCallback{
        void onComplete(List<Team> courts);
        void onError(String message);
    }

    public void getTeams(final TeamRepository.TeamsCallback callback){

        SharedPreferences references = getDefaultSharedPreferences();
        service.getTeams(references.getString("api_token",null)).enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {



                List<Team> teams = response.body();
                callback.onComplete(teams);
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }


}
