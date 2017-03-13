package mx.iteso.pam2017.ms705203.examen1a;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Hugo de la Mora on 04/03/2017.
 */
public class DetailFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.e("Test", "hello");
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        return view;
    }


    public void setText(String position,String autor) {
        TextView et = (TextView) getView().findViewById(R.id.textoDetalle);
        String librosA1 = getResources().getString(R.string.a1a);
        String librosA2 = getResources().getString(R.string.a1b);
        String librosB1 = getResources().getString(R.string.a2a);
        String librosB2 = getResources().getString(R.string.a2b);

        String [] x=new String[2];
        if(position.equals("0")){
            et.setText(autor+": ["+librosA1+", "+System.getProperty ("line.separator")+" "+librosA2+"]");



        }else if(position.equals("1")){
            et.setText(autor+": ["+librosB1+", "+System.getProperty ("line.separator")+" "+librosB2+"]");
         }


    }
}

