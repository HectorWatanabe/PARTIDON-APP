package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.GsonBuilder;

import java.util.List;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import pe.edu.upc.partidon.models.Business;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hector on 29/06/2017.
 */

public class BusinessesCompanyRepository {

    private final PartidonService service;
    private Context context;

    public BusinessesCompanyRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.partidon.pe.hu/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        service = retrofit.create(PartidonService.class);
    }


    public interface BusinessesCompanyCallback{
        void onComplete(List<Business> businesses);
        void onError(String message);
    }

    public void getBusinessesCompany(int id,final BusinessesCompanyRepository.BusinessesCompanyCallback callback){
        SharedPreferences references = getDefaultSharedPreferences();
        service.getBusinessesCompany(id,references.getString("api_token",null)).enqueue(new Callback<List<Business>>() {
            @Override
            public void onResponse(Call<List<Business>> call, Response<List<Business>> response) {
                List<Business> businesses = response.body();
                callback.onComplete(businesses);
            }

            @Override
            public void onFailure(Call<List<Business>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });


    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }

}
