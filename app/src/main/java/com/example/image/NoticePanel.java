package com.example.image;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NoticePanel extends AppCompatActivity {

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_panel);

        sp=getSharedPreferences("logged",MODE_PRIVATE);

    }


    public void n1(View view) {
       // Toast.makeText(NoticePanel.this,"Notice One",Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),NoticeOne.class);
        startActivity(intent1);
    }

    public void n2(View view) {
        //Toast.makeText(NoticePanel.this,"Notice  2",Toast.LENGTH_SHORT).show();
        Intent intent2 = new Intent(getApplicationContext(),NoticeSecond.class);
        startActivity(intent2);
    }

    public void n3(View view) {
        //Toast.makeText(NoticePanel.this,"Notice  3",Toast.LENGTH_SHORT).show();
        Intent intent3 = new Intent(getApplicationContext(),NoticeThree.class);
        startActivity(intent3);
    }
    public void n4(View view) {
        //Toast.makeText(NoticePanel.this,"Notice  4",Toast.LENGTH_SHORT).show();
        Intent intent4 = new Intent(getApplicationContext(),NoticeFour.class);
        startActivity(intent4);
    }
    public void n5(View view) {

        Intent intent5 = new Intent(getApplicationContext(),NoticeFive.class);
        startActivity(intent5);
       //Toast.makeText(NoticePanel.this,"Notice  5",Toast.LENGTH_SHORT).show();
    }

    public void Logout(View view) {

        sp.edit().putBoolean("logged",false).apply();
        finish();
    }

    public void n6(View view) {

        Intent intent6 = new Intent(getApplicationContext(),NoticeSix.class);
        startActivity(intent6);
        //Toast.makeText(NoticePanel.this,"Notice  6",Toast.LENGTH_SHORT).show();
    }
}