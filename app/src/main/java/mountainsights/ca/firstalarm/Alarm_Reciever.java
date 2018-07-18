package mountainsights.ca.firstalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;



public class Alarm_Reciever extends BroadcastReceiver {

//try now
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "FuckJava.exe", Toast.LENGTH_LONG).show();
    }
}