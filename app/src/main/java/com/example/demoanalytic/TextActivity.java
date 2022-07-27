package com.example.demoanalytic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;


public class TextActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_main = findViewById(R.id.btn_main);

        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    /**
     private fun setClock() {
     val selectedDate = Calendar.getInstance()
     selectedDate.set(Calendar.MINUTE, 1)
     selectedDate.set(Calendar.HOUR_OF_DAY, 1)
     val pvTimeStart = TimePickerBuilder(this, OnTimeSelectListener { date, v ->
     val startTime = DateUtil.covert(date.time, DateUtil.TIME)
     if (startTime == "00:00") {
     return@OnTimeSelectListener
     }
     println("postTiming")
     //   postTiming(timming, startTime)
     }).setLayoutRes(R.layout.pickerview_mindor_time, object : CustomListener {
     override fun customLayout(v: View) {
     v.findViewById<TextView>(R.id.tvTitle).text = "倒计时关"
     v.findViewById<Button>(R.id.btnSubmit).text = "保存"
     v.findViewById<Button>(R.id.btnCancel).text = "关闭倒计时"
     v.findViewById<Button>(R.id.btnCancel).setOnClickListener {
     println("btnCancel")

     * */

    private void setClock(){
        Calendar mCalendar=  Calendar.getInstance();


        new TimePickerBuilder(this,new OnTimeSelectListener(){

            @Override
            public void onTimeSelect(Date date, View v) {

            }
        });


    }




}
