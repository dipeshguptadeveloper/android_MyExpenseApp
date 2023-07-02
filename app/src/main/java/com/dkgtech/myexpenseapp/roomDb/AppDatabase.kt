package com.dkgtech.myexpenseapp.roomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dkgtech.myexpenseapp.models.ExpenseModel

@Database(entities = [ExpenseModel::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        val DB_NAME = "expense_db"
        var DB_INSTANCE: AppDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {

            if (DB_INSTANCE == null) {
                DB_INSTANCE =
                    Room.databaseBuilder(
                        context.applicationContext, AppDatabase::class.java,
                        DB_NAME
                    ).allowMainThreadQueries().build()

            }

            return DB_INSTANCE!!
        }

    }

    abstract fun ExpenseDao(): ExpenseDao
}