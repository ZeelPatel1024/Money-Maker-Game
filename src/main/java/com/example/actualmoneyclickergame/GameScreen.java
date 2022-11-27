package com.example.actualmoneyclickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class GameScreen extends AppCompatActivity {

    ArrayList<Integer> goalAmounts = new ArrayList<>();
    String level = "easy";
    TextView amountGoal;
    TextView amountEarned;
    TextView txtTotalMoney;
    TextView levelTypeText;
    int highestValueUnlocked = 1;

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

    int amountColl = 0;
    int totalMoney = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        amountGoal = findViewById(R.id.amountGoal);
        amountEarned = findViewById(R.id.amountEarned);
        txtTotalMoney = findViewById(R.id.txtTotalMoney);
        levelTypeText = findViewById(R.id.levelTypeText);

        goalAmounts.add(10);//1 dollar level- easy - 5
        goalAmounts.add(100);//5 dollar level- easy - 6
        goalAmounts.add(1000);//10 dollar level- medium - 7
        goalAmounts.add(2000);//20 dollar level- medium - 8
        goalAmounts.add(5000);//50 dollar level- hard - 9
        goalAmounts.add(8000);//100 dollar level- hard - 10



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

//////////////////////////////
        if (extras.getBoolean("oneDoll2") == true){
            oneDoll2 = true;
            highestValueUnlocked = 1;
        }
        if (extras.getBoolean("fiveDoll2") == true){
            fiveDoll2 = true;
            highestValueUnlocked = 5;
        }
        if (extras.getBoolean("tenDoll2") == true){
            tenDoll2 = true;
            highestValueUnlocked = 10;
            level = "medium";
        }
        if (extras.getBoolean("twentyDoll2") == true){
            twentyDoll2 = true;
            highestValueUnlocked = 20;
            level = "medium";
        }

        if (extras.getBoolean("fiftyDoll2") == true){
            fiftyDoll2 = true;
            highestValueUnlocked = 50;
            level = "hard";
        }
        if (extras.getBoolean("hundDoll2") == true){
            hundDoll2 = true;
            highestValueUnlocked = 100;
            level = "hard";
        }

        if (level.equals("easy") && highestValueUnlocked == 1){
            amountGoal.setText("$" + goalAmounts.get(0));
        }
        if (level.equals("easy") && highestValueUnlocked == 5){
            amountGoal.setText("$" + goalAmounts.get(1));
        }
        if (level.equals("medium") && highestValueUnlocked == 10){
            amountGoal.setText("$" + goalAmounts.get(2));
            levelTypeText.setText("medium");
        }
        if (level.equals("medium") && highestValueUnlocked == 20){
            amountGoal.setText("$" + goalAmounts.get(3));
            levelTypeText.setText("medium");
        }
        if (level.equals("hard") && highestValueUnlocked == 50){
            amountGoal.setText("$" + goalAmounts.get(4));
            levelTypeText.setText("hard");
        }
        if (level.equals("hard") && highestValueUnlocked == 100){
            amountGoal.setText("$" + goalAmounts.get(5));
            levelTypeText.setText("hard");
        }
//

        amountColl = extras.getInt("amountEarned");
        totalMoney += extras.getInt("totalMoney");
        totalMoney+= amountColl;
        txtTotalMoney.setText("$" + totalMoney);
        amountEarned.setText("$" + amountColl);

    }

    public void clickedOnShop(View view){
        Intent intent = new Intent(GameScreen.this,ShopPage.class);

//////////////////////////////////unlocked
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


        intent.putExtra("totalMoney",totalMoney);
        startActivity(intent);

    }

    public void clickedOnStartLevel(View view){
        startActivity(new Intent(GameScreen.this,MainGamePlayScreen.class));
    }

}