package pe.edu.upc.partidon.datasource.network;

import pe.edu.upc.partidon.models.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Hector on 27/05/2017.
 */

public interface PartidonService {


    @POST("users/login")
    Call<User> login(@Field("username") String username,
                     @Field("password") String password);

}
