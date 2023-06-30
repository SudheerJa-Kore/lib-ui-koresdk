package com.kore.koreui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import kore.botssdk.activity.BotChatActivity;
import kore.botssdk.net.SDKConfiguration;

public class MainActivity extends AppCompatActivity {

    private Button btnBotConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBotConnect = findViewById(R.id.btnBotConnect);
        SDKConfiguration.setCustomTemplateView("link", new LinkTemplateView(MainActivity.this));
        SDKConfiguration.setCustomTemplateView("button", new BotButtonView(MainActivity.this));
        btnBotConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BotChatActivity.class);
                startActivity(intent);
            }
        });

    }
}