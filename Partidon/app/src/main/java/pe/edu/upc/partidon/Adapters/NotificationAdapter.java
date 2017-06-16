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
import pe.edu.upc.partidon.models.Match;
import pe.edu.upc.partidon.models.Notification;
import pe.edu.upc.partidon.models.Player;

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
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notification,null));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.nameUserTextView.setText(notifications.get(position).getUserName());
            holder.notificationUserTextView.setText(notifications.get(position).getUserNotification());
        }

        @Override
        public int getItemCount() {
            return notifications.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView nameUserTextView;
            TextView notificationUserTextView;

            public ViewHolder(View itemView) {

                super(itemView);
                nameUserTextView = (TextView) itemView.findViewById(R.id.nameUserTextView);
                notificationUserTextView = (TextView) itemView.findViewById(R.id.notificationUserTextView);
            }
        }
    }
