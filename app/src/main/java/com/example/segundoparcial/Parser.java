package com.example.segundoparcial;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;


public class Parser {

    String telefono = "";
    String jsonpersonas="";
    String nombrePersona="" ;


    public Parser(String jsonpersonas,String nombrePersona )
    {

        this.jsonpersonas =jsonpersonas ;
        this.nombrePersona = nombrePersona ;
    }

    public String ParserPersona()
    {


        try {

            JSONArray jsonArray = new JSONArray(jsonpersonas);


            for (int   i = 0 ; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                if (nombrePersona.equals("")) {

                    MainActivity.jsonArrayaux.put(jsonObject);

                } else {


                    Log.d("persona", jsonObject.getString("Nombre") + "  " + jsonObject.getString("Telefono") + " " + nombrePersona);
                    if (nombrePersona.equals(jsonObject.getString("Nombre"))) {
                        telefono = jsonObject.getString("Telefono");

                        if (!telefono.equals("")) {
                            break;

                        }
                    }
                }
            }


        }catch  (Exception e){

            e.printStackTrace();

        }


        return telefono;

    }

}
