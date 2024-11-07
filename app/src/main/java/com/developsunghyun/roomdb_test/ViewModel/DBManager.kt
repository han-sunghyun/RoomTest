package com.developsunghyun.roomdb_test.ViewModel

import android.app.Application
import android.content.Context
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import com.developsunghyun.roomdb_test.Model.Data.DBItem
import com.developsunghyun.roomdb_test.Model.Data.DBItem2
import com.developsunghyun.roomdb_test.Model.Data.DBItemDao
import com.developsunghyun.roomdb_test.Model.Repository.DataBase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class DBManager(context: Context) : ViewModel() {
    val a = context
    val dao = DataBase.getDatabase(a).dbItemDao()
    suspend fun testInsert2(){
        dao.insert2(DBItem2(id = 3, name = "데이터 가 들어온다!!!", age = 22, check = true))
    }

    suspend fun getDataList(): List<DBItem2>{
        val aaa = dao.getAllItems2().first()

        return aaa
    }
}