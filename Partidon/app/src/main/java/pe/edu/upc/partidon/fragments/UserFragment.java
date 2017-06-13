package pe.edu.upc.partidon.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.NewsFeedAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.UserRepository;
import pe.edu.upc.partidon.models.NewsComments;
import pe.edu.upc.partidon.models.User;
import pe.edu.upc.partidon.views.RankDialog;

public class UserFragment extends Fragment {
        private static final String TAG = "UserFragment";
        private RecyclerView userRecyclerView;
        private TextView nameUserTextView;
        private RatingBar userRatingBar;

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

            userRecyclerView = (RecyclerView) view.findViewById(R.id.userRecyclerView);
            userRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            userRecyclerView.setAdapter(new NewsFeedAdapter(getContext(),getUserComment()));

            userRatingBar = (RatingBar) view.findViewById(R.id.userRatingBar);
            userRatingBar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    RankDialog.show(getContext(),new RankDialog.Callback(){


                        @Override
                        public void onComplete(String content) {
                            Toast.makeText(getContext(),content,Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onClose() {

                        }
                    });

                }
            });



            nameUserTextView = (TextView) view.findViewById(R.id.nameUserTextView);

            User user = userRepository.getUser();
            if(user != null){
                nameUserTextView.setText(user.getNameUser());
            }


            return view;
        }





     private List<NewsComments> getUserComment(){
         List<NewsComments> results = new ArrayList<>();
         for (int i = 0; i < 20; i++) {
             NewsComments newsComments = new NewsComments();
             newsComments.setNameUser("Maria Fernanda Segovia Chacón " + i);
             newsComments.setComment("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                     "labore et dolore magna aliqua. Un ullamco laboris nisi ut aliquip ex ea commodo consequat. " + i);
             results.add(newsComments);
         }
         return results;
     }


    }
