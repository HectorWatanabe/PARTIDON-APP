package pe.edu.upc.partidon.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.GsonBuilder;

import java.util.List;

import pe.edu.upc.partidon.datasource.network.PartidonService;
import pe.edu.upc.partidon.models.Notification;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hector on 18/06/2017.
 */

public class NotificationRepository {

    private final PartidonService service;
    private Context context;
    private NotificationRepository notificationRepository;

    public NotificationRepository(Context context){
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.partidon.pe.hu/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();
        service = retrofit.create(PartidonService.class);
    }


    public interface NotificationsCallback{
        void onComplete(List<Notification> notifications);
        void onError(String message);
    }

    public void getNotifications(int id,final NotificationRepository.NotificationsCallback callback){

        SharedPreferences references = getDefaultSharedPreferences();
        service.getNotifications(id,references.getString("api_token",null)).enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                List<Notification> notifications = response.body();
                callback.onComplete(notifications);
            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });


    }


    private SharedPreferences getDefaultSharedPreferences(){
        return context.getSharedPreferences("PARTIDON",Context.MODE_PRIVATE);
    }

}
