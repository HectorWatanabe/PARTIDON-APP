package pe.edu.upc.partidon.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

import java.util.List;

import pe.edu.upc.partidon.Activities.ConfigurationUserActivity;
import pe.edu.upc.partidon.Activities.FriendListActivity;
import pe.edu.upc.partidon.Adapters.NewsFeedAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.SpecialityRepository;
import pe.edu.upc.partidon.datasource.UserPublicationsRepository;
import pe.edu.upc.partidon.datasource.UserRepository;
import pe.edu.upc.partidon.models.NewsComments;
import pe.edu.upc.partidon.models.Specialty;

public class UserFragment extends Fragment {
        private static final String TAG = "UserFragment";
        private RecyclerView userRecyclerView;
        private TextView nameUserTextView;
        private FloatingActionMenu menu;
        private ImageView sportUser1ImageView;
        private ImageView sportUser2ImageView;
        private ImageView sportUser3ImageView;
        private ImageView userImageView;
        private TextView locationNameUserTextView;


    private FragmentIterationListener mCallback = null;
    public interface FragmentIterationListener{
        public void onFragmentIteration(Bundle parameters);
    }


    private SpecialityRepository specialityRepository;
    private UserPublicationsRepository userPublicationsRepository;
     private UserRepository userRepository;

     public UserFragment() {
            // Required empty public constructor
        }

        // TODO: Rename and change types and number of parameters
        public static UserFragment newInstance() {
            UserFragment fragment = new UserFragment();
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_user,container,false);

            userRepository = new UserRepository(getContext());
            specialityRepository = new SpecialityRepository(getContext());
            userPublicationsRepository = new UserPublicationsRepository(getContext());

            userRecyclerView = (RecyclerView) view.findViewById(R.id.userRecyclerView);
            userRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            final SharedPreferences references = this.getActivity().getSharedPreferences("PARTIDON", Context.MODE_PRIVATE);
            nameUserTextView = (TextView) view.findViewById(R.id.nameUserTextView);
            locationNameUserTextView = (TextView) view.findViewById(R.id.locationNameUserTextView);
            sportUser1ImageView = (ImageView) view.findViewById(R.id.sportUser1ImageView);
            sportUser2ImageView = (ImageView) view.findViewById(R.id.sportUser2ImageView);
            sportUser3ImageView = (ImageView) view.findViewById(R.id.sportUser3ImageView);
            userImageView = (ImageView) view.findViewById(R.id.userImageView);
            if(references.getString("id_player",null) != null){
                nameUserTextView.setText(references.getString("name",null));
                locationNameUserTextView.setText(references.getString("local",null));

            }

            switch(references.getString("icon_image",null))
            {
                case "default_player_1": userImageView.setImageResource(R.drawable.default_player_1); break;
                case "default_player_2": userImageView.setImageResource(R.drawable.default_player_2); break;
                case "default_player_3": userImageView.setImageResource(R.drawable.default_player_3); break;
                default: userImageView.setImageResource(R.drawable.all); break;
            }


            com.github.clans.fab.FloatingActionButton floatingActionButtonFriendsUser;
            com.github.clans.fab.FloatingActionButton floatingActionButtonConfigurationUser;
            menu = (FloatingActionMenu) view.findViewById(R.id.menu);


            floatingActionButtonFriendsUser = (com.github.clans.fab.FloatingActionButton) view.findViewById(R.id.menu_friends);
            floatingActionButtonConfigurationUser = (com.github.clans.fab.FloatingActionButton) view.findViewById(R.id.configuration);

            floatingActionButtonFriendsUser.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {


                    Intent intent = new Intent(v.getContext(), FriendListActivity.class);
                    startActivity(intent);

                }
            });

            floatingActionButtonConfigurationUser.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), ConfigurationUserActivity.class);
                    intent.putExtra("user_id",references.getString("id",null));
                    startActivity(intent);

                }
            });

            loadCourtsAsync();
            loadSpecialitysAsync();

            setHasOptionsMenu(true);

            return view;
        }




    public void loadCourtsAsync(){
        final SharedPreferences references = this.getActivity().getSharedPreferences("PARTIDON", Context.MODE_PRIVATE);
        userPublicationsRepository.getUserPublications(Integer.parseInt(references.getString("id",null)), new UserPublicationsRepository.UserPublicationsCallback() {
            @Override
            public void onComplete(List<NewsComments> courts) {

                userRecyclerView.setAdapter(new NewsFeedAdapter(getContext(), courts));
            }

            @Override
            public void onError(String message) {
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loadSpecialitysAsync(){
        final SharedPreferences references = this.getActivity().getSharedPreferences("PARTIDON", Context.MODE_PRIVATE);
        specialityRepository.getSpecialityPlayer(Integer.parseInt(references.getString("id_player",null)), new SpecialityRepository.SpecialityCallback() {
            @Override
            public void onComplete(List<Specialty> specialties) {
                for (Specialty sport :specialties) {
                    switch (sport.getSport())
                    {

                        case 1:
                            sportUser1ImageView.setImageResource(R.drawable.soccer_icon);
                            break;
                        case 2:
                            sportUser2ImageView.setImageResource(R.drawable.basketball);
                            break;
                        case 3:
                            sportUser3ImageView.setImageResource(R.drawable.tennis_ball_icon);
                            break;
                    }
                }

            }

            @Override
            public void onError(String message) {
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }




    }
