package mx.iteso.pam2017.ms705203.examen1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AutoresDetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autores_detalle);


        Intent intent = getIntent();
        String position = intent.getStringExtra("POSITION");
        String autor = intent.getStringExtra("AUTOR");

        String librosA1 = "Hamlet";
        String librosA2 = "Romeo y Julieta";
        String librosB1 = "Laberinto de la soledad";
        String librosB2 = "Piedra de sol";

        TextView et=(TextView) findViewById(R.id.etAutor);
        if(position.equals("0")){
            et.setText(autor+": libros ["+librosA1+", "+System.getProperty ("line.separator")+" "+librosA2+"]");

        }else if(position.equals("1")){
            et.setText(autor+": libros ["+librosB1+", "+System.getProperty ("line.separator")+" "+librosB2+"]");

        }

    }
}
