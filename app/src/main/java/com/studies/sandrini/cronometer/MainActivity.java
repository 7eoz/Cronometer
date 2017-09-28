package com.studies.sandrini.cronometer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    Button start, stop;
    TextView counter;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        counter = (TextView) findViewById(R.id.counter);

        start.setEnabled(true);
        stop.setEnabled(false);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.postDelayed(timedTask,1000);
                //handler.post(timedTask);
                start.setEnabled(false);
                stop.setEnabled(true);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(timedTask);
                start.setEnabled(true);
                stop.setEnabled(false);
                count = 0;
            }
        });


    }

    private Runnable timedTask = new Runnable() {
        @Override
        public void run() {
            count++;
            counter.setText(String.valueOf(count));
            handler.postDelayed(timedTask, 1000);
        }
    };
}
