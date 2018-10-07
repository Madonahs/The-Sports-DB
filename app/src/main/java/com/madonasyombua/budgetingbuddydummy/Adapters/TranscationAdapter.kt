package com.madonasyombua.budgetingbuddydummy.Adapters

import android.app.Activity
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.madonasyombua.budgetingbuddydummy.Data.ExpenseData


import com.madonasyombua.budgetingbuddydummy.R

import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date
import java.util.Locale

class TransactionAdapter(private val activity: Activity,
                         private val arrayListArrayList: ArrayList<ArrayList<ExpenseData>>,
                         private val walletBalance: Double,
                         private val totalExpenseAmount: Double) : RecyclerView.Adapter<TransactionAdapter.GeneralViewHolder>() {


    open inner class GeneralViewHolder(view: View) : RecyclerView.ViewHolder(view)


    private inner class CustomViewHolder internal constructor(view: View) : GeneralViewHolder(view) {
        val transListView: RecyclerView
        private val totalExpenseDateView: TextView
        private val totalExpenseAmountView: TextView


        init {

            this.transListView = view.findViewById(R.id.recyclerviewList)
            this.totalExpenseDateView = view.findViewById(R.id.totalExpenseDate)
            this.totalExpenseAmountView = view.findViewById(R.id.totalExpenseAmount)

        }

        internal fun setTotalExpenseDate(date: String) {
            totalExpenseDateView.text = date
        }

        internal fun setTotalExpenseAmount(amount: String) {
            totalExpenseAmountView.text = amount
        }


    }


    private inner class MonthSummaryCard internal constructor(view: View) : GeneralViewHolder(view) {

        private val walletAmountView: TextView
        private val totalExpensesPerMonth: TextView

        init {
            this.walletAmountView = view.findViewById(R.id.walletAmount)
            this.walletAmountView.setTextColor(ContextCompat.getColor(activity, R.color.green_500))
            this.totalExpensesPerMonth = view.findViewById(R.id.totalExpensesPerMonth)
            this.totalExpensesPerMonth.setTextColor(ContextCompat.getColor(activity, R.color.red_500))
        }

        internal fun setWalletAmountView(date: String) {
            walletAmountView.text = date
        }

        internal fun setTotalExpensesPerMonth(amount: String) {
            totalExpensesPerMonth.text = amount
        }
    }


    override fun getItemViewType(position: Int): Int {
        return if (position == 0) -1 else position
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GeneralViewHolder {


        val holder: GeneralViewHolder
        val view: View
        if (viewType == -1) {
            view = LayoutInflater.from(activity)
                    .inflate(R.layout.month_summary_card, viewGroup, false)
            holder = MonthSummaryCard(view)
        } else {
            view = LayoutInflater.from(activity)
                    .inflate(R.layout.transactions_list, viewGroup, false)
            holder = CustomViewHolder(view)
        }
        return holder

    }

    override fun onBindViewHolder(holder: GeneralViewHolder, position: Int) {
        if (getItemViewType(position) == -1) {
            val holder1 = holder as MonthSummaryCard
            holder1.setWalletAmountView("$ " + java.lang.Double.valueOf(walletBalance)!!.toString())
            holder1.setTotalExpensesPerMonth("$ " + java.lang.Double.valueOf(totalExpenseAmount)!!.toString())
        } else {
            val holder1 = holder as CustomViewHolder
            var totalExpense = 0.0
            var totalIncome = 0.0
            holder1.transListView.layoutManager = LinearLayoutManager(activity)
            val itemsAdapter = TransactionListAdapter(activity, arrayListArrayList[position])
            holder1.transListView.adapter = itemsAdapter
            if (arrayListArrayList[position][0].getExpenseDate().equals(SimpleDateFormat("MMM dd, yyyy", Locale.US).format(Date())))
                holder1.setTotalExpenseDate("Today")
            else
                holder1.setTotalExpenseDate(arrayListArrayList[position][0].getExpenseDate())

            for (expenseData in arrayListArrayList[position]) {
                if (expenseData.getExpenseType().equals("Expense"))
                    totalExpense += expenseData.getExpenseAmount()
                else
                    totalIncome += expenseData.getExpenseAmount()
            }
            val amount = totalIncome - totalExpense
            if (amount < 0)
                holder1.setTotalExpenseAmount("-$ " + java.lang.Double.valueOf(amount * -1)!!.toString())
            else
                holder1.setTotalExpenseAmount("$ " + java.lang.Double.valueOf(amount)!!.toString())
        }


    }

    override fun getItemCount(): Int {
        return arrayListArrayList.size
    }
}
