package ca.gbc.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button urlBtn, mapBtn,alarmBtn,timerBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapBtn = findViewById(R.id.mapButton);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri address = Uri.parse("geo:1, 2");//"geo:0,0?q=CN+Tower&zoom=15"
                Intent i = new Intent(Intent.ACTION_VIEW,address);
                startActivity(i);
            }
        });
        urlBtn = findViewById(R.id.urlButton);
        urlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri address = Uri.parse("https://georgebrown.ca");
                Intent i = new Intent(Intent.ACTION_VIEW,address);
                startActivity(i);

            }
        });
        alarmBtn = findViewById(R.id.alarmButton);
        alarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_MESSAGE,"Time out")
                        .putExtra(AlarmClock.EXTRA_HOUR,12)
                        .putExtra(AlarmClock.EXTRA_MINUTES,59)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI,true);

                startActivity(i);

            }
        });
        timerBtn = findViewById(R.id.timerBtn);
        timerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlarmClock.ACTION_SET_TIMER);
                i.putExtra(AlarmClock.EXTRA_MESSAGE,"Timer On")
                        .putExtra(AlarmClock.EXTRA_LENGTH,60)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
                startActivity(i);
            }
        });

    }}