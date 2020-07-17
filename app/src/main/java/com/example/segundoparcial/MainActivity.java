package com.example.segundoparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import org.json.JSONArray;


public class MainActivity extends AppCompatActivity implements  SearchView.OnQueryTextListener  {


    JSONArray jsonArray;
    TextView texto ;
    boolean inicio = true;
    static JSONArray jsonArrayaux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonArray = new JSONArray();
        jsonArrayaux = new JSONArray( );
        texto = (TextView)findViewById(R.id.textojson);

        CargarPreferencias();
        inicio =false;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.campo_buscar);

        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(this);


        return true;
    }


        @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

            if (id == R.id.agregar_contacto) {

                MiDialogo md = new MiDialogo(this);
                md.show(super.getSupportFragmentManager(),"nuevo contacto");
            }

                return super.onOptionsItemSelected(item);
    }


    public void GuardarPreferencias ( ){
        SharedPreferences preferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("personas", jsonArray.toString());
        editor.apply();

    }
    public void CargarPreferencias (){
        SharedPreferences preferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        texto.setText(preferences.getString("personas", ""));
        if (inicio){
            if (preferences.getString("personas", "").equals("")){



            }else {
                Parser parser = new Parser(preferences.getString("personas", ""), "");
                jsonArray = jsonArrayaux;
            }
        }


    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        if (query.length()>1) {


         Parser miparser = new Parser(texto.getText().toString(),query);
         String telefono = miparser.ParserPersona();
           if (telefono.equals("")){
               Dialogonoexiste noexiste= new Dialogonoexiste(this,"La persona que busco no esta dentro de la lista");
               noexiste.show(super.getSupportFragmentManager(),"no existe");

           }else{

               Dialogoexiste existe = new Dialogoexiste(this,"El telefono es :"+telefono);
               existe.show(super.getSupportFragmentManager(),"existe ");

           }



        }else {



        }
        return false;


    }

    @Override
    public boolean onQueryTextChange(String newText) {

      return  false ;
    }

}
