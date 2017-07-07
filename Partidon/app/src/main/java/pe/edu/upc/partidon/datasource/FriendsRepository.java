package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.GsonBuilder;

import java.util.List;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import pe.edu.upc.partidon.models.Friend;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hector on 30/06/2017.
 */

public class FriendsRepository {

    private final PartidonService service;
    private Context context;

    public FriendsRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.partidon.pe.hu/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        service = retrofit.create(PartidonService.class);
    }


    public interface FriendsCallback{
        void onComplete(List<Friend> publications);
        void onError(String message);
    }

    public void getFriends(int id,final FriendsRepository.FriendsCallback callback){
        SharedPreferences references = getDefaultSharedPreferences();
        service.getFriends(id,references.getString("api_token",null)).enqueue(new Callback<List<Friend>>() {
            @Override
            public void onResponse(Call<List<Friend>> call, Response<List<Friend>> response) {
                List<Friend> friends = response.body();
                callback.onComplete(friends);
            }

            @Override
            public void onFailure(Call<List<Friend>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });


    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }

}
