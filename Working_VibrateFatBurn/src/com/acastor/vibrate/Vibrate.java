package com.acastor.vibrate;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;

public class Vibrate extends Activity {
	
	// The vibration times in mSec are pairs of silent time and vibrate time.
	private static final long[] THREE_CYCLES = new long[] { 100, 1000};
	Boolean isTrue = true;
	Vibrator vibrator;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
         vibrator = (Vibrator) getApplication().getSystemService(Service.VIBRATOR_SERVICE);  
    }
    
    public void shortVibrate(View v) {
    	vibrate();
    }

    
    private void vibrate() {
    	
    	if(isTrue == true){
        	isTrue = false;
        	vibrator.vibrate(THREE_CYCLES,0);
    	}
    	else
    	{
        	isTrue = true;
    		vibrator.cancel();
    	}
    	
	}

	
}