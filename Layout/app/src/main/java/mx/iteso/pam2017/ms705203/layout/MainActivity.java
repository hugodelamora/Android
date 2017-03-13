package mx.iteso.pam2017.ms705203.layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button b2;
    TextView tv1;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inline
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        tv1 = (TextView) findViewById(R.id.TextView1);
        et1 = (EditText) findViewById(R.id.editText1);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fun1();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textos();
            }
        });

    }


    public void fun1() {
        Toast.makeText(getApplicationContext(), "This is my Toast message!",Toast.LENGTH_LONG).show();
    }
    public void textos() {
        String texto=tv1.getText().toString();
        texto=texto+" usuario ";
        tv1.setText(texto);
    }

    public void zzonClick() {
        switch(1){
            case(2):
                Toast.makeText(getApplicationContext(), "This is my Toast message! 222",Toast.LENGTH_LONG).show();
                break;
            case(3):
                textos();
                break;

        }
    }
}
