package com.dkgtech.myexpenseapp.screens.dashboard.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dkgtech.myexpenseapp.models.ExpenseModel
import com.dkgtech.myexpenseapp.repos.ExpenseRepo

class DashboardViewModel(val expenseRepo: ExpenseRepo) : ViewModel() {

    fun addExpense(newExpense: ExpenseModel) {
        expenseRepo.addExpense(newExpense)
    }

    fun updateExpense(expense: ExpenseModel) {
        expenseRepo.updateExpense(expense)
    }

    fun deleteExpense(expense: ExpenseModel) {
        expenseRepo.deleteExpense(expense)
    }

    fun getAllExpense(): LiveData<List<ExpenseModel>> {
        return expenseRepo.getAllExpense()
    }
}