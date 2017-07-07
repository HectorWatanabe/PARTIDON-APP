package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.GsonBuilder;

import java.util.List;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import pe.edu.upc.partidon.models.Business;
import pe.edu.upc.partidon.models.BusinessesBySport;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hector on 04/07/2017.
 */

public class BusinessesSportRepository {

    private final PartidonService service;
    private Context context;

    public BusinessesSportRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.partidon.pe.hu/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        service = retrofit.create(PartidonService.class);
    }


    public interface BusinessesSportCallback{
        void onComplete(List<BusinessesBySport> businesses);
        void onError(String message);
    }

    public void getBusinessesSport(int id,final BusinessesSportRepository.BusinessesSportCallback callback){
        SharedPreferences references = getDefaultSharedPreferences();
        service.getBusinessesSport(id,references.getString("api_token",null)).enqueue(new Callback<List<BusinessesBySport>>() {
            @Override
            public void onResponse(Call<List<BusinessesBySport>> call, Response<List<BusinessesBySport>> response) {
                List<BusinessesBySport> businesses = response.body();
                callback.onComplete(businesses);
            }

            @Override
            public void onFailure(Call<List<BusinessesBySport>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });


    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }


}
