package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.GsonBuilder;

import java.util.List;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import pe.edu.upc.partidon.models.Score;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hector on 18/06/2017.
 */

public class ScoreRepository {

    private final PartidonService service;
    private Context context;

    public ScoreRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.partidon.pe.hu/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        service = retrofit.create(PartidonService.class);
    }



    public interface ScoresCallback{
        void onComplete(List<Score> Scores);
        void onError(String message);
    }

    public void getScoresMatch(int id,final ScoreRepository.ScoresCallback callback){

        SharedPreferences references = getDefaultSharedPreferences();
        service.getScoresMatch(id,references.getString("api_token",null)).enqueue(new Callback<List<Score>>() {
            @Override
            public void onResponse(Call<List<Score>> call, Response<List<Score>> response) {



                List<Score> Scores = response.body();
                callback.onComplete(Scores);
            }

            @Override
            public void onFailure(Call<List<Score>> Score, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }

}
