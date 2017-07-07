package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import pe.edu.upc.partidon.models.Player;
import retrofit2.Retrofit;

/**
 * Created by Hector on 18/06/2017.
 */

public class PlayerRepository {

    private final PartidonService service;
    private Context context;

    public PlayerRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        service = retrofit.create(PartidonService.class);
    }




    private void savePlayer(Player player){
        SharedPreferences preferences = getDefaultSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("id",player.getId_playerAsString());
        editor.putString("name",player.getUser().getName());
        editor.putString("local",player.getUser().getAddress());
        editor.putString("sport",player.getUser().getSportAsString());


        editor.apply();
    }

    public Player getPlayer(){
        Player player = new Player();
        player.getUser().setName("Mafer");
        player.setId_player(1);
        player.getUser().setSport(2);
        player.getUser().setAddress("San Isidro");
        return player;
        /*SharedPreferences preferences = getDefaultSharedPreferences();
        String id = preferences.getString("id",null);
        if(id == null){
            return null;
        }

        User user = new User();
        user.setId(id);
        user.setName(preferences.getString("name",""));
        return user;*/
    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }

}
