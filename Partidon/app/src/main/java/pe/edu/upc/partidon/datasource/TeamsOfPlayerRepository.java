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
 * Created by Hector on 06/07/2017.
 */

public class TeamsOfPlayerRepository {

    private final PartidonService service;
    private Context context;

    public TeamsOfPlayerRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.partidon.pe.hu/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        service = retrofit.create(PartidonService.class);
    }




    public interface TeamOfPlayerCallback{
        void onComplete(List<Team> teams);
        void onError(String message);
    }

    public void getTeamOfPlayer(final TeamsOfPlayerRepository.TeamOfPlayerCallback callback){

        SharedPreferences references = getDefaultSharedPreferences();
        service.getTeamsOfPlayer(Integer.parseInt(references.getString("id_player",null)),references.getString("api_token",null)).enqueue(new Callback<List<Team>>() {
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
