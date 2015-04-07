package com.example.collegehack;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class Wednesday extends Activity implements View.OnClickListener {

	Button startTime, stopTime, wifiStart, wifiStop;
	private int wstartHour,wstopHour,wstartMinute,wstopMinute, startHour, startMinute,stopHour,stopMinute;
	EditText eStart,eStop,eWifiStart,eWifiStop;
	private PendingIntent pendingIntent;
	Intent alarmIntent;
	
	SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
	Date d = new Date();
	String day = sdf.format(d);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wednesday);
		initialize();
		alarmIntent = new Intent(Wednesday.this, AlarmReceiver.class);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Wednesday.this);
		eStart.setText(prefs.getString("key9", "default"));
		eStop.setText(prefs.getString("key10", "default"));
		eWifiStart.setText(prefs.getString("key11", "default"));
		eWifiStop.setText(prefs.getString("key12", "default"));
        
        
	}

	private void initialize() {
		// TODO Auto-generated method stub
		startTime = (Button) findViewById(R.id.startTime);
		stopTime = (Button) findViewById(R.id.stopTime);
		wifiStart = (Button) findViewById(R.id.wifiStart);
		wifiStop = (Button) findViewById(R.id.wifiStop);
		eStart = (EditText) findViewById(R.id.eStart);
		eStop = (EditText) findViewById(R.id.eStop);
		eWifiStart = (EditText) findViewById(R.id.eWifiStart);
		eWifiStop = (EditText) findViewById(R.id.eWifiStop);
		startTime.setOnClickListener(this);
		stopTime.setOnClickListener(this);
		wifiStart.setOnClickListener(this);
		wifiStop.setOnClickListener(this);
		eStart.setOnClickListener(this);
		eStop.setOnClickListener(this);
		eWifiStart.setOnClickListener(this);
		eWifiStop.setOnClickListener(this);

	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Wednesday.this);
		prefs.edit().putString("key9", eStart.getText().toString()).apply();
		prefs.edit().putString("key10", eStop.getText().toString()).apply();
		prefs.edit().putString("key11", eWifiStart.getText().toString()).apply();
		prefs.edit().putString("key12", eWifiStop.getText().toString()).apply();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		switch(v.getId()){
		case R.id.startTime :
			// Process to get Current Time
            startHour = c.get(Calendar.HOUR_OF_DAY);
            startMinute = c.get(Calendar.MINUTE);
 
            // Launch Time Picker Dialog
            TimePickerDialog tpd1 = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
 
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                int minute) {
                            // Display Selected time in textbox
                            eStart.setText(hourOfDay + ":" + minute);
                            startHour = hourOfDay;
                            startMinute = minute;
                            
                            
                            alarmIntent.putExtra("startHour", startHour);
                            if(day.equals("Wednesday")){
                            pendingIntent = PendingIntent.getBroadcast(Wednesday.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                            alarmRepeat();
                            }
                            
                            alarmIntent.putExtra("startMinute", startMinute);
                            if(day.equals("Wednesday")){
                                pendingIntent = PendingIntent.getBroadcast(Wednesday.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                                alarmRepeat();
                                }
                            
                        }
                    }, startHour, startMinute, false);
            tpd1.show();
            
            
            break;
		case R.id.stopTime :
			// Process to get Current Time
            stopHour = c.get(Calendar.HOUR_OF_DAY);
            stopMinute = c.get(Calendar.MINUTE);
			// Launch Time Picker Dialog
            TimePickerDialog tpd2 = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
 
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                int minute) {
                            // Display Selected time in textbox
                            eStop.setText(hourOfDay + ":" + minute);
                            stopHour = hourOfDay;
                            stopMinute = minute;
                           
                            alarmIntent.putExtra("stopHour", stopHour);
                            if(day.equals("Wednesday")){
                                pendingIntent = PendingIntent.getBroadcast(Wednesday.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                                alarmRepeat();
                                }
                            
                            alarmIntent.putExtra("stopMinute", stopMinute);
                            if(day.equals("Wednesday")){
                                pendingIntent = PendingIntent.getBroadcast(Wednesday.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                                alarmRepeat();
                                }
                            
                            
                        }
                    }, stopHour, stopMinute, false);
            tpd2.show();
            break;
		case R.id.wifiStart :
			// Process to get Current Time
            wstartHour = c.get(Calendar.HOUR_OF_DAY);
            wstartMinute = c.get(Calendar.MINUTE);
			// Launch Time Picker Dialog
            TimePickerDialog tpd3 = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
 
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                int minute) {
                            // Display Selected time in textbox
                            eWifiStart.setText(hourOfDay + ":" + minute);
                            wstartHour = hourOfDay;
                            wstartMinute = minute;
                            
                            alarmIntent.putExtra("wstartHour",wstartHour);
                            if(day.equals("Wednesday")){
                                pendingIntent = PendingIntent.getBroadcast(Wednesday.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                                alarmRepeat();
                                }
                            
                            alarmIntent.putExtra("wstartMinute", wstartMinute);
                            if(day.equals("Wednesday")){
                                pendingIntent = PendingIntent.getBroadcast(Wednesday.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                                alarmRepeat();
                                }
                            
                        }
                    }, wstartHour, wstartMinute, false);
            tpd3.show();
            break;
		case R.id.wifiStop :
			// Process to get Current Time
            wstopHour = c.get(Calendar.HOUR_OF_DAY);
            wstopMinute = c.get(Calendar.MINUTE);
			// Launch Time Picker Dialog
            TimePickerDialog tpd4 = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
 
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                int minute) {
                            // Display Selected time in textbox
                            eWifiStop.setText(hourOfDay + ":" + minute);
                            wstopHour = hourOfDay;
                            wstopMinute = minute;
                            
                            alarmIntent.putExtra("wstopHour", wstopHour);
                            if(day.equals("Wednesday")){
                                pendingIntent = PendingIntent.getBroadcast(Wednesday.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                                alarmRepeat();
                                }
                            
                            alarmIntent.putExtra("wstopMinute", wstopMinute);
                            if(day.equals("Wednesday")){
                                pendingIntent = PendingIntent.getBroadcast(Wednesday.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                                alarmRepeat();
                                }
                            
                        }
                    }, wstopHour, wstopMinute, false);
            tpd4.show();
            break;
		}

	}
	
	public void alarmRepeat(){
		Calendar cal = Calendar.getInstance();
		AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		manager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 1000, pendingIntent);
	}

}


