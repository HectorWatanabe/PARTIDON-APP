package pe.edu.upc.partidon.datasource.network;

import java.util.List;

import pe.edu.upc.partidon.models.Business;
import pe.edu.upc.partidon.models.BusinessesBySport;
import pe.edu.upc.partidon.models.Court;
import pe.edu.upc.partidon.models.CourtSection;
import pe.edu.upc.partidon.models.Friend;
import pe.edu.upc.partidon.models.Match;
import pe.edu.upc.partidon.models.MemberTeam;
import pe.edu.upc.partidon.models.NewsComments;
import pe.edu.upc.partidon.models.Notification;
import pe.edu.upc.partidon.models.Player;
import pe.edu.upc.partidon.models.Score;
import pe.edu.upc.partidon.models.Specialty;
import pe.edu.upc.partidon.models.Team;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Hector on 27/05/2017.
 */

public interface PartidonService {


    @FormUrlEncoded
    @POST("auth/players")
    Call<Player> getlogin(@Field("email") String email,
                     @Field("password") String password);
    @FormUrlEncoded
    @POST("publications")
    Call<Void> getregisterPublications(@Query("api_token") String apiToken, @Field("comment") String comment,
                          @Field("author_id") int author_id,@Field("user_id") int user_id,@Field("match_id") int match_id,@Field("team_id") int team_id );

    @FormUrlEncoded
    @POST("matches/{id}/scores")
    Call<Void> getregisterScore(@Path("id") int id, @Field("score_team_red") int score_team_red, @Field("score_team_blue") int score_team_blue,@Query("api_token") String apiToken);

    @FormUrlEncoded
    @POST("teams/{id}/players")
    Call<Void> getregisterMember(@Path("id") int id,@Query("api_token") String apiToken , @Field("role") String role, @Field("player_id") int player_id);

    @FormUrlEncoded
    @POST("teams")
    Call<Void> getRegisterTeam(@Query("api_token") String apiToken , @Field("name") String name, @Field("players") int players,@Field("icon_image") String icon_image, @Field("author_id") int author_id, @Field("sport_id") int sport_id);

    @FormUrlEncoded
    @POST("matches")
    Call<Void> getRegisterMatch(@Query("api_token") String apiToken , @Field("name") String name, @Field("address") String address,@Field("district") String district, @Field("match_date") String match_date, @Field("icon_image") String icon_image, @Field("author_id") int author_id, @Field("referee_id") int referee_id, @Field("sport_id") int sport_id, @Field("team_red_id") int team_red_id, @Field("team_blue_id") int team_blue_id);

    @FormUrlEncoded
    @POST("players")
    Call<Void> getRegisterUser( @Field("name") String name, @Field("email") String email,@Field("password") String password,@Field("address") String address);




    @GET("companies")
    Call<List<Court>> getCourts(@Query("api_token") String apiToken);

    @GET("companies/{id}")
    Call<Court> getCourtWall(@Path("id") int id,@Query("api_token") String apiToken);

    @GET("companies/{id}/sportsfields")
    Call<List<CourtSection>> getCourtSection(@Path("id") int id,@Query("api_token") String apiToken);

    @GET("users/{id}/wall")
    Call<List<NewsComments>> getCourtPublication(@Path("id") int id, @Query("api_token") String apiToken);

    @GET("players/{id}/sports")
    Call<List<Specialty>> getSpecialityPlayer(@Path("id") int id, @Query("api_token") String apiToken);


    @GET("companies/{id}/sports")
    Call<List<Business>> getBusinessesCompany(@Path("id") int id, @Query("api_token") String apiToken);

    @GET("teams")
    Call<List<Team>> getTeams(@Query("api_token") String apiToken);

    @GET("players/{id}/teams")
    Call<List<Team>> getTeamsOfPlayer(@Path("id") int id,@Query("api_token") String apiToken);

    @GET("teams/{id}")
    Call<Team> getInformationTeam(@Path("id") int id, @Query("api_token") String apiToken);

    @GET("teams/{id}/wall")
    Call<List<NewsComments>> getTeamPublications(@Path("id") int id, @Query("api_token") String apiToken);

    @GET("teams/{id}/players")
    Call<List<MemberTeam>> getMembersTeam(@Path("id") int id, @Query("api_token") String apiToken);

    @GET("players/{id}/friends")
    Call<List<Friend>> getFriends(@Path("id") int id, @Query("api_token") String apiToken);

    @GET("players/{id}/notifications")
    Call<List<Notification>> getNotifications(@Path("id") int id, @Query("api_token") String apiToken);

    @GET("matches")
    Call<List<Match>> getMatches(@Query("api_token") String apiToken);

    @GET("matches/{id}")
    Call<Match> getInformationMatch(@Path("id") int id,@Query("api_token") String apiToken);

    @GET("players/{id}/matches")
    Call<List<Match>> getMatchesOfPlayer(@Path("id") int id,@Query("api_token") String apiToken);


    @GET("matches/{id}/wall")
    Call<List<NewsComments>> getMatchPublications(@Path("id") int id,@Query("api_token") String apiToken);

    @GET("matches/{id}/scores")
    Call<List<Score>> getScoresMatch(@Path("id") int id, @Query("api_token") String apiToken);

    @GET("users/{id}/wall")
    Call<List<NewsComments>> getUserPublications(@Path("id") int id, @Query("api_token") String apiToken);

    @GET("sports/{id}/businesses")
    Call<List<BusinessesBySport>> getBusinessesSport(@Path("id") int id, @Query("api_token") String apiToken);

}
