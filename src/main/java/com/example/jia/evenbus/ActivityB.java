package com.example.jia.evenbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

public class ActivityB extends AppCompatActivity {
    private Button btn_eventBus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        initViews();
    }

    private void initViews() {
        btn_eventBus= (Button) findViewById(R.id.btn_eventBus);
        btn_eventBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new Event("ActivityB界面的按钮已点击"));
            }
        });
    }
}
