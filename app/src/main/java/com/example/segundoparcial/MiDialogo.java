package com.example.segundoparcial;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.DialogFragment;

public class MiDialogo extends DialogFragment {

    MainActivity activity ;

    public MiDialogo (Activity activity){

        this.activity = (MainActivity) activity;

    }



    @Override
    public Dialog onCreateDialog (Bundle bundle){


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View mView = layoutInflater.inflate(R.layout.nuevo_contacto, null);
        builder.setView(mView);


        ClickDialog cd = new ClickDialog(mView , this.activity);
        builder.setPositiveButton("Guardar",cd);
        builder.setNegativeButton("Cancelar",cd);

        return builder.create();


    }
}
