package pe.edu.upc.partidon.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.NewsComments;
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
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_score,null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameUserScoreTextView.setText(scores.get(position).getUser_name());
        holder.scoreMatchTitleTextView.setText(scores.get(position).getTitle_match());
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameUserScoreTextView;
        TextView scoreMatchTitleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameUserScoreTextView = (TextView) itemView.findViewById(R.id.nameUserScoreTextView);
            scoreMatchTitleTextView = (TextView) itemView.findViewById(R.id.scoreMatchTitleTextView);
        }
    }
}
