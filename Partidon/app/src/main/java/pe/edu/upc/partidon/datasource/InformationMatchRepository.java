package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.GsonBuilder;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import pe.edu.upc.partidon.models.Match;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hector on 01/07/2017.
 */

public class InformationMatchRepository {

    private final PartidonService service;
    private Context context;

    public InformationMatchRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.partidon.pe.hu/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        service = retrofit.create(PartidonService.class);
    }




    public interface InformationMatchCallback{
        void onComplete(Match match);
        void onError(String message);
    }

    public void getInformationMatch(final int id,final InformationMatchRepository.InformationMatchCallback callback){
        SharedPreferences references = getDefaultSharedPreferences();
        service.getInformationMatch(id,references.getString("api_token",null)).enqueue(new Callback<Match>() {
            @Override
            public void onResponse(Call<Match> call, Response<Match> response) {



                Match match = response.body();
                callback.onComplete(match);
            }

            @Override
            public void onFailure(Call<Match> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }


}
