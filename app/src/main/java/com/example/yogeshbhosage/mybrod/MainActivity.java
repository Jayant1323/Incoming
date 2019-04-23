package com.example.yogeshbhosage.mybrod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
public static String phno="";
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        FileOutputStream fin=null;

        try {
            fin = openFileOutput("hello.txt", MODE_PRIVATE);
            fin.write(phno.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void save(String date,String phno1) {
       /* FileOutputStream fin=null;
        Log.i("Yogesh2040", "save: ");
        try {
            fin = openFileOutput("hello.txt", MODE_PRIVATE);
            fin.write(phno.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
       // Toast.makeText(this,"Saved data",Toast.LENGTH_LONG).show();
        phno=phno1;
        Log.i("#####"+phno, "save: ");

    }

    public void show(View view) {
        FileOutputStream fout=null;
        try {
            fout = openFileOutput("input.txt", MODE_PRIVATE);
            fout.write(phno.getBytes());
        Toast.makeText(getApplicationContext(),phno,Toast.LENGTH_LONG).show();
        FileInputStream fin;

            fin = openFileInput("input.txt");
            InputStreamReader isr=new InputStreamReader(fin);
            BufferedReader br=new BufferedReader(isr);
            StringBuffer sb=new StringBuffer();
            String text="";
            while((text=br.readLine())!=null){
                sb.append(text).append("\n");
            }
            tv.setText(sb.toString());


        }catch (Exception e){

        }
    }
}
