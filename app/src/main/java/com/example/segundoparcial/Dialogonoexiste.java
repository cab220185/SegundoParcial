package com.example.segundoparcial;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class Dialogonoexiste  extends DialogFragment {

    MainActivity activity ;
    String mensaje ;
    public Dialogonoexiste (Activity activity, String mensaje){

        this.activity = (MainActivity) activity;
        this.mensaje = mensaje ;

    }



    @Override
    public Dialog onCreateDialog (Bundle bundle){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("No Encontrada");
        builder.setMessage(mensaje);

        ListenerResultado listenerResultado = new ListenerResultado();
        builder.setPositiveButton("OK",listenerResultado);

        AlertDialog ad = builder.create();
        return ad;

    }
}



