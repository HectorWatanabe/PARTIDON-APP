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
import pe.edu.upc.partidon.models.MemberTeam;

/**
 * Created by user on 26/05/2017.
 */

 public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

        private Context context;
        private final List<MemberTeam> membersTeam;

        public PlayerAdapter(Context context, @NonNull List<MemberTeam> membersTeam){
            this.context = context;
            this.membersTeam = membersTeam;
        }

        @Override
        public PlayerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new PlayerAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_player,parent,false));
        }

        @Override
        public void onBindViewHolder(PlayerAdapter.ViewHolder holder, int position) {
            final MemberTeam member = membersTeam.get(position);
            holder.namePlayerTextView.setText(member.getPlayer().getUser().getName());

            switch(member.getPlayer().getUser().getIcon_image())
            {
                case "default_player_1": holder.imageView.setImageResource(R.drawable.default_player_1); break;
                case "default_player_2": holder.imageView.setImageResource(R.drawable.default_player_2); break;
                case "default_player_3": holder.imageView.setImageResource(R.drawable.default_player_3); break;
                default: holder.imageView.setImageResource(R.drawable.all); break;
            }

        }

        @Override
        public int getItemCount() {
            return membersTeam.size();
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
