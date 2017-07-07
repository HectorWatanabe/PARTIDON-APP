package pe.edu.upc.partidon.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.NewsComments;

/**
 * Created by Hector on 20/05/2017.
 */

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ViewHolder> {

    private Context context;
    private final List<NewsComments> comments;

    public NewsFeedAdapter(Context context,@NonNull List<NewsComments> comments){
        this.context = context;
        this.comments = comments;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_news,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameUserTextView.setText(comments.get(position).getUser().getName());
        holder.commentTextView.setText(comments.get(position).getComment());
        holder.dateCommentTextView.setText(comments.get(position).getCreated_at());
        switch(comments.get(position).getUser().getIcon_image())
        {
            case "default_player_1": holder.photoUserImageView.setImageResource(R.drawable.default_player_1); break;
            case "default_player_2": holder.photoUserImageView.setImageResource(R.drawable.default_player_2); break;
            case "default_player_3": holder.photoUserImageView.setImageResource(R.drawable.default_player_3); break;
            default: holder.photoUserImageView.setImageResource(R.drawable.all); break;
        }

    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameUserTextView;
        TextView commentTextView;
        TextView dateCommentTextView;
        ImageView photoUserImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameUserTextView = (TextView) itemView.findViewById(R.id.nameUserTextView);
            commentTextView = (TextView) itemView.findViewById(R.id.commentTextView);
            dateCommentTextView = (TextView) itemView.findViewById(R.id.dateCommentTextView);
            photoUserImageView = (ImageView) itemView.findViewById(R.id.photoUserImageView);
        }
    }
}
