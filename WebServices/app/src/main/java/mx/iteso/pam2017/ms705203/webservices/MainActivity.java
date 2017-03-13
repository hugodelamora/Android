package mx.iteso.pam2017.ms705203.webservices;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    TextView tv3;
    //String URL="http://maps.googleapis.com/maps/api/geocode/json?sensor=false&latlng=38.404593,-0.529534";
    GetWebService hiloconexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et1=(EditText) findViewById(R.id.editText);
        et2=(EditText) findViewById(R.id.editText2);
        tv3=(TextView) findViewById(R.id.textView3);

        final Button boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boton1_Click();
            }
        });


    }
    public void boton1_Click(){
        hiloconexion = new GetWebService();
        hiloconexion.execute(et1.getText().toString(),et2.getText().toString());   // Parámetros que recibe doInBackground
    }

    public class GetWebService extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... params) {
            String URLWS="http://maps.googleapis.com/maps/api/geocode/json?sensor=false&latlng=";
            URLWS+=params[0]+","+params[1];
            URL url= null;
            String devuelve="";
            try {
                url = new URL(URLWS);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();//Abre Connección
                connection.setRequestProperty("User-Agent","Mozilla/5.0 (Linux: Android 1.5) es-MX");
                int respuesta= connection.getResponseCode();
                StringBuilder resultado= new StringBuilder();

                if (respuesta == HttpURLConnection.HTTP_OK){
                    InputStream in = new BufferedInputStream(connection.getInputStream());  // preparo la cadena de entrada
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));  // la introduzco en un BufferedReader
                    // El siguiente proceso lo hago porque el JSONOBject necesita un String y tengo
                    // que tranformar el BufferedReader a String. Esto lo hago a traves de un
                    // StringBuilder.
                    String line;
                    while ((line = reader.readLine()) != null) {
                        resultado.append(line);        // Paso toda la entrada al StringBuilder
                    }
                    //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                    JSONObject respuestaJSON = new JSONObject(resultado.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                    //Accedemos al vector de resultados
                    JSONArray resultJSON = respuestaJSON.getJSONArray("results");   // results es el nombre del campo en el JSON

                    //Vamos obteniendo todos los campos que nos interesen.
                    //En este caso obtenemos la primera dirección de los resultados.
                    String direccion="SIN DATOS PARA ESA LONGITUD Y LATITUD";
                    if (resultJSON.length()>0){
                        direccion = resultJSON.getJSONObject(0).getString("formatted_address");    // dentro del results pasamos a Objeto la seccion formated_address
                    }
                    devuelve = "Dirección: ["+URLWS+"]" + direccion;   // variable de salida que mandaré al onPostExecute para que actualice la UI

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return devuelve;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPreExecute() {
            tv3.setText("");
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            //    super.onPostExecute(s);
            tv3.setText(s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
}
