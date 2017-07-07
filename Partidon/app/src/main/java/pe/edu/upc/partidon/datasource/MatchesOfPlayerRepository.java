package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.GsonBuilder;

import java.util.List;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import pe.edu.upc.partidon.models.Match;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hector on 06/07/2017.
 */

public class MatchesOfPlayerRepository {

    private final PartidonService service;
    private Context context;

    public MatchesOfPlayerRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.partidon.pe.hu/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        service = retrofit.create(PartidonService.class);
    }




    public interface MatchesOfPlayerCallback{
        void onComplete(List<Match> matches);
        void onError(String message);
    }

    public void getMatchesOfPlayer(final MatchesOfPlayerRepository.MatchesOfPlayerCallback callback){

        SharedPreferences references = getDefaultSharedPreferences();
        service.getMatchesOfPlayer(Integer.parseInt(references.getString("id_player",null)),references.getString("api_token",null)).enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {



                List<Match> matches = response.body();
                callback.onComplete(matches);
            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }


}
