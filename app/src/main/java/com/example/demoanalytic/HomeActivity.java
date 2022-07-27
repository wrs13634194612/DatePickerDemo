package com.example.demoanalytic;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import java.util.Calendar;
import java.util.Date;

/**
 * author : zhangzf
 * date   : 2020/11/28
 * desc   :
 */
public class HomeActivity extends AppCompatActivity {
    private TimePickerView pvTime;
    private boolean isOpenCountDown = false;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_main = findViewById(R.id.btn_main);
        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOpenCountDown = !isOpenCountDown;
                initTimePicker();
            }
        });
    }

    private void initTimePicker() {
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        selectedDate.set(Calendar.MINUTE, 1);
        selectedDate.set(Calendar.HOUR_OF_DAY, 1);
        //时间选择器
        pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                String data = DateUtil.covert(date.getTime(), DateUtil.TIME);
                if (data == "00:00") {
                    return;
                }
                Log.e("TAG", "时间选择器:" + data);
            }
        })
                .setLayoutRes(R.layout.pickerview_mindor_time, new CustomListener() {
                    @Override
                    public void customLayout(View v) {
                        Button btnCancel = v.findViewById(R.id.btnCancel);
                        Button btnSubmit = v.findViewById(R.id.btnSubmit);
                        TextView tvTitle = v.findViewById(R.id.tvTitle);
                        if (isOpenCountDown){
                            tvTitle.setText("开启倒计时");
                        }else{
                            tvTitle.setText("关闭倒计时");
                        }
                        btnCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvTime.dismiss();
                            }
                        });
                        btnSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvTime.returnData();
                                pvTime.dismiss();
                            }
                        });
                    }
                })
                .setType(new boolean[]{false, false, false, true, true, false}) //年月日时分秒 的显示与否，不设置则默认全部显示
                .setLabel("", "月", "日", "时", "分", "秒")//默认设置为年月日时分秒
                .isCenterLabel(false)
                .setTitleColor(Color.parseColor("#333333"))//标题文字颜色
                .setSubmitColor(Color.parseColor("#FF3B30"))//确定按钮文字颜色
                .setCancelColor(Color.parseColor("#777777"))//取消按钮文字颜色
                .setTitleBgColor(Color.parseColor("#ffffff"))//标题背景颜色 Night mode
                .setTextColorCenter(Color.parseColor("#0091FF"))
                .setSubCalSize(24)
                .setContentTextSize(32)//滚轮文字大小
                .setTitleSize(24)//标题文字大小
                .setSubmitText("确定")
                .setCancelText("取消")
                .setDate(selectedDate)
                .isCyclic(false)//是否循环滚动
                .setLineSpacingMultiplier(1.5f)
                .setTextXOffset(0, 0, 0, 0, 0, 0)//设置X轴倾斜角度[ -90 , 90°]
                .setDecorView(null)
                .build();
        pvTime.show();
    }


}