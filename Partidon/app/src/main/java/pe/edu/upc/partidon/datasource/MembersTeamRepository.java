package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.GsonBuilder;

import java.util.List;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import pe.edu.upc.partidon.models.MemberTeam;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hector on 30/06/2017.
 */

public class MembersTeamRepository {

    private final PartidonService service;
    private Context context;

    public MembersTeamRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.partidon.pe.hu/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        service = retrofit.create(PartidonService.class);
    }


    public interface MembersTeamCallback{
        void onComplete(List<MemberTeam> publications);
        void onError(String message);
    }

    public void getMembersTeam(int id,final MembersTeamRepository.MembersTeamCallback callback){

        SharedPreferences references = getDefaultSharedPreferences();
        service.getMembersTeam(id,references.getString("api_token",null)).enqueue(new Callback<List<MemberTeam>>() {
            @Override
            public void onResponse(Call<List<MemberTeam>> call, Response<List<MemberTeam>> response) {
                List<MemberTeam> players = response.body();
                callback.onComplete(players);
            }

            @Override
            public void onFailure(Call<List<MemberTeam>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });


    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }

}
