package mx.iteso.pam2017.ms705203.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Hugo de la Mora on 10/03/2017.
 */

public class PhoneReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Aaaa", Toast.LENGTH_LONG).show();
        Log.d("PHONE_STATE", "aaaaaaaaaaaaaaaaaaaaa");
            TelephonyManager phoneManager =
                    (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);

            if(phoneManager.getCallState() == TelephonyManager.CALL_STATE_RINGING)
            {
                String fromNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.i("TAG", "u have a call from a number " + fromNumber);
            }


        /*
        if(intent != null && intent.getAction().equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)){
            String newPhoneState = intent.hasExtra(TelephonyManager.EXTRA_STATE)
                    ? intent.getStringExtra(TelephonyManager.EXTRA_STATE) : null;

            if (newPhoneState != null){
                Log.v("PHONE_STATE", newPhoneState);

                //si su estado es timbrando, validar el # de telefono
                if(newPhoneState.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                    String phoneNumber= intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                    Log.v("PHONE_NUMBER", phoneNumber);


                }
            }

        }*/

    }
}
