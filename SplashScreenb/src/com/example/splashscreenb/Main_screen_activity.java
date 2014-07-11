package com.example.splashscreenb;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main_screen_activity extends Activity {
	String[] listItem = new String[20];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main_screen_activity);
		ListView mainScreenLV = (ListView) findViewById(R.id.main_screen_list_view);

		for (int i = 0; i < 20; i++)
			listItem[i] = "Item " + (i + 1);
		ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listItem);
		mainScreenLV.setAdapter(listViewAdapter);
		super.onCreate(savedInstanceState);
	}
}
