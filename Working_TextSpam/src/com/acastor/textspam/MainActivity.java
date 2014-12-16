package com.acastor.textspam;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	SendSMS mSender = new SendSMS();
	Button btnSend;
	EditText txtPhonenumber, txtMessage, txtNumberOfSend;
	String stxtPhonenumber,stxtMessage,stxtNumberOfSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = (Button) findViewById(R.id.btnSendnow);
        
       
        
        btnSend.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				
				sendNow(v);
			}
		});
    }

    //send it now
    public void sendNow(View v) {
    	 txtPhonenumber = (EditText) findViewById(R.id.txtPhoneNumber);
         stxtPhonenumber = txtPhonenumber.getText().toString();
         
         txtMessage = (EditText) findViewById(R.id.txtMessage);
         stxtMessage = txtMessage.getText().toString();
         
         txtNumberOfSend = (EditText) findViewById(R.id.txtNumberOfText);
         stxtNumberOfSend = txtNumberOfSend.getText().toString();
    	
         //myNum = Integer.parseInt(et.getText().toString());
         int itxtNumberOfSend = Integer.parseInt(stxtNumberOfSend.toString());
         
    	if(stxtPhonenumber.matches(""))
		{
			Toast.makeText(this, "You did not enter a Phone Number", Toast.LENGTH_SHORT).show();
		    return;
		}
    	else if(stxtMessage.matches(""))
		{
			Toast.makeText(this, "You did not enter a Message", Toast.LENGTH_SHORT).show();
		    return;
		}
    	else if(stxtNumberOfSend.matches(""))
		{
			Toast.makeText(this, "You did not enter a Number Of Send", Toast.LENGTH_SHORT).show();
		    return;
		}
    	else
    	{
    		for(int x = 0; x < itxtNumberOfSend; x++ ){
    			boolean success = mSender.sendSMSMessage(stxtPhonenumber,stxtMessage);
    	    	Toast.makeText(this, "Message sent " + (
    	    		success ? "successfully "+ stxtNumberOfSend + " Times" : "unsuccessfully"), 
    	    		Toast.LENGTH_SHORT).show();
    		}
    		
    	}
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
		case R.id.action_share:
			sharePost();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
    }
    
    private void sharePost() {
		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setType("text/plain");
		shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.acastor.textspam");
		startActivity(Intent.createChooser(shareIntent, getString(R.string.share_chooser_title)));
	}
}
