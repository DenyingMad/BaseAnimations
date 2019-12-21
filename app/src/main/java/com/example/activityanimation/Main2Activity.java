package com.example.activityanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {
    private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        constraintLayout = findViewById(R.id.constaint);
        constraintLayout.setOnTouchListener(new OnSwipeTouchListener(this){
            @Override
            public void onSwipeDown() {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_down_in, R.anim.slide_down_out);
            }
        });
    }
}
