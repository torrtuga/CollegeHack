package com.example.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class msgreceiver extends BroadcastReceiver{

		 public void onReceive(Context context, Intent intent) {
		        
	            // Retrieves a map of extended data from the intent.
	            final Bundle bundle = intent.getExtras();
	    
	            try {
	                
	                if (bundle != null) {
	                    
	                    final Object[] pdusObj = (Object[]) bundle.get("pdus");
	                    
	                    for (int i = 0; i < pdusObj.length; i++) {
	                        
	                        SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
	                        
	                        String message = currentMessage.getDisplayMessageBody();
	    
	                        if(message.contains("ENIGMA"))
	                        {
	                        	MediaPlayer player = new MediaPlayer();
	                        	
	                        	AssetFileDescriptor descriptor = context.getAssets().openFd("ring.mp3");
	                            player.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
	                        	player.prepare();
	                        	player.start();
	                        }
	    
	                      
	                        
	                    } // end for loop
	                  } // bundle is null
	    
	            } catch (Exception e) {
	                Log.e("SmsReceiver", "Exception smsReceiver" +e);
	                
	            }
	        }    
	}
	


