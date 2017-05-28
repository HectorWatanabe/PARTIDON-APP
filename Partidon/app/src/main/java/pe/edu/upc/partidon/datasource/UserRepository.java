package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import pe.edu.upc.partidon.models.User;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Hector on 27/05/2017.
 */

public class UserRepository {

    private final PartidonService service;
    private Context context;

    public UserRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        service = retrofit.create(PartidonService.class);
    }


    public void login(String username, String password){
        try {
            Response<User> response = service.login(username,password).execute();
            User user = response.body();
            saveUser(user);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void saveUser(User user){
        SharedPreferences preferences = getDefaultSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("id",user.getId());
        editor.putString("name",user.getNameUser());

        editor.apply();
    }

    public User getUser(){
        User user2 = new User();
        user2.setNameUser("Mafer");
        user2.setId("123");
        return user2;
        /*SharedPreferences preferences = getDefaultSharedPreferences();
        String id = preferences.getString("id",null);
        if(id == null){
            return null;
        }

        User user = new User();
        user.setId(id);
        user.setNameUser(preferences.getString("name",""));
        return user;*/
    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }

}
