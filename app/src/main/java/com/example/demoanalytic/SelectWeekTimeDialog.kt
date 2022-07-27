package com.example.demoanalytic



import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_mode_day.*


/**
 * 文件：SelectWeekDialog
 * 时间：2018/9/8.
 * 备注：选择日期弹窗
 */
class SelectWeekTimeDialog : DialogFragment() {
    private lateinit var listen: ((String, String,List<ModeIcon>) -> Unit)
    private var title = ""
    private val dates = mutableListOf<ModeIcon>()
    private lateinit var mContext: Context

    fun setListen(listen: ((String, String,List<ModeIcon>) -> Unit)): SelectWeekTimeDialog {
        this.listen = listen
        return this
    }

    fun setSourceData(list: List<ModeIcon>) {
        this.dates.addAll(list)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    companion object {
        fun newInstance(): SelectWeekTimeDialog = SelectWeekTimeDialog()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.view_mode_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListen()
        initRv()
    }

    private fun initRv() {
        rv_date_view_mode_day.layoutManager = LinearLayoutManager(context)
        val adapter = ModeWeekAdapter(dates)
        rv_date_view_mode_day.adapter = adapter
        adapter.setOnItemClickListener { item, position ->
            dates[position].isCheck = !dates[position].isCheck
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val root = RelativeLayout(activity)
        root.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
        val dialog = Dialog(mContext)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
        //dialog.window.decorView.setPadding(0, 0, 0, 0);
        return dialog
    }


    private fun initListen() {
        tv_cancel.setOnClickListener {
            dismissAllowingStateLoss()
        }

        tv_done.setOnClickListener {
            val dateString = StringBuffer()
            val dateInt = StringBuffer()
            var count = 0
            dates.forEach {
                if (it.isCheck) {
                    dateString.append(it.week)
                    dateInt.append(it.day)
                    dateString.append(" ")
                    dateInt.append(",")
                    count++
                }
            }

            if (dateString.length > 2) {
                if (count == 7) {
                    listen.invoke(
                        "每天",
                        dateInt.replace(dateInt.length - 1, dateInt.length, "").toString(),dates)
                } else {
                    listen.invoke(
                        dateString.replace(dateString.length - 1, dateString.length, "").toString(),
                        dateInt.replace(dateInt.length - 1, dateInt.length, "").toString(),dates)
                }
            } else {
                listen.invoke(Utils.getContext().getString(R.string.app_name), "0",dates)
            }
            dismissAllowingStateLoss()
        }
    }
}