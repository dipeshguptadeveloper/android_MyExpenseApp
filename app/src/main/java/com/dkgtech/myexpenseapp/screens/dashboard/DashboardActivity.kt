package com.dkgtech.myexpenseapp.screens.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dkgtech.myexpenseapp.R
import com.dkgtech.myexpenseapp.adapters.RecyclerExpenseAdapter
import com.dkgtech.myexpenseapp.databinding.ActivityDashboardBinding
import com.dkgtech.myexpenseapp.models.CategoryModel
import com.dkgtech.myexpenseapp.models.ExpenseModel
import com.dkgtech.myexpenseapp.repos.ExpenseRepo
import com.dkgtech.myexpenseapp.roomDb.AppDatabase
import com.dkgtech.myexpenseapp.screens.add_expense.AddExpenseActivity
import com.dkgtech.myexpenseapp.screens.dashboard.viewModel.DashboardViewModel
import com.dkgtech.myexpenseapp.screens.dashboard.viewModel.DashboardViewModelFactory
import java.util.Calendar

class DashboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding

    companion object {
        val arrCat = ArrayList<CategoryModel>().apply {
            add(CategoryModel(id = 1, name = "Shopping", imgPath = R.drawable.shopping))
            add(CategoryModel(id = 2, name = "Food", imgPath = R.drawable.food))
            add(CategoryModel(id = 3, name = "Grocery", imgPath = R.drawable.grocery))
            add(CategoryModel(id = 4, name = "Movie", imgPath = R.drawable.movie))
            add(CategoryModel(id = 5, name = "Massage", imgPath = R.drawable.massage))
            add(CategoryModel(id = 6, name = "Travel", imgPath = R.drawable.travel))
            add(CategoryModel(id = 7, name = "Petrol/Gas", imgPath = R.drawable.petrol))
            add(CategoryModel(id = 8, name = "Salon", imgPath = R.drawable.salon))

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val appDb = AppDatabase.getDatabase(this@DashboardActivity)

        val expenseRepo = ExpenseRepo(appDb.ExpenseDao())

        val dashboardViewModel = ViewModelProvider(
            this@DashboardActivity,
            DashboardViewModelFactory(expenseRepo)
        )[DashboardViewModel::class.java]


        dashboardViewModel.addExpense(
            ExpenseModel(
                id = 0,
                title = "Clothing",
                desc = "Cloth Shopping",
                amount = 500.00,
                balance = 500.00,
                type = 1,
                catType = 1,
                date = Calendar.getInstance().timeInMillis.toString()
            )
        )

        dashboardViewModel.addExpense(
            ExpenseModel(
                id = 0,
                title = "Food & Drink",
                desc = "Sea food in Europe Restaurant",
                amount = 200.00,
                balance = 100.00,
                type = 1,
                catType = 2,
                date = Calendar.getInstance().timeInMillis.toString()
            )
        )

        dashboardViewModel.getAllExpense().observe(this@DashboardActivity) {

            binding.rcViewExpense.layoutManager = LinearLayoutManager(this@DashboardActivity)
            binding.rcViewExpense.adapter =
                RecyclerExpenseAdapter(this@DashboardActivity, it as ArrayList<ExpenseModel>)
        }

    }

    fun moveToAddExpense() {
        startActivity(Intent(this@DashboardActivity, AddExpenseActivity::class.java))
    }
}