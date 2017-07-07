package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.GsonBuilder;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import pe.edu.upc.partidon.models.Team;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hector on 30/06/2017.
 */

public class InformationTeamRepository {

    private final PartidonService service;
    private Context context;

    public InformationTeamRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.partidon.pe.hu/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        service = retrofit.create(PartidonService.class);
    }




    public interface InformationTeamCallback{
        void onComplete(Team team);
        void onError(String message);
    }

    public void getInformationTeam(final int id,final InformationTeamRepository.InformationTeamCallback callback){

        SharedPreferences references = getDefaultSharedPreferences();
        service.getInformationTeam(id,references.getString("api_token",null)).enqueue(new Callback<Team>() {
            @Override
            public void onResponse(Call<Team> call, Response<Team> response) {



                Team team = response.body();
                callback.onComplete(team);
            }

            @Override
            public void onFailure(Call<Team> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }


}
