package mx.iteso.pam2017.ms705203.examen1a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bAutores;
    Button bLibros;
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bAutores = (Button) findViewById(R.id.b1);
        bAutores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAutores();
            }
        });
        bLibros = (Button) findViewById(R.id.b2);
        bLibros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLibros();
            }
        });

    }


    public void openAutores() {
        Intent intent = new Intent(this, Main2Activity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void openLibros() {
        Intent intent = new Intent(this, NewBookActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
