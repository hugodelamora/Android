package mx.iteso.pam2017.ms705203.examen1a;

/**
 * Created by Hugo de la Mora on 04/03/2017.
 */

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Debe validarse si el dispositivo se ha cambiado para el modo landscape
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
        //if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            finish();
            return;
        }
        setContentView(R.layout.details_activity_layout);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            Intent intent = getIntent();
            String position = intent.getStringExtra("POSITION");
            String autor = intent.getStringExtra("AUTOR");
            //String s = extras.getString("value");

            String librosA1 = getResources().getString(R.string.a1a);
            String librosA2 = getResources().getString(R.string.a1b);
            String librosB1 = getResources().getString(R.string.a2a);
            String librosB2 = getResources().getString(R.string.a2b);

            TextView et=(TextView) findViewById(R.id.textoDetalle);
            if(position.equals("0")){
                et.setText(autor+": ["+librosA1+", "+System.getProperty ("line.separator")+" "+librosA2+"]");

            }else if(position.equals("1")){
                et.setText(autor+": ["+librosB1+", "+System.getProperty ("line.separator")+" "+librosB2+"]");

            }
        }
    }
}
