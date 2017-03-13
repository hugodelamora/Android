package mx.iteso.pam2017.ms705203.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Hugo de la Mora on 22/02/2017.
 */

public class MyListFragment extends android.app.ListFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] operating_systems=new String[]{
                "Android","iOS","Windows Mobile","BlackBerry OS","webOS","Ubuntu","Windows 10","OS X","Linux"
        };
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,operating_systems);

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        DetailFragment fragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detalleFragment);
         if(fragment != null && fragment.isInLayout()){
             fragment.setText(item);
         }else{
            Intent intent = new Intent(getActivity().getApplicationContext(),DetailActivity.class);
             intent.putExtra("perating_system",item);
             startActivity(intent);

         }
    }
}
