package mx.iteso.pam2017.ms705203.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Hugo de la Mora on 22/02/2017.
 */

public class DetailFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details,container,false);
        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
    public void setText(String item){
        TextView textView = (TextView) getView()
                    .findViewById(R.id.textoDetails);
        textView.setText(item);
    }
}
