package com.example.activityanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView bigIcon;
    ImageView smallIcon;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bigIcon = findViewById(R.id.bigIcon);
        smallIcon = findViewById(R.id.smallIcon);
        button = findViewById(R.id.button);
        Animation animRotateIn_icon = AnimationUtils.loadAnimation(this, R.anim.rotate);
        bigIcon.startAnimation(animRotateIn_icon);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
                overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha);
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        Animation animRotateIn_big = AnimationUtils.loadAnimation(this, R.anim.rotate);
        bigIcon.startAnimation(animRotateIn_big);
    }
}
