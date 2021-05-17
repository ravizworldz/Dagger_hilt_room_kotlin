package com.demo.daggerroomdbdemo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {

    @Query("SELECT * FROM user ORDER BY id DESC")
    fun getRecords(): List<UserEntity>


    @Insert
    fun insertRecord(userEntity: UserEntity)
}