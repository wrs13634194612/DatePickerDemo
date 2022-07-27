package com.example.demoanalytic


import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.CustomListener
import com.bigkoo.pickerview.listener.OnTimeSelectListener

class HelloActivity : AppCompatActivity() {
    private var dateInt = "1,2,6"
    private val dateList = mutableListOf<ModeIcon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //初始化  字符串为null  传默认的 全部为false
        dateList.add(ModeIcon(getString(R.string.monday), getString(R.string.monday), false, 1))
        dateList.add(ModeIcon(getString(R.string.tuesday), getString(R.string.tuesday), false, 2))
        dateList.add(ModeIcon(getString(R.string.wednesday), getString(R.string.wednesday), false, 3))
        dateList.add(ModeIcon(getString(R.string.thursday), getString(R.string.thursday), false, 4))
        dateList.add(ModeIcon(getString(R.string.friday), getString(R.string.friday), false, 5))
        dateList.add(ModeIcon(getString(R.string.saturday), getString(R.string.saturday), false, 6))
        dateList.add(ModeIcon(getString(R.string.sunday), getString(R.string.sunday), false, 7))


        btn_main.setOnClickListener {
            /*SelectWeekDialog.newInstance().setListen { dateString, dateInt ->
                       tv_time1_repeat.text = dateString
                       brand.week = dateInt
                       this.dateInt = dateInt
                   }.show(supportFragmentManager, "")*/
            if (this.dateInt.isNotEmpty()) {
                //做判断   如果字符串比对成功的   为true 没有比对的数据  全部为false
                for (i in dateList.indices) {
                    dateList[i].isCheck = this.dateInt.contains(dateList[i].day.toString())
                }
            }
            Log.e("TAG", "$dateList")


            val mSelectWeekTimeDialog = SelectWeekTimeDialog.newInstance()
            mSelectWeekTimeDialog.setSourceData(dateList)
            mSelectWeekTimeDialog.setListen { dateString, dateInt, dates ->
              //  tv_time1_repeat.text = dateString
             //   brand.week = dateInt
                this.dateInt = dateInt
                for (i in dates.indices) {
                    dates[i].isCheck = this.dateInt.contains(dates[i].day.toString())
                }
                Log.e("TAG", "$dates")
            }
            mSelectWeekTimeDialog.show(supportFragmentManager, "")
        }
    }


}
