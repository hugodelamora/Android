package mx.iteso.pam2017.ms705203.airplanereceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Hugo de la Mora on 10/03/2017.
 */

public class AirplaneReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context,"Airplane changed", Toast.LENGTH_LONG).show();

    }
}
