package com.example.yogeshbhosage.mybrod;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Broadcast extends BroadcastReceiver {
    String date,phno="";
    Context c;
    class MyPhoneStaetListener extends PhoneStateListener{

        @Override
        public void onCallStateChanged(int state, String phoneNumber) {

            if(state==1){
                SimpleDateFormat sdt=new SimpleDateFormat();
                Calendar c=Calendar.getInstance();
                date=sdt.format(c.getTime());
                MainActivity.phno=phoneNumber;
                //Toast.makeText(context,phno,Toast.LENGTH_LONG).show();

                //Toast.makeText(MainActivity.class,"saving",Toast.LENGTH_LONG).show();

            }
        }
    }
    @Override
    public void onReceive(Context context, Intent intent) {

        try{
            TelephonyManager tmgr=(TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            MyPhoneStaetListener myphoneStateListner=new MyPhoneStaetListener();
            tmgr.listen(myphoneStateListner,PhoneStateListener.LISTEN_CALL_STATE);

        }catch (Exception e){
            Toast.makeText(context,"Error",Toast.LENGTH_LONG).show();

        }

        c=context;
       // Toast.makeText(context,"Saving",Toast.LENGTH_LONG).show();
this.abortBroadcast();
    }

}
