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
 * Created by user on 26/05/2017.
 */

 public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

        private Context context;
        private final List<NewsComments> comments;

        public UserAdapter(Context context,@NonNull List<NewsComments> comments){
            this.context = context;
            this.comments = comments;
        }

        @Override
        public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new UserAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_news,null));
        }

        @Override
        public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
            holder.nameUserTextView.setText(comments.get(position).getNameUser());
            holder.commentTextView.setText(comments.get(position).getComment());
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
                nameUserTextView = (TextView) itemView.findViewById(R.id.nameUserTextView);
                commentTextView = (TextView) itemView.findViewById(R.id.commentTextView);
            }
        }
    }
