package pe.edu.upc.partidon.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.partidon.Activities.MatchWallActivity;
import pe.edu.upc.partidon.Activities.TeamActivity;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Notification;

/**
 * Created by user on 15/06/2017.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

        private Context context;
        private final List<Notification> notifications;

        public NotificationAdapter(Context context, @NonNull List<Notification> notifications){
            this.context = context;
            this.notifications = notifications;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notification,parent,false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Notification notification = notifications.get(position);
            if(notification.getPlayer() != null) {
                holder.nameUserTextView.setText(notification.getPlayer().getUser().getName());
                switch(notification.getPlayer().getUser().getIcon_image())
                {
                    case "default_player_1": holder.imageUserView.setImageResource(R.drawable.default_player_1); break;
                    case "default_player_2": holder.imageUserView.setImageResource(R.drawable.default_player_2); break;
                    case "default_player_3": holder.imageUserView.setImageResource(R.drawable.default_player_3); break;
                    default: holder.imageUserView.setImageResource(R.drawable.all); break;
                }

            }else if(notification.getTeam() != null){
                holder.nameUserTextView.setText(notification.getTeam().getTeamName());
                switch(notification.getTeam().getIcon_image())
                {
                    case "default_team_1": holder.imageUserView.setImageResource(R.drawable.default_team_1); break;
                    case "default_team_2": holder.imageUserView.setImageResource(R.drawable.default_team_2); break;
                    case "default_team_3": holder.imageUserView.setImageResource(R.drawable.default_team_3); break;
                    default: holder.imageUserView.setImageResource(R.drawable.all); break;
                }
            }else if(notification.getMatch() != null){
                holder.nameUserTextView.setText(notification.getMatch().getTitle());
                switch(notification.getMatch().getIcon_image())
                {
                    case "default_match_1": holder.imageUserView.setImageResource(R.drawable.default_match_1); break;
                    case "default_match_2": holder.imageUserView.setImageResource(R.drawable.default_match_2); break;
                    case "default_match_3": holder.imageUserView.setImageResource(R.drawable.default_match_3); break;
                    default: holder.imageUserView.setImageResource(R.drawable.all); break;
                }
            }

            holder.notificationUserTextView.setText(notification.getUserNotification());
            holder.dateNotificationTextView.setText(notification.getCreated_at());



            if(notification.getMatch()!=null || notification.getTeam()!= null) {
                holder.notificationContainer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = null;
                        if (notification.getMatch() != null) {
                            i = new Intent(context, MatchWallActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putInt("match_id", notification.getMatch_id());
                            i.putExtras(bundle);
                        } else if (notification.getTeam() != null) {
                            i = new Intent(context, TeamActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putInt("team_id", notification.getTeam_id());
                            i.putExtras(bundle);
                        }


                        context.startActivity(i);
                    }
                });
            }

        }

        @Override
        public int getItemCount() {
            return notifications.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView nameUserTextView;
            TextView notificationUserTextView;
            View notificationContainer;
            TextView dateNotificationTextView;
            ImageView imageUserView;

            public ViewHolder(View itemView) {

                super(itemView);
                nameUserTextView = (TextView) itemView.findViewById(R.id.nameUserTextView);
                notificationUserTextView = (TextView) itemView.findViewById(R.id.notificationUserTextView);
                notificationContainer = itemView.findViewById(R.id.notificationContainer);
                dateNotificationTextView = (TextView) itemView.findViewById(R.id.dateNotificationTextView);
                imageUserView = (ImageView) itemView.findViewById(R.id.imageUserView);
            }
        }
    }
