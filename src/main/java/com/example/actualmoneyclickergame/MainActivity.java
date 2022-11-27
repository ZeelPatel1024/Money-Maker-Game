package com.example.actualmoneyclickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playClicked(View view){
        Intent intent = new Intent(MainActivity.this,GameScreen.class);
        intent.putExtra("oneDoll",true);
        intent.putExtra("fiveDoll",false);
        intent.putExtra("tenDoll",false);
        intent.putExtra("twentyDoll",false);
        intent.putExtra("fiftyDoll",false);
        intent.putExtra("hundDoll",false);

        intent.putExtra("oneDoll2",true);
        intent.putExtra("fiveDoll2",false);
        intent.putExtra("tenDoll2",false);
        intent.putExtra("twentyDoll2",false);
        intent.putExtra("fiftyDoll2",false);
        intent.putExtra("hundDoll2",false);

        intent.putExtra("amountEarned",0);
        intent.putExtra("totalMoney",0);


        startActivity(intent);
    }

}