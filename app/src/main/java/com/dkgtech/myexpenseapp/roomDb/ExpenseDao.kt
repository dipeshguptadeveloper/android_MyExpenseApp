package com.dkgtech.myexpenseapp.roomDb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dkgtech.myexpenseapp.models.ExpenseModel

@Dao
interface ExpenseDao {

    @Insert
    fun addExpense(newExpense: ExpenseModel)

    @Update
    fun updateExpense(expense: ExpenseModel)

    @Delete
    fun deleteExpense(expense: ExpenseModel)

    @Query("select * from expense")
    fun getAllExpense(): LiveData<List<ExpenseModel>>
}