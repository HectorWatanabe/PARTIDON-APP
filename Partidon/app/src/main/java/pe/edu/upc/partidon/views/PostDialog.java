package pe.edu.upc.partidon.views;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.upc.partidon.R;

/**
 * Created by brunoaybar on 10/06/2017.
 */

public class PostDialog {

    public interface Callback{
        void onComplete(String content);
        void onClose();
    }

    public static void show(final Context context, final Callback callback){

        View content = LayoutInflater.from(context).inflate(R.layout.dialog_post,null);
        final EditText editText = (EditText) content.findViewById(R.id.dialogPostEditText);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Publicar");
        builder.setView(content);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callback.onComplete(editText.getText().toString());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callback.onClose();
            }
        });
        builder.show();
    }

}
