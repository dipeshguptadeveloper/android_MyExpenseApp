package com.dkgtech.myexpenseapp.screens.dashboard.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dkgtech.myexpenseapp.repos.ExpenseRepo

class DashboardViewModelFactory(val expenseRepo: ExpenseRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DashboardViewModel(expenseRepo) as T
    }
}