package com.demo.daggerroomdbdemo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserEntity (

    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id") val id: Int= 0,
    @ColumnInfo(name = "name")val name: String
)