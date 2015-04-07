package com.example.collegehack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

	AudioManager audioControl;
	Bundle extras;
	int startHour, startMinute, stopHour, stopMinute,wstartHour,wstartMinute,wstopHour,wstopMinute;
	String days;
	WifiManager wifi;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		Date d = new Date();
		String day = sdf.format(d);
		Calendar c = Calendar.getInstance();
		audioControl = (AudioManager) context
				.getSystemService(Context.AUDIO_SERVICE);//vibration
		wifi = (WifiManager) context.getSystemService(context.WIFI_SERVICE);//wifi

		startHour = intent.getIntExtra("startHour", 0);
		stopHour = intent.getIntExtra("stopHour", 0);
		startMinute = intent.getIntExtra("startMinute", 0);
		stopMinute = intent.getIntExtra("stopMinute", 0);
		wstartHour = intent.getIntExtra("wstartHour", 0);
		wstartMinute = intent.getIntExtra("wstartMinute", 0);
		wstopHour = intent.getIntExtra("wstopHour",0);
		wstopMinute = intent.getIntExtra("wstopMinute", 0);
		

		int minute = c.get(Calendar.MINUTE);
		int hour = c.get(Calendar.HOUR_OF_DAY);

		// hour is current hour, minute is current minute
		if (hour >= startHour && hour <= stopHour) {
			if (hour == startHour && minute >= startMinute || hour > startHour) {
				if (startHour != stopHour) {
					audioControl
							.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
				} else if (minute >= stopMinute && hour == stopHour) {
					audioControl.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
				} else if (startHour == stopHour) {
					if (minute >= startMinute && minute < stopMinute) {
						audioControl
								.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
					} else {
						audioControl
								.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
					}

				}
			}
		}
		

		// WiFi
		if (hour >= wstartHour && hour <= wstopHour) {
			if (hour == wstartHour && minute >= wstartMinute || hour > wstartHour) {
				if (wstartHour != wstopHour) {
					wifi.setWifiEnabled(true);
				} else if (minute >= wstopMinute && hour == wstopHour) {
					wifi.setWifiEnabled(false);
				} else if (wstartHour == wstopHour) {
					if (minute > wstartMinute && minute < wstopMinute) {
						wifi.setWifiEnabled(true);
					} else {
						wifi.setWifiEnabled(false);
					}

				}
			}
		}

	}

}
