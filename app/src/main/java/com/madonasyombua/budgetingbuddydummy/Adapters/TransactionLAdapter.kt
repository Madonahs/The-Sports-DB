package com.madonasyombua.budgetingbuddydummy.Adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView


import com.madonasyombua.budgetingbuddydummy.R

import java.util.ArrayList

class TransactionListAdapter internal
constructor(private val activity: Activity,
            private val dataArrayList: ArrayList<ExpenseData>) :
        RecyclerView.Adapter<TransactionListAdapter.CustomViewHolderList>() {

    inner class CustomViewHolderList @SuppressLint("CutPasteId")
    constructor(view: View) : RecyclerView.ViewHolder(view) {
        private val expenseImage: ImageView
        private val expenseName: TextView
        private val expenseAmount: TextView
        private val expenseLocation: TextView
        private val ll: LinearLayout


        init {

            view.setOnClickListener(ExpenseItemOnClickListener(activity))
            this.expenseImage = view.findViewById(R.id.trans_expense_image)
            this.expenseName = view.findViewById(R.id.trans_expense_name)
            this.expenseAmount = view.findViewById(R.id.trans_expense_amount)
            this.expenseLocation = view.findViewById(R.id.trans_expense_location)
            // this.spinner = view.findViewById(R.id.currency_spinner_one);
            this.ll = view.findViewById(R.id.expenseLocation)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TransactionListAdapter.CustomViewHolderList {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.trans_list, viewGroup, false)
        return TransactionListAdapter.CustomViewHolderList(view)
    }

    override fun onBindViewHolder(holder: TransactionListAdapter.CustomViewHolderList, position: Int) {


        holder.expenseImage.setImageResource(ImageAndColorUtil.getWhiteImageContentId(dataArrayList[position].getExpenseName()))

        val background = holder.expenseImage.background

        if (background is ShapeDrawable) {
            background.paint.color = ContextCompat.getColor(activity, ImageAndColorUtil.getColorContentId(dataArrayList[position].getExpenseName()))
        } else if (background is GradientDrawable) {
            background.setColor(ContextCompat.getColor(activity, ImageAndColorUtil.getColorContentId(dataArrayList[position].getExpenseName())))
        } else if (background is ColorDrawable) {
            background.color = ContextCompat.getColor(activity, ImageAndColorUtil.getColorContentId(dataArrayList[position].getExpenseName()))
        }
        if (dataArrayList[position].getLatitude() !== 0 && dataArrayList[position].getLongitude() !== 0) {
            holder.ll.visibility = View.VISIBLE
            val addresses = GeoAddressUtil.getAddress(dataArrayList[position].getLatitude(), dataArrayList[position].getLongitude(), activity)
            if (addresses != null && addresses!!.size > 0) {
                val obj = addresses!!.get(0)
                holder.expenseLocation.setText(obj.getAddressLine(0))
            }
        } else {
            holder.ll.visibility = View.GONE
        }
        holder.expenseName.setText(dataArrayList[position].getExpenseName())
        holder.expenseName.tag = dataArrayList[position].getId()
        if (dataArrayList[position].getExpenseType().equals("Expense")) {
            holder.expenseAmount.text = "- $ " + java.lang.Double.valueOf(dataArrayList[position].getExpenseAmount()).toString()
            holder.expenseAmount.setTextColor(ContextCompat.getColor(activity, R.color.red_500))
        } else {
            holder.expenseAmount.text = "$ " + java.lang.Double.valueOf(dataArrayList[position].getExpenseAmount()).toString()
            holder.expenseAmount.setTextColor(ContextCompat.getColor(activity, R.color.green_500))
        }
    }

    override fun getItemCount(): Int {
        return dataArrayList.size
    }


}

