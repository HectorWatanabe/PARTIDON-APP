package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.GsonBuilder;

import java.util.List;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import pe.edu.upc.partidon.models.Specialty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hector on 06/07/2017.
 */

public class SpecialityRepository {
    private final PartidonService service;
    private Context context;

    public SpecialityRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.partidon.pe.hu/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        service = retrofit.create(PartidonService.class);
    }


    public interface SpecialityCallback{
        void onComplete(List<Specialty> speciality);
        void onError(String message);
    }

    public void getSpecialityPlayer(int id,final SpecialityRepository.SpecialityCallback callback){
        SharedPreferences references = getDefaultSharedPreferences();
        service.getSpecialityPlayer(id,references.getString("api_token",null)).enqueue(new Callback<List<Specialty>>() {
            @Override
            public void onResponse(Call<List<Specialty>> call, Response<List<Specialty>> response) {
                List<Specialty> speciality = response.body();
                callback.onComplete(speciality);
            }

            @Override
            public void onFailure(Call<List<Specialty>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });


    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }

}
