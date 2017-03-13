package mx.iteso.pam2017.ms705203.examen1a;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Hugo de la Mora on 04/03/2017.
 */
public class ListFragment extends android.app.ListFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    // fija
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] values = new String[] {getResources().getString(R.string.a1), getResources().getString(R.string.a2)};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }
    @Override

    public void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        DetailFragment fragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detalleFragment);

        if (fragment != null && fragment.isInLayout()
                && getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //go to tablet fragmento
            fragment.setText(position+"",item);

        } else {
            //Log.d("aaa","PORTAIR");celular
            Intent intent = new Intent(getActivity().getApplicationContext(),DetailActivity.class);
            intent.putExtra("AUTOR", item);
            intent.putExtra("POSITION", position+"");
            startActivity(intent);
        }
    }

}

