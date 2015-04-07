package com.example.collegehack;

import java.util.Calendar;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {


	AudioManager audioControl;
	Calendar cal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initiatlize();
	}

	private void initiatlize() {
		// TODO Auto-generated method stub

		audioControl = (AudioManager) this
				.getSystemService(Context.AUDIO_SERVICE);
		cal = Calendar.getInstance();


		if (cal.get(Calendar.HOUR_OF_DAY) == 8) {
			audioControl.setRingerMode(0);
		}
		if (cal.get(Calendar.HOUR_OF_DAY) == 13) {
			audioControl.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
