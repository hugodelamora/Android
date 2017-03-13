package mx.iteso.pam2017.ms705203.examen1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Lista extends AppCompatActivity {
    ListView listView;
    String[] authors = {"1. William Shakespeare", "2. Octavio Paz"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listView = (ListView) findViewById(R.id.lv1);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, authors);
        listView.setAdapter(aa);

        //Log.d("success2", success2 );
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg) {
                String val =(String) parent.getItemAtPosition(position);

                openAutoresDetalle(val,position+"");
            }
        });


    }

    public void openAutoresDetalle(String autor,String position) {
        Log.d("success2", position);

        Intent autoresDetalles = new Intent(this, AutoresDetalleActivity.class);

        autoresDetalles.putExtra("AUTOR", autor);
        autoresDetalles.putExtra("POSITION", position);
        startActivity(autoresDetalles);
        //Toast.makeText(getApplicationContext(),position+"", Toast.LENGTH_LONG).show();
    }
}