package com.example.splashscreenb;

import java.util.Timer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class RetainedFragment extends Fragment {
	final public String LOG_TAG = "Retained fragment";
	boolean splashIsDestroy = false;
	Timer timer;

	@Override
	public void onDestroy() {
		super.onDestroy();
		splashIsDestroy = true;
		Log.d(LOG_TAG, "splash destroyed");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(LOG_TAG, "Created fragment");
		Handler h = new Handler() {
			public void handleMessage(android.os.Message msg) {
				if (!splashIsDestroy){
				startActivity(new Intent(getActivity(),
						MainScreenActivity.class));
				Log.d(LOG_TAG, "Main started");
				getActivity().finish();
				Log.d(LOG_TAG, "Splash finish");
				}	
			};
		};
		h.sendEmptyMessageDelayed(0, 2000);
		Log.d(LOG_TAG, "Handler  started");

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d(LOG_TAG, "Activity created");

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.splash_screen_retain_fragment, null);
		setRetainInstance(true);
		Log.d(LOG_TAG, "View created");
		return v;
	}

}
