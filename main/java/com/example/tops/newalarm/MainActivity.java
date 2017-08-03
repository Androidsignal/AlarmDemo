package com.example.tops.newalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    DatePicker datePicker;
    Calendar calendar;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker=(TimePicker)findViewById(R.id.timeplz);
        datePicker=(DatePicker)findViewById(R.id.datePicker);
        textView=(TextView)findViewById(R.id.textview);
        calendar=Calendar.getInstance();
        button=(Button)findViewById(R.id.setA);

        timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));
        timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
        datePicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),null);


        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Calendar setcal=Calendar.getInstance();
                setcal.set(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth(),timePicker.getCurrentHour(),timePicker.getCurrentMinute());
                if(setcal.getTimeInMillis()>calendar.getTimeInMillis()){
                    textView.setText("your alarm is="+setcal.getTime());
                    Intent intent=new Intent(MainActivity.this,Broadcast.class);
                    PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,2,intent,0);
                    AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC_WAKEUP,setcal.getTimeInMillis(),pendingIntent);
                }else {
                    Toast.makeText(MainActivity.this, "set invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
