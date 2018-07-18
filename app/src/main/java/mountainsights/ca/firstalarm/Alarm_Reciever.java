package mountainsights.ca.firstalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;



public class Alarm_Reciever extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Alarm_Recieve","Alarm reciever works!");
        Toast.makeText(context, "Alarm reciever connected", Toast.LENGTH_LONG).show();
    }
}
