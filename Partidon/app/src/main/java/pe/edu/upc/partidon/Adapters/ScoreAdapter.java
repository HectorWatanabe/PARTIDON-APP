package pe.edu.upc.partidon.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Score;

/**
 * Created by Hector on 03/06/2017.
 */


public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ViewHolder> {

    private Context context;
    private final List<Score> scores;

    public ScoreAdapter(Context context,@NonNull List<Score> scores){
        this.context = context;
        this.scores = scores;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_score,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Score score = scores.get(position);
        switch (score.getAway_score()){
            case 0: holder.awayScoreImageView.setImageResource(R.drawable.awaycard); break;
            case 1: holder.awayScoreImageView.setImageResource(R.drawable.awaycard1); break;
            case 2: holder.awayScoreImageView.setImageResource(R.drawable.awaycard2); break;
            case 3: holder.awayScoreImageView.setImageResource(R.drawable.awaycard3); break;
            case 4: holder.awayScoreImageView.setImageResource(R.drawable.awaycard4); break;
            case 5: holder.awayScoreImageView.setImageResource(R.drawable.awaycard5); break;
            case 6: holder.awayScoreImageView.setImageResource(R.drawable.awaycard6); break;
            case 7: holder.awayScoreImageView.setImageResource(R.drawable.awaycard7); break;
            case 8: holder.awayScoreImageView.setImageResource(R.drawable.awaycard8); break;
            case 9: holder.awayScoreImageView.setImageResource(R.drawable.awaycard9); break;
            case 10: holder.awayScoreImageView.setImageResource(R.drawable.awaycard10); break;
        }
        switch (score.getHome_score()){
            case 0: holder.homeScoreImageView.setImageResource(R.drawable.homecard); break;
            case 1: holder.homeScoreImageView.setImageResource(R.drawable.homecard1); break;
            case 2: holder.homeScoreImageView.setImageResource(R.drawable.homecard2); break;
            case 3: holder.homeScoreImageView.setImageResource(R.drawable.homecard3); break;
            case 4: holder.homeScoreImageView.setImageResource(R.drawable.homecard4); break;
            case 5: holder.homeScoreImageView.setImageResource(R.drawable.homecard5); break;
            case 6: holder.homeScoreImageView.setImageResource(R.drawable.homecard6); break;
            case 7: holder.homeScoreImageView.setImageResource(R.drawable.homecard7); break;
            case 8: holder.homeScoreImageView.setImageResource(R.drawable.homecard8); break;
            case 9: holder.homeScoreImageView.setImageResource(R.drawable.homecard9); break;
            case 10: holder.homeScoreImageView.setImageResource(R.drawable.homecard10); break;
        }
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView homeScoreImageView;
        ImageView awayScoreImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            homeScoreImageView = (ImageView) itemView.findViewById(R.id.homeScoreImageView);
            awayScoreImageView = (ImageView) itemView.findViewById(R.id.awayScoreImageView);
        }
    }
}
