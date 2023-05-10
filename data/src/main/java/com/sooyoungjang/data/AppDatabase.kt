package com.sooyoungjang.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sooyoungjang.data.record.local.dao.RecordDao
import com.sooyoungjang.data.record.local.entity.RecordEntity

@Database(entities = [RecordEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun recordDao(): RecordDao

//    companion object {
//
//        @Volatile
//        private var instance: AppDatabase? = null
//
//        fun getInstance(context: Context): AppDatabase {
//            return instance ?: synchronized(this) {
//                instance ?: buildDatabase(context).also { instance = it }
//            }
//        }
//
//        // Create and pre-populate the database. See this article for more details:
//        private fun buildDatabase(context: Context): AppDatabase {
//
//            return Room.databaseBuilder(context, AppDatabase::class.java, "super-baby-db")
//                .addCallback(object : RoomDatabase.Callback() {
//                    override fun onCreate(db: SupportSQLiteDatabase) {
//                        super.onCreate(db)
//                    }
//                }).build()
//        }
//    }
}