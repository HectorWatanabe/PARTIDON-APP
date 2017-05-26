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
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_news,null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsComments comment = comments.get(position);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameUserTextView;
        TextView commentTextView;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
