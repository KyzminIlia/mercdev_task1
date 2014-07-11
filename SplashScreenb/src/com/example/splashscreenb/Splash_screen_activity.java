package com.example.splashscreenb;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash_screen_activity extends Activity {
	boolean splashIsPaused = false;
	Intent intent;
	Timer timer = new Timer();

	class turnTask extends TimerTask {

		@Override
		public void run() {
			timer.cancel();
			if (!splashIsPaused) {
				startActivity(intent);
				finish();
			}
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen_b_activity);
		intent = new Intent(this, Main_screen_activity.class);
		timer.schedule(new turnTask(), 2000);
	}

	@Override
	protected void onPause() {
		splashIsPaused = true;
		super.onPause();
	}

}
