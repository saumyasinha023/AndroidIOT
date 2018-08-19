package com.example.saumya.ovendemo;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class Circular extends AppCompatActivity {
    int i;
    TextView tv1;
    public int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular);
        tv1= (TextView)findViewById(R.id.timerView);
        LinearTimerView linearTimerView = (LinearTimerView)
                findViewById(R.id.linearTimer);
        i=119;



        new CountDownTimer(i*1000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                tv1.setText(""+String.format("%d:%d ",
                        TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                tv1.setText("done!");
            }
        }.start();

        LinearTimer linearTimer = new LinearTimer.Builder().linearTimerView(linearTimerView).duration(i * 1000).build();
        linearTimer.startTimer();

    }

}
