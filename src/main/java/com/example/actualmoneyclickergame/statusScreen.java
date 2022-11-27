package com.example.actualmoneyclickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class statusScreen extends AppCompatActivity {
    boolean oneDoll = false;
    boolean fiveDoll = false;
    boolean tenDoll = false;
    boolean twentyDoll = false;
    boolean fiftyDoll = false;
    boolean hundDoll = false;

    boolean oneDoll2 = false;
    boolean fiveDoll2 = false;
    boolean tenDoll2 = false;
    boolean twentyDoll2 = false;
    boolean fiftyDoll2 = false;
    boolean hundDoll2 = false;

    int totalMoney = 0;
    int amountEarned = 0;

    TextView amountCollectedID;
    TextView clickRateID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_screen);

        amountCollectedID = findViewById(R.id.amountCollectedID);
        clickRateID = findViewById(R.id.clickRateID);

        Bundle extras = getIntent().getExtras();

        if (extras.getBoolean("oneDoll") == true){
            oneDoll = true;
        }
        if (extras.getBoolean("fiveDoll") == true){
            fiveDoll = true;
        }
        if (extras.getBoolean("tenDoll") == true){
            tenDoll = true;
        }
        if (extras.getBoolean("twentyDoll") == true){
            twentyDoll = true;
        }
        if (extras.getBoolean("fiftyDoll") == true){
            fiftyDoll = true;
        }
        if (extras.getBoolean("hundDoll") == true){
            hundDoll = true;
        }


        ////////////////////////////////////////////////////


        if (extras.getBoolean("oneDoll2") == true){
            oneDoll2 = true;
        }
        if (extras.getBoolean("fiveDoll2") == true){
            fiveDoll2 = true;
        }
        if (extras.getBoolean("tenDoll2") == true){
            tenDoll2 = true;
        }
        if (extras.getBoolean("twentyDoll2") == true){
            twentyDoll2 = true;
        }
        if (extras.getBoolean("fiftyDoll2") == true){
            fiftyDoll2 = true;
        }
        if (extras.getBoolean("hundDoll2") == true){
            hundDoll2 = true;
        }

        amountEarned = extras.getInt("amountEarned");
        totalMoney = extras.getInt("totalMoney");

        double clickRate = (amountEarned/5.0);

        amountCollectedID.setText("$" + amountEarned);
        clickRateID.setText("" + clickRate + " $/sec");

    }

    public void clickBackToHome(View view){
        if ((totalMoney+amountEarned)>=8000){

            startActivity(new Intent(statusScreen.this,winActivity.class));

        }else{

            Intent intent = new Intent(statusScreen.this,GameScreen.class);

            if (oneDoll){
                intent.putExtra("oneDoll",true);
            }else{
                intent.putExtra("oneDoll",false);
            }
            if (fiveDoll){
                intent.putExtra("fiveDoll",true);
            }else{
                intent.putExtra("fiveDoll",false);
            }

            if (tenDoll){
                intent.putExtra("tenDoll",true);
            }else{
                intent.putExtra("tenDoll",false);
            }

            if (twentyDoll){
                intent.putExtra("twentyDoll",true);
            }else{
                intent.putExtra("twentyDoll",false);
            }

            if (fiftyDoll){
                intent.putExtra("fiftyDoll",true);
            }else{
                intent.putExtra("fiftyDoll",false);
            }
            if (hundDoll){
                intent.putExtra("hundDoll",true);
            }else{
                intent.putExtra("hundDoll",false);
            }

/////////////////////////////////////////////////////////

            if (oneDoll2){
                intent.putExtra("oneDoll2",true);
            }else{
                intent.putExtra("oneDoll2",false);
            }
            if (fiveDoll2){
                intent.putExtra("fiveDoll2",true);
            }else{
                intent.putExtra("fiveDoll2",false);
            }

            if (tenDoll2){
                intent.putExtra("tenDoll2",true);
            }else{
                intent.putExtra("tenDoll2",false);
            }

            if (twentyDoll2){
                intent.putExtra("twentyDoll2",true);
            }else{
                intent.putExtra("twentyDoll2",false);
            }

            if (fiftyDoll2){
                intent.putExtra("fiftyDoll2",true);
            }else{
                intent.putExtra("fiftyDoll2",false);
            }

            if (hundDoll2){
                intent.putExtra("hundDoll2",true);
            }else{
                intent.putExtra("hundDoll2",false);
            }

            intent.putExtra("amountEarned", amountEarned);
            intent.putExtra("totalMoney",totalMoney);

            startActivity(intent);
        }
    }

}