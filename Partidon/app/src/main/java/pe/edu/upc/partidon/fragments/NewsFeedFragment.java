package pe.edu.upc.partidon.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import pe.edu.upc.partidon.Adapters.NotificationAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.NotificationRepository;
import pe.edu.upc.partidon.models.Notification;


public class NewsFeedFragment extends Fragment {
    //

    private static final String TAG = "NewFragment";
    private RecyclerView notificationUserRecyclerView;
    private NotificationRepository notificationRepository;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_feed,container,false);

        notificationRepository = new NotificationRepository(getContext());

        notificationUserRecyclerView = (RecyclerView) view.findViewById(R.id.newsRecyclerView);
        notificationUserRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadCourtsAsync();



        return view;
    }


    private void loadCourtsAsync(){
        SharedPreferences references = this.getActivity().getSharedPreferences("PARTIDON", Context.MODE_PRIVATE);

        notificationRepository.getNotifications(Integer.parseInt(references.getString("id_player",null)) ,new NotificationRepository.NotificationsCallback(){
            @Override
            public void onComplete(List<Notification> notifications) {


                notificationUserRecyclerView.setAdapter(new NotificationAdapter(getContext(),notifications));

            }

            @Override
            public void onError(String message) {
                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }


}
