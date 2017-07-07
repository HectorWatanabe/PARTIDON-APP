package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.GsonBuilder;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import pe.edu.upc.partidon.models.Player;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hector on 27/05/2017.
 */

public class UserRepository {

    private final PartidonService service;
    private Context context;

    public UserRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.partidon.pe.hu/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        service = retrofit.create(PartidonService.class);
    }



    public void saveUser(Player player){
        SharedPreferences preferences = getDefaultSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("id_player",player.getId_playerAsString());
        editor.putString("id",player.getUser().getIdAsString());
        editor.putString("name",player.getUser().getName());
        editor.putString("local",player.getUser().getAddress());
        editor.putString("sport",player.getUser().getSportAsString());
        editor.putString("api_token",player.getUser().getApi_token());
        editor.putString("icon_image",player.getUser().getIcon_image());


        editor.apply();
    }

    public interface LoginCallback{
        void onComplete(Player player);
        void onError(String message);
    }



    public void getlogin(String username, String password,final UserRepository.LoginCallback callback){

        service.getlogin( username,  password).enqueue(new Callback<Player>() {
            @Override
            public void onResponse(Call<Player> call, Response<Player> response) {

                Player player = response.body();
                if(player!=null) {
                    saveUser(player);
                }
                callback.onComplete(player);
            }

            @Override
            public void onFailure(Call<Player> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }



}
