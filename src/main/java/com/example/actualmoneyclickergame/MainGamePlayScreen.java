package com.example.actualmoneyclickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainGamePlayScreen extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 6000;

//    ImageView billNumberOne;
    int clickCycle = 1;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    TextView timerNum;
    TextView amountCollectedNum;
    int moneyCol = 0;
    ImageView billNumberOne;
    ImageView billNumberTwo;
    ImageView billNumberThree;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game_play_screen);

        billNumberOne = findViewById(R.id.billNumberOne);
        billNumberTwo = findViewById(R.id.billNumberTwo);
        billNumberThree = findViewById(R.id.billNumberThree);

        timerNum = findViewById(R.id.timerNum);
        amountCollectedNum = findViewById(R.id.amountCollectedNum);

        if (!mTimerRunning){
            startTimer();
        }

        Bundle extras = getIntent().getExtras();
        totalMoney = extras.getInt("totalMoney");

        if (extras.getBoolean("oneDoll") == true){

            billNumberOne.setImageResource(R.drawable.onedollarbill);
            billNumberOne.setVisibility(View.VISIBLE);
            oneDoll = true;
        }else{
            billNumberOne.setVisibility(View.INVISIBLE);
        }
        if (extras.getBoolean("fiveDoll") == true){
            billNumberTwo.setImageResource(R.drawable.fivedollarbill);
            billNumberTwo.setVisibility(View.VISIBLE);
            fiveDoll = true;
        }else{
            billNumberTwo.setVisibility(View.INVISIBLE);
        }
        if (extras.getBoolean("tenDoll") == true){
            billNumberThree.setImageResource(R.drawable.tendollarbill);
            billNumberThree.setVisibility(View.VISIBLE);
            tenDoll = true;
        }else{
            billNumberThree.setVisibility(View.INVISIBLE);
        }

        if (extras.getBoolean("twentyDoll") == true){
            billNumberOne.setImageResource(R.drawable.twentydollarbill);
            billNumberOne.setVisibility(View.VISIBLE);
            twentyDoll = true;
        }else{
//            billNumberOne.setVisibility(View.INVISIBLE);
            System.out.println("else statement fufilled");
        }

        if (extras.getBoolean("fiftyDoll") == true){
            billNumberTwo.setImageResource(R.drawable.fiftydollarbill);
            billNumberTwo.setVisibility(View.VISIBLE);
            fiftyDoll = true;
        }else{
//            billNumberOne.setVisibility(View.INVISIBLE);
            System.out.println("else2 statement fufilled");
        }

        if (extras.getBoolean("hundDoll") == true){
            billNumberThree.setImageResource(R.drawable.hundreddollarbill);
            billNumberThree.setVisibility(View.VISIBLE);
            hundDoll = true;
        }else{
//            billNumberOne.setVisibility(View.INVISIBLE);
            System.out.println("else2 statement fufilled");
        }


        if (extras.getBoolean("oneDoll2") == true){
            oneDoll2 = true;
        }else{
            oneDoll2 = false;
        }
        if (extras.getBoolean("fiveDoll2") == true){
            fiveDoll2 = true;
        }else{
            fiveDoll2 = false;
        }
        if (extras.getBoolean("tenDoll2") == true){
            tenDoll2 = true;
        }else{
            tenDoll2 = false;
        }
        if (extras.getBoolean("twentyDoll2") == true){
            twentyDoll2 = true;
        }else{
            twentyDoll2 = false;
        }
        if (extras.getBoolean("fiftyDoll2") == true){
            fiftyDoll2 = true;
        }else{
            fiftyDoll2 = false;
        }
        if (extras.getBoolean("hundDoll2") == true){
            hundDoll2 = true;
        }else{
            hundDoll2 = false;
        }
    }

    public void clickedOnImageOne(View view){

        if (billNumberOne.getVisibility() == View.VISIBLE){
            if (clickCycle == 1){
                billNumberOne.animate().rotationBy(5f);
                clickCycle++;
            }else{
                billNumberOne.animate().rotationBy(-5f);
                clickCycle = 1;
            }

            if (oneDoll){
                moneyCol++;
                amountCollectedNum.setText("$" + moneyCol);
            }

            if (twentyDoll){
                moneyCol+= 20;
                amountCollectedNum.setText("$" + moneyCol);
            }

        }

    }

    public void clickedOnImageTwo(View view){

        if (billNumberTwo.getVisibility() == View.VISIBLE){
            if (clickCycle == 1){
                billNumberTwo.animate().rotationBy(5f);
                clickCycle++;
            }else{
                billNumberTwo.animate().rotationBy(-5f);
                clickCycle = 1;
            }

            if (fiveDoll){
                moneyCol+=5;
                amountCollectedNum.setText("$" + moneyCol);
            }

            if (fiftyDoll){
                moneyCol+=50;
                amountCollectedNum.setText("$" + moneyCol);
            }

        }

    }

    public void clickedOnImageThree(View view){

        if (billNumberThree.getVisibility() == View.VISIBLE){
            if (clickCycle == 1){
                billNumberThree.animate().rotationBy(5f);
                clickCycle++;
            }else{
                billNumberThree.animate().rotationBy(-5f);
                clickCycle = 1;
            }

            if (tenDoll){
                moneyCol+=10;
                amountCollectedNum.setText("$" + moneyCol);
            }
            if (hundDoll){
                moneyCol+=100;
                amountCollectedNum.setText("$" + moneyCol);
            }

        }

    }

    private void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                Intent intent = new Intent(MainGamePlayScreen.this,statusScreen.class);
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

                intent.putExtra("amountEarned", moneyCol);
                intent.putExtra("totalMoney",totalMoney);

                startActivity(intent);
            }
        }.start();

        mTimerRunning = true;
    }

    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis/1000) / 60;
        int seconds = (int) (mTimeLeftInMillis/1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);

        timerNum.setText(timeLeftFormatted + "");
    }



}
