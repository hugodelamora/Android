package mx.iteso.pam2017.ms705203.fragments;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Hugo de la Mora on 22/02/2017.
 */

public class DetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }
        setContentView(R.layout.details_activity_layout);
        Bundle extras=getIntent().getExtras();
        String os = extras.getString("operating_system");
        TextView textView= (TextView) findViewById(R.id.textoDetails);
        textView.setText(os);
    }
}
