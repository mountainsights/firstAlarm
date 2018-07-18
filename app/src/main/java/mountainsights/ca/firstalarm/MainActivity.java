package mountainsights.ca.firstalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Alarm manager
    AlarmManager alarm_Manager;
    TimePicker alarm_timepicker;
    TextView status;
    Context context;
    PendingIntent pending_intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the Alarm manager
        alarm_Manager = (AlarmManager) getSystemService(ALARM_SERVICE);


        //initialize Timepicker
        alarm_timepicker = findViewById(R.id.simpleTimePicker);

        //initialize the update box
        status = (TextView) findViewById(R.id.status);

        //create an instance of a calandar
        final Calendar calendar = Calendar.getInstance();




        //Create an intent to the Alarm reciever class. Nothing shows in error log
        Intent my_Intent = new Intent(MainActivity.this, Alarm_Reciever.class);
        sendBroadcast(my_Intent);//test 51 try this.
        Log.e("Main","Main works");

       // final Intent my_intent = new Intent(this.context, Alarm_Reciever.class);


        //initialize buttons+onclicklistener
        Button alarm_on = (Button) findViewById(R.id.Start_Alarm);






        alarm_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Setting calendar instance with the hour and minutes that we picked
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker.getCurrentMinute());

                //get the int values of the hour and minutes
                int hour = alarm_timepicker.getCurrentHour();
                int minute = alarm_timepicker.getCurrentMinute();

                //convert int values to string
                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);

                if (hour > 12) {
                    hour = hour - 12; //Testing to see how this might make a difference
                }

                if (minute < 10) {

                    minute_string = "0"+ String.valueOf(minute);
                }

                //method that changes the update text box
                set_alarm_text("Alarm set to: "+hour_string+":"+minute_string );



            }

        });

        Button alarm_off = (Button) findViewById(R.id.end_alarm);
        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //method that changes the update text box
                set_alarm_text("Alarm off.");




            }
        });

    }



    private void set_alarm_text(String output) {
        status.setText(output);
    }
}
