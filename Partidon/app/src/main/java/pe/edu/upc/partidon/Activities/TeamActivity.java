package pe.edu.upc.partidon.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

import java.util.List;

import pe.edu.upc.partidon.Adapters.NewsFeedAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.InformationTeamRepository;
import pe.edu.upc.partidon.datasource.MembersTeamRepository;
import pe.edu.upc.partidon.datasource.RegisterMemberRepository;
import pe.edu.upc.partidon.datasource.RegisterPublicationsRepository;
import pe.edu.upc.partidon.datasource.TemPublicationsRepository;
import pe.edu.upc.partidon.models.MemberTeam;
import pe.edu.upc.partidon.models.NewsComments;
import pe.edu.upc.partidon.models.Team;
import pe.edu.upc.partidon.views.PostDialog;

public class TeamActivity extends AppCompatActivity {


    private static final String TAG = "TeamActivity";
    private RecyclerView teamWallRecyclerView;
    private FloatingActionMenu menu;
    private InformationTeamRepository informationTeamRepository;
    private TemPublicationsRepository temPublicationsRepository;
    private RegisterPublicationsRepository registerPublicationsRepository;
    private MembersTeamRepository membersTeamRepository;
    private RegisterMemberRepository registerMemberRepository;
    private com.github.clans.fab.FloatingActionButton floatingActionButtonDeleteTeam;
    private TextView titleTeamWallTextView;
    private TextView gameTeamTotalInputTextView;
    private TextView idInputTextView;
    private ImageView sportTeamImageView;
    private ImageView teamAddImageView;
    private ImageView teamWallImageView;


    public TeamActivity() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TeamActivity newInstance() {
        TeamActivity fragment = new TeamActivity();
        return fragment;
    }


    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        informationTeamRepository = new InformationTeamRepository(this);
        temPublicationsRepository = new TemPublicationsRepository(this);
        registerPublicationsRepository = new RegisterPublicationsRepository(this);
        membersTeamRepository = new MembersTeamRepository(this);
        registerMemberRepository = new RegisterMemberRepository(this);
        com.github.clans.fab.FloatingActionButton floatingActionButtonPlayersTeam;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        menu = (FloatingActionMenu) findViewById(R.id.menu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        titleTeamWallTextView = (TextView) findViewById(R.id.titleTeamWallTextView);
        gameTeamTotalInputTextView = (TextView) findViewById(R.id.gameTeamTotalInputTextView);
        sportTeamImageView = (ImageView) findViewById(R.id.sportTeamImageView);
        teamAddImageView = (ImageView) findViewById(R.id.teamAddImageView);
        teamWallImageView = (ImageView) findViewById(R.id.teamWallImageView);
        idInputTextView =(TextView) findViewById(R.id.idInputTextView);

        teamWallRecyclerView = (RecyclerView) findViewById(R.id.teamWallRecyclerView);
        teamWallRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        floatingActionButtonPlayersTeam = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.view_player);

        floatingActionButtonPlayersTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), PlayerListActivity.class);
                intent.putExtra("team_id", getIntent().getExtras().getInt("team_id"));
                startActivity(intent);


            }
        });
        //menu.hideMenu(true);
        loadMembersAsync();
        loadCourtsAsync();
        loadCourtsAsync1();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if( id == android.R.id.home){
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    public void createTeamPost(View view){
        menu = (FloatingActionMenu) findViewById(R.id.menu);
        PostDialog.show(this, new PostDialog.Callback() {
            @Override
            public void onComplete(String content) {
                publicationAsync(content);
                Toast.makeText(getApplicationContext(),content,Toast.LENGTH_SHORT).show();
                menu.close(true);
            }

            @Override
            public void onClose() {
                menu.close(true);
            }
        });
    }


    public void memberClick(View view){
        memberregisterAsync();
        loadMembersAsync();
    }

    private void loadCourtsAsync(){
        int idTeam = getIntent().getExtras().getInt("team_id");
        final SharedPreferences references = this.getSharedPreferences("PARTIDON", Context.MODE_PRIVATE);
        informationTeamRepository.getInformationTeam(idTeam ,new InformationTeamRepository.InformationTeamCallback(){
            @Override
            public void onComplete(Team team) {
                titleTeamWallTextView.setText(team.getTeamName());
                gameTeamTotalInputTextView.setText(team.getAvailableSiteTeamAsString());
                idInputTextView.setText(team.getIdTeamAsString());


                switch(team.getIcon_image())
                {
                    case "default_team_1": teamWallImageView.setImageResource(R.drawable.default_team_1); break;
                    case "default_team_2": teamWallImageView.setImageResource(R.drawable.default_team_2); break;
                    case "default_team_3": teamWallImageView.setImageResource(R.drawable.default_team_3); break;
                    default: teamWallImageView.setImageResource(R.drawable.all); break;
                }

                switch (team.getSport())
                {

                    case 1:
                        sportTeamImageView.setImageResource(R.drawable.soccer_icon);
                        break;
                    case 2:
                        sportTeamImageView.setImageResource(R.drawable.basketball);
                        break;
                    case 3:
                        sportTeamImageView.setImageResource(R.drawable.tennis_ball_icon);
                        break;
                }
            }

            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadCourtsAsync1(){

        int idTeam = getIntent().getExtras().getInt("team_id");
        temPublicationsRepository.getTeamPublications(idTeam, new TemPublicationsRepository.TeamPublicationsCallback() {
            @Override
            public void onComplete(List<NewsComments> commentses) {

                teamWallRecyclerView.setAdapter(new NewsFeedAdapter(getApplicationContext(),commentses));
            }

            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void publicationAsync(String comment){
        final SharedPreferences references = this.getSharedPreferences("PARTIDON", Context.MODE_PRIVATE);
        int idTeam = getIntent().getExtras().getInt("team_id");
        registerPublicationsRepository.getregisterPublications(comment,Integer.parseInt(references.getString("id",null)),0,0,idTeam,new RegisterPublicationsRepository.RegisterPublicationsCallback(){
            @Override
            public void onComplete() {
                loadCourtsAsync1();
            }

            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void memberregisterAsync(){
        final SharedPreferences references = this.getSharedPreferences("PARTIDON", Context.MODE_PRIVATE);
        int idTeam = getIntent().getExtras().getInt("team_id");
        registerMemberRepository.getregisterMember(idTeam,"",Integer.parseInt(references.getString("id_player",null)),new RegisterMemberRepository.RegisterMemberCallback(){
            @Override
            public void onComplete() {
                loadMembersAsync();
            }

            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loadMembersAsync(){
        int idTeam = getIntent().getExtras().getInt("team_id");
        final SharedPreferences references = this.getSharedPreferences("PARTIDON", Context.MODE_PRIVATE);
        membersTeamRepository.getMembersTeam(idTeam ,new MembersTeamRepository.MembersTeamCallback(){
            @Override
            public void onComplete(List<MemberTeam> membersTeam) {

                int type=0;
                for (MemberTeam member :membersTeam) {

                    if(member.getPlayer_id()== Integer.parseInt(references.getString("id_player",null))){
                       type=1;
                    }
                }
                if(type==0) {
                    menu.hideMenu(true);
                    teamAddImageView.setVisibility(View.VISIBLE);
                }



            }

            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

}
