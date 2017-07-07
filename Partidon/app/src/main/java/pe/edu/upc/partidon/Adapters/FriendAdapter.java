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
import pe.edu.upc.partidon.models.Friend;

/**
 * Created by Hector on 30/06/2017.
 */

  public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {

        private Context context;
        private final List<Friend> friends;

        public FriendAdapter(Context context, @NonNull List<Friend> friends){
            this.context = context;
            this.friends = friends;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View rootView = LayoutInflater.from(context).inflate(R.layout.item_player, null, false);
            RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            rootView.setLayoutParams(lp);
            return new ViewHolder(rootView);

//            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_player,parent,false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.namePlayerTextView.setText(friends.get(position).getPlayer().getUser().getName());

            switch(friends.get(position).getPlayer().getUser().getIcon_image())
            {
                case "default_player_1": holder.imageView.setImageResource(R.drawable.default_player_1); break;
                case "default_player_2": holder.imageView.setImageResource(R.drawable.default_player_2); break;
                case "default_player_3": holder.imageView.setImageResource(R.drawable.default_player_3); break;
                default: holder.imageView.setImageResource(R.drawable.all); break;
            }
        }

        @Override
        public int getItemCount() {
            return friends.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView namePlayerTextView;
            ImageView imageView;

            public ViewHolder(View itemView) {

                super(itemView);
                namePlayerTextView = (TextView) itemView.findViewById(R.id.namePlayerTextView);
                imageView = (ImageView) itemView.findViewById(R.id.imageView);
            }
        }



    }

