package com.dkgtech.myexpenseapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dkgtech.myexpenseapp.databinding.ExpenseRowBinding
import com.dkgtech.myexpenseapp.models.ExpenseModel

class RecyclerExpenseAdapter(val context: Context, val arrExpense: ArrayList<ExpenseModel>) :
    RecyclerView.Adapter<RecyclerExpenseAdapter.ViewHolder>() {
    class ViewHolder(val binding: ExpenseRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(expense: ExpenseModel) {
            binding.expense = expense

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ExpenseRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return arrExpense.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arrExpense[position])
    }
}