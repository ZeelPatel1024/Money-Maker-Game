package com.example.actualmoneyclickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShopPage extends AppCompatActivity {

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

    Button oneDollar;
    Button fiveDollar;
    Button tenDollar;
    Button twentyDollar;
    Button fiftyDollar;
    Button hundDollar;

    int totalMoney = 0;
    TextView amountColl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_page);

        oneDollar = findViewById(R.id.oneDollar);
        fiveDollar = findViewById(R.id.fiveDollar);
        tenDollar = findViewById(R.id.tenDollar);
        twentyDollar = findViewById(R.id.twentyDollar);
        fiftyDollar = findViewById(R.id.fiftyDollar);
        hundDollar = findViewById(R.id.hundDollar);
        amountColl = findViewById(R.id.amountColl);

        Bundle extras = getIntent().getExtras();
        totalMoney = extras.getInt("totalMoney");
        amountColl.setText("$" + totalMoney);

        if (extras.getBoolean("oneDoll2")){
            oneDoll2 = true;
        }
        if (extras.getBoolean("fiveDoll2")){
            fiveDoll2 = true;
        }
        if (extras.getBoolean("tenDoll2")){
            tenDoll2 = true;
        }
        if (extras.getBoolean("twentyDoll2")){
            twentyDoll2 = true;
        }
        if (extras.getBoolean("fiftyDoll2")){
            fiftyDoll2 = true;
        }
        if (extras.getBoolean("hundDoll2")){
            hundDoll2 = true;
        }

        if (oneDoll2 || totalMoney < 10){
            oneDollar.setEnabled(true);
        }
        if (fiveDoll2 || totalMoney > 10){
            fiveDollar.setEnabled(true);
        }
        if (totalMoney > 100 || ( tenDoll2 && fiveDoll2)){
            tenDollar.setEnabled(true);
        }
        if (totalMoney > 1000 || (tenDoll2 && fiveDoll2 && twentyDoll2)){
            twentyDollar.setEnabled(true);
        }
        if (totalMoney > 2000 || (tenDoll2 && fiveDoll2 && twentyDoll2 && fiftyDoll2)){
            fiftyDollar.setEnabled(true);
        }
        if (totalMoney > 5000 || (tenDoll2 && hundDoll2 && fiveDoll2 && twentyDoll2 && fiftyDoll2)){
            hundDollar.setEnabled(true);
        }


    }

    public void clickedOnShop(View view){
        Intent intent = new Intent(ShopPage.this,MainGamePlayScreen.class);
        if (oneDoll){
            intent.putExtra("oneDoll",true);
        }else{
            intent.putExtra("oneDoll",false);
        }

        if (oneDoll2){
            intent.putExtra("oneDoll2",true);
        }else{
            intent.putExtra("oneDoll2",false);
        }

        if (fiveDoll){
            intent.putExtra("fiveDoll",true);
        }else{
            intent.putExtra("fiveDoll",false);
        }

        if (fiveDoll2){
            intent.putExtra("fiveDoll2",true);
        }else{
            intent.putExtra("fiveDoll2",false);
        }

        if (tenDoll){
            intent.putExtra("tenDoll",true);
        }else{
            intent.putExtra("tenDoll",false);
        }

        if (tenDoll2){
            intent.putExtra("tenDoll2",true);
        }else{
            intent.putExtra("tenDoll2",false);
        }

        if (twentyDoll){
            intent.putExtra("twentyDoll",true);
        }else{
            intent.putExtra("twentyDoll",false);
        }

        if (twentyDoll2){
            intent.putExtra("twentyDoll2",true);
        }else{
            intent.putExtra("twentyDoll2",false);
        }

        if (fiftyDoll){
            intent.putExtra("fiftyDoll",true);
        }else{
            intent.putExtra("fiftyDoll",false);
        }

        if (fiftyDoll2){
            intent.putExtra("fiftyDoll2",true);
        }else{
            intent.putExtra("fiftyDoll2",false);
        }

        if (hundDoll){
            intent.putExtra("hundDoll",true);
        }else{
            intent.putExtra("hundDoll",false);
        }

        if (hundDoll2){
            intent.putExtra("hundDoll2",true);
        }else{
            intent.putExtra("hundDoll2",false);
        }


        intent.putExtra("totalMoney",totalMoney);
        startActivity(intent);
    }

    public void useOneDollar(View view){
        oneDollar.setEnabled(true);
        oneDoll = true;
        oneDoll2 = true;
    }
    public void useFiveDollar(View view){
        if (totalMoney >= 10 && !fiveDoll2 && oneDoll2){
            fiveDollar.setEnabled(true);
            //use in this round
            fiveDoll = true;
            //unlocked
            fiveDoll2 = true;
            totalMoney -= 10;
            amountColl.setText("$" + totalMoney);
        }else if (fiveDoll2){
            fiveDollar.setEnabled(true);
            fiveDoll = true;
            fiveDoll2 = true;
            amountColl.setText("$" + totalMoney);
        }
    }
    public void useTenDollar(View view){
        if (totalMoney >= 100 && !tenDoll2 && fiveDoll2){
            tenDollar.setEnabled(true);
            tenDoll = true;
            tenDoll2 = true;
            totalMoney -= 100;
            amountColl.setText("$" + totalMoney);
        }else if (tenDoll2){
            tenDollar.setEnabled(true);
            tenDoll = true;
            tenDoll2 = true;
            amountColl.setText("$" + totalMoney);
        }
    }
    public void useTwentyDollar(View view){
        if (totalMoney >= 1000 && !twentyDoll2 && fiveDoll2 && oneDoll2){
            twentyDollar.setEnabled(true);
            twentyDoll = true;
            twentyDoll2 = true;
            totalMoney -= 1000;
            amountColl.setText("$" + totalMoney);
        }else if (twentyDoll2){
            twentyDollar.setEnabled(true);
            twentyDoll = true;
            twentyDoll2 = true;
            amountColl.setText("$" + totalMoney);
        }
    }
    public void useFiftyDollar(View view){
        if (totalMoney >= 2000 && !fiftyDoll2 && twentyDoll2 && fiveDoll2 && oneDoll2){
            fiftyDollar.setEnabled(true);
            fiftyDoll = true;
            fiftyDoll2 = true;
            totalMoney -= 2000;
            amountColl.setText("$" + totalMoney);
        }else if (fiftyDoll2){
            fiftyDollar.setEnabled(true);
            fiftyDoll = true;
            fiftyDoll2 = true;
            amountColl.setText("$" + totalMoney);
        }
    }
    public void useHundredDollar(View view){
        if (totalMoney >= 5000 && !hundDoll2 && fiftyDoll2 && twentyDoll2 && fiveDoll2 && oneDoll2){
            hundDollar.setEnabled(true);
            hundDoll = true;
            hundDoll2 = true;
            totalMoney -= 2000;
            amountColl.setText("$" + totalMoney);
        }else if (hundDoll2){
            hundDollar.setEnabled(true);
            hundDoll = true;
            hundDoll2 = true;
            amountColl.setText("$" + totalMoney);
        }
    }

}