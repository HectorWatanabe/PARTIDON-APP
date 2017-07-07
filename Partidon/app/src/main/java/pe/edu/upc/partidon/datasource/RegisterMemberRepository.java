package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.GsonBuilder;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hector on 06/07/2017.
 */

public class RegisterMemberRepository {


    private final PartidonService service;
    private Context context;

    public RegisterMemberRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.partidon.pe.hu/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        service = retrofit.create(PartidonService.class);
    }


    public interface RegisterMemberCallback{
        void onComplete();
        void onError(String message);
    }



    public void getregisterMember(int id, String role, int player_id, final RegisterMemberRepository.RegisterMemberCallback callback){

        SharedPreferences references = getDefaultSharedPreferences();
        service.getregisterMember(id,references.getString("api_token",null),role ,player_id ).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                callback.onComplete();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }

}
