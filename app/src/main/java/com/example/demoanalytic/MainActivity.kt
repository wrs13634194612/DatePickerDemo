package com.example.demoanalytic

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.CustomListener
import com.bigkoo.pickerview.listener.OnTimeSelectListener

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_main.setOnClickListener {
            setClock()
        }



    }






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
                }
                v.findViewById<Button>(R.id.btnSubmit).setOnClickListener {
                    println("btnSubmit")
                }
            }

        })
            .setType(booleanArrayOf(false, false, false, true, true, false))// 默认全部显示
            .setCancelText(getString(R.string.app_name))//取消按钮文字
            .setSubmitText(getString(R.string.app_name))//确认按钮文字
            .setSubCalSize(24)
            .setContentTextSize(32)//滚轮文字大小
            .setTitleSize(24)//标题文字大小
            .setTitleText(getString(R.string.app_name))//标题文字
            .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
            .isCyclic(false)//是否循环滚动
            .setTitleColor(Color.parseColor("#333333"))//标题文字颜色
            .setSubmitColor(Color.parseColor("#FF3B30"))//确定按钮文字颜色
            .setCancelColor(Color.parseColor("#777777"))//取消按钮文字颜色
            .setTitleBgColor(Color.parseColor("#ffffff"))//标题背景颜色 Night mode
            .setTextColorCenter(Color.parseColor("#0091FF"))
            .setBgColor(Color.WHITE)//滚轮背景颜色 Night mode
            .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
            .setLineSpacingMultiplier(1.5f)
            .setDividerColor(Color.TRANSPARENT)
            .setLabel("", "月", "日", "时", "分", "秒")//默认设置为年月日时分秒
            .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
            .isDialog(false)//是否显示为对话框样式
            .setOutSideCancelable(true)
            .build()
        pvTimeStart?.show()
    }


}
