package com.developsunghyun.roomdb_test.Model.Repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.developsunghyun.roomdb_test.Model.Data.DBItem
import com.developsunghyun.roomdb_test.Model.Data.DBItem2
import com.developsunghyun.roomdb_test.Model.Data.DBItemDao

@Database(entities = [DBItem::class, DBItem2::class], version = 8, exportSchema = false)
abstract class DataBase : RoomDatabase() {

    abstract fun dbItemDao(): DBItemDao

    companion object {
        @Volatile
        private var Instance: DataBase? = null

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // 새로 추가된 테이블을 생성하는 SQL 구문
                database.execSQL(
                    "CREATE TABLE IF NOT EXISTS `test_db2` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `age` INTEGER NOT NULL, `check` INTEGER NOT NULL)"
                )
            }
        }

        fun getDatabase(context: Context): DataBase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, DataBase::class.java, "item_database")
                    .addMigrations(MIGRATION_1_2)
                    .fallbackToDestructiveMigration(true)
                    .build()
                    .also { Instance = it }
            }
        }
    }

}