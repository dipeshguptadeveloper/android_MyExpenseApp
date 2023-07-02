package com.dkgtech.myexpenseapp.repos

import androidx.lifecycle.LiveData
import com.dkgtech.myexpenseapp.models.ExpenseModel
import com.dkgtech.myexpenseapp.roomDb.ExpenseDao

class ExpenseRepo(val dao: ExpenseDao) {

    fun addExpense(newExpense: ExpenseModel) {
        dao.addExpense(newExpense)
    }

    fun updateExpense(expense: ExpenseModel) {
        dao.updateExpense(expense)
    }

    fun deleteExpense(expense: ExpenseModel) {
        dao.deleteExpense(expense)
    }

    fun getAllExpense(): LiveData<List<ExpenseModel>> {
        return dao.getAllExpense()
    }
}