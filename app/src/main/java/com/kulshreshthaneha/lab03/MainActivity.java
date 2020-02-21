package com.kulshreshthaneha.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends AppCompatActivity {
    TextView one;
    TextView two;
    TextView three;
    TextView four;
    SeekBar seekBar;

    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;


    int a;
    int b;
    int c;
    int d;
    int s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);

        seekBar=findViewById(R.id.seekBar1);

        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();

        a=sharedPreferences.getInt("1",0);
        b=sharedPreferences.getInt("2",0);
        c=sharedPreferences.getInt("3",0);
        d=sharedPreferences.getInt("4",0);

        //a=0;
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=a+1;
                Toast.makeText(getApplicationContext(),"clicked on upper right "+a+" times",Toast.LENGTH_SHORT).show();
                editor.putInt("1",a);
                editor.apply();
            }
        });
        //b=0;
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b+1;
                Toast.makeText(getApplicationContext(),"clicked on upper left "+b+" times",Toast.LENGTH_SHORT).show();
                editor.putInt("2",b);
                editor.apply();
            }
        });
        //c=0;
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=c+1;
                Toast.makeText(getApplicationContext(),"clicked on bottom left "+c+" times",Toast.LENGTH_SHORT).show();
                editor.putInt("3",c);
                editor.apply();
            }
        });
        //d=0;
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=d+1;
                Toast.makeText(getApplicationContext(),"clicked on bottom right "+d+" times",Toast.LENGTH_SHORT).show();
                editor.putInt("4",d);
                editor.apply();
            }
        });
        //s=0;
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            //int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                s = progresValue+12;
                one.setTextSize(s);
                two.setTextSize(s);
                three.setTextSize(s);
                four.setTextSize(s);
//                progress = progresValue;
//                s1 = one.getFont()
                //Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //textView.setText("Covered: " + progress + "/" + seekBar.getMax());
                //Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
