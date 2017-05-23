package pe.edu.upc.partidon.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.NewsFeedAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.NewsComments;


public class NewsFeedFragment extends Fragment {
    //

    private static final String TAG = "NewFragment";
    private RecyclerView newsRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_feed,container,false);

        newsRecyclerView = (RecyclerView) view.findViewById(R.id.newsRecyclerView);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsRecyclerView.setAdapter(new NewsFeedAdapter(getContext(),getDummyCommnets()));

        return view;
    }


    private List<NewsComments> getDummyCommnets(){
        List<NewsComments> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            NewsComments newsComments = new NewsComments();
            newsComments.setTitle("Title " + i);
            results.add(newsComments);
        }
        return results;
    }


}
