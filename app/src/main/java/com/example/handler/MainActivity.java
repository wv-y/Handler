package com.example.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView) findViewById(R.id.text);
        final Handler hanler = new Handler(){
           public void handleMessage(Message msg) {
               if (msg.arg1 == 1) {
                    text.setText("改变成功！");
               }
               else
                   Toast.makeText(getBaseContext(), "失败", Toast.LENGTH_LONG).show();
           }
        };

        Button button = (Button) findViewById(R.id.but);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.arg1=1;
                        hanler.sendMessage(message);
                    }
                }).start();
            }
        });
    }
}
