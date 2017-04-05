package com.example.jia.evenbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {
    private Button btn_go;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);  //注册EventBus
        initViews();
    }

    private void initViews() {
        tv= (TextView) findViewById(R.id.tv);
        btn_go= (Button) findViewById(R.id.btn_go );
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ActivityB.class);
                startActivity(intent);
            }
        });
    }
    @Subscribe//EventBus3.0版本之后，用注解的形式，无关方法名，就是说无论方法名是什么，只要使用了@Subscribe注解，都可以收到消息。
   public void onEventMainThread(Event event){
       String msg="从ActivityB那接收到了:"+event.getMsg();
       tv.setText(msg);
       Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
   }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//反注册EventBus
    }
}
