package com.example.segundoparcial;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;


public class ClickDialog implements DialogInterface.OnClickListener {
    View d ;
    MainActivity activitymain ;

    public ClickDialog (View vista , Activity activity){

        this.d= vista ;
        this.activitymain = (MainActivity) activity;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {


        EditText nombre = (EditText)d.findViewById(R.id.edtIngresarNombre);
        EditText telefono = (EditText)d.findViewById(R.id.edtingresartelefono);
        if (which == Dialog.BUTTON_POSITIVE){

            if (nombre.getText().toString().equals("")){
                Toast.makeText(activitymain,
                        "el campo nombre no puede estar vacio",
                        Toast.LENGTH_SHORT).show();

            }else if (telefono.getText().toString().equals("")){
                Toast.makeText(activitymain,
                        "el campo telefono no puede estar vacio",
                        Toast.LENGTH_SHORT).show();

            }else{


                JSONObject jsonObj = new JSONObject();

                try {
                    jsonObj.put("Nombre", nombre.getText().toString());
                    jsonObj.put("Telefono", telefono.getText().toString());
                    activitymain.jsonArray.put(jsonObj);
                    activitymain.GuardarPreferencias();
                    activitymain.CargarPreferencias();

                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }




        }
    }
}
