package mx.iteso.pam2017.ms705203.examen1a;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static mx.iteso.pam2017.ms705203.examen1a.R.id.autor_spinner;

//import android.app.DialogFragment;


public class NewBookActivity extends AppCompatActivity    implements DatePickerDialog.OnDateSetListener {
    Button dateB;
    Button saveB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        dateB= (Button) findViewById(R.id.dateB);
        dateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker(v);
            }
        });
        load((Spinner) findViewById(autor_spinner),R.array.autor_array);
        load((Spinner) findViewById(R.id.editorial_spinner),R.array.editorial_array);
        load((Spinner) findViewById(R.id.pais_spinner),R.array.pais_array);

        saveB= (Button) findViewById(R.id.saveB);
        saveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

    }

    public void load(Spinner spinner,int arr) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,arr, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }


    public void datePicker(View view){
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(),"date");
    }
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar cal=new GregorianCalendar(year,month,day);
        setDate(cal);
    }
    public void setDate(Calendar cal){
        final DateFormat df=DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.showDate)).setText(df.format(cal.getTime()));
    }

    public void save(){
        //textview
        EditText etNombre=(EditText) findViewById(R.id.etNombre);

        if(TextUtils.isEmpty(etNombre.getText()) ){
            Toast.makeText(this, getResources().getString(R.string.Name)+", "+getResources().getString(R.string.nonull),Toast.LENGTH_LONG).show();
            return;
        }

        EditText etPublicacion=(EditText) findViewById(R.id.etPublicacion);
        if(TextUtils.isEmpty(etPublicacion.getText())){
            Toast.makeText(this, getResources().getString(R.string.Publish)+", "+getResources().getString(R.string.nonull),Toast.LENGTH_LONG).show();
            return;
        }

        Spinner x=(Spinner)findViewById(R.id.autor_spinner);
        String autorS= x.getSelectedItem().toString();
        if(autorS.startsWith("Seleccione")){
            Toast.makeText(this, getResources().getString(R.string.tAuthor)+", "+getResources().getString(R.string.nonull),Toast.LENGTH_LONG).show();
            return;
        }

        x=(Spinner)findViewById(R.id.editorial_spinner);
        String editorialS = x.getSelectedItem().toString();
        if(editorialS.startsWith("Seleccione")){
            Toast.makeText(this, getResources().getString(R.string.tEditorial)+", "+getResources().getString(R.string.nonull),Toast.LENGTH_LONG).show();
            return;
        }

        x=(Spinner)findViewById(R.id.pais_spinner);
        String paisS = x.getSelectedItem().toString();
        if(paisS.startsWith("Seleccione")){
            Toast.makeText(this, getResources().getString(R.string.tCountry)+", "+getResources().getString(R.string.nonull),Toast.LENGTH_LONG).show();
            return;
        }

        TextView tvDate=(TextView) findViewById(R.id.showDate);
        if(tvDate.getText().equals("")){
            Toast.makeText(this, getResources().getString(R.string.dateP)+", "+getResources().getString(R.string.nonull),Toast.LENGTH_LONG).show();
            return;
        }

        Toast.makeText(this, getResources().getString(R.string.saved),Toast.LENGTH_LONG).show();

    }
    public static class DatePickerFragment extends DialogFragment{

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }

    }

}