package com.demo.daggerroomdbdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.demo.daggerroomdbdemo.db.UserEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveButton.setOnClickListener {
            val userEntity = UserEntity(name = enterDescriptionEditText.text.toString())
            viewModel.insertRecord(userEntity)
            enterDescriptionEditText.setText("")
        }
        initVM()
    }

    private fun initVM() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecordsObserver().observe(this, object : Observer<List<UserEntity>>{
            override fun onChanged(t: List<UserEntity>?) {
                resultTextView.setText("")
                t?.forEach {
                    resultTextView.append(it.name +"\n")
                }
            }
        })

    }
}