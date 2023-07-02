package com.dkgtech.myexpenseapp.screens.add_expense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dkgtech.myexpenseapp.R
import com.dkgtech.myexpenseapp.databinding.ActivityAddExpenseBinding

class AddExpenseActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddExpenseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}