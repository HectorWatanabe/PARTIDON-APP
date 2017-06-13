package pe.edu.upc.partidon.views;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.RatingBar;

import pe.edu.upc.partidon.R;

/**
 * Created by Hector on 11/06/2017.
 */

public class RankDialog {

    public interface Callback{
        void onComplete(String content);
        void onClose();
    }

    public static void show(final Context context, final RankDialog.Callback callback){

        View content = LayoutInflater.from(context).inflate(R.layout.dialog_rank,null);
        final RatingBar itemRankRatingBar = (RatingBar) content.findViewById(R.id.itemRankRatingBar);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Valoración");
        builder.setView(content);
        builder.setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callback.onComplete(String.valueOf(itemRankRatingBar.getNumStars()));
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callback.onClose();
            }
        });
        builder.show();
    }
}


