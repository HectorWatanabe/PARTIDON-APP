package pe.edu.upc.partidon.views;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;

import pe.edu.upc.partidon.R;

/**
 * Created by user on 11/06/2017.
 */

public class ScoreDialog {

    public interface Callback{
        void onComplete(String contentone,String contenttwo);
        void onClose();
    }

    public static void show(final Context context, final ScoreDialog.Callback callback){

        View content = LayoutInflater.from(context).inflate(R.layout.dialog_score,null);
        final NumberPicker oneTeam = (NumberPicker) content.findViewById(R.id.oneTeamNumberPicker);
        final NumberPicker twoTeam = (NumberPicker) content.findViewById(R.id.twoTeamNumberPicker);
        oneTeam.setMinValue(0);
        twoTeam.setMinValue(0);

        oneTeam.setMaxValue(10);
        twoTeam.setMaxValue(10);
        oneTeam.setWrapSelectorWheel(true);
        twoTeam.setWrapSelectorWheel(true);


        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Publicar");
        builder.setView(content);
        builder.setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callback.onComplete(String.valueOf(oneTeam.getValue()),String.valueOf(twoTeam.getValue()));
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
