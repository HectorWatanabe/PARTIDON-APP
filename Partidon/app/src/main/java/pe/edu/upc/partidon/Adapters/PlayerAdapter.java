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
import pe.edu.upc.partidon.models.Player;

/**
 * Created by user on 26/05/2017.
 */

 public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

        private Context context;
        private final List<Player> players;

        public PlayerAdapter(Context context, @NonNull List<Player> players){
            this.context = context;
            this.players = players;
        }

        @Override
        public PlayerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new PlayerAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_player,null));
        }

        @Override
        public void onBindViewHolder(PlayerAdapter.ViewHolder holder, int position) {
            holder.namePlayerTextView.setText(players.get(position).getName());
        }

        @Override
        public int getItemCount() {
            return players.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView namePlayerTextView;

            public ViewHolder(View itemView) {

                super(itemView);
                namePlayerTextView = (TextView) itemView.findViewById(R.id.namePlayerTextView);
            }
        }
    }
