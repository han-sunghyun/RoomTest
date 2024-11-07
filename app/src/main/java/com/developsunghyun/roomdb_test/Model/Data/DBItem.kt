package com.developsunghyun.roomdb_test.Model.Data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "test_db")
data class DBItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var age: Int
)

@Entity(tableName = "test_db2",
    foreignKeys = [
        ForeignKey(
            entity = DBItem::class,                // 참조할 부모 엔티티 클래스
            parentColumns = ["id"],          // 부모 테이블의 키 컬럼
            childColumns = ["c"],      // 자식 테이블의 외래 키 컬럼
            onDelete = ForeignKey.CASCADE        // 부모 데이터 삭제 시 자식 데이터도 삭제
        )
    ])
data class DBItem2(
    @PrimaryKey(autoGenerate = true)
    var c: Int = 0,
    var id: Int,
    var name: String,
    var age: Int,
    var check: Boolean
)
