package com.example.collegehack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Days extends Activity implements OnItemClickListener {

	String days[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
			"Saturday", "Sunday" };
	private ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.days);
	    listview=(ListView)findViewById(R.id.listview);
		listview.setAdapter(new ArrayAdapter<String>(Days.this,
				android.R.layout.simple_list_item_1,days));
		listview.setOnItemClickListener(this);
	
		
	}



	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub

		String temporary = days[position];
		try {
			Class ourClass = Class.forName("com.example.collegehack."
					+ temporary);

			Intent ourIntent = new Intent(Days.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
