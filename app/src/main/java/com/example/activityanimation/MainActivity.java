package com.example.activityanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    ImageView bigIcon;
    ImageView smallIcon;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bigIcon = findViewById(R.id.bigIcon);
        button = findViewById(R.id.button);
        linearLayout = findViewById(R.id.screen2);
        final Animation animRotateIn_icon = AnimationUtils.loadAnimation(this, R.anim.rotate);
        bigIcon.startAnimation(animRotateIn_icon);
        linearLayout.setOnTouchListener(new OnSwipeTouchListener(this){
            @Override
            public void onSwipeUp() {
                Intent i = new Intent (MainActivity.this, Main2Activity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_up_in, R.anim.slide_up_out);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigIcon.startAnimation(animRotateIn_icon);
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
