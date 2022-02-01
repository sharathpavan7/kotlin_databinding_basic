package com.example.kotlin_databinding_basic.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kotlin_databinding_basic.R
import com.example.kotlin_databinding_basic.databinding.ActivityMainBinding
import com.example.kotlin_databinding_basic.viewmodels.NotesViewModel
import com.example.kotlin_databinding_basic.viewmodels.NotesViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var notesViewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val fctory = NotesViewModelFactory()
        notesViewModel = ViewModelProviders.of(this, fctory).get(NotesViewModel::class.java)
        dataBinding.notesViewModel = notesViewModel
        dataBinding.lifecycleOwner = this

        notesViewModel.list.observe(this, Observer {
            dataBinding.note.text = it.toString()
        })

        notesViewModel.isDataEmpty.observe(this, Observer {
            Toast.makeText(this, "No data", Toast.LENGTH_LONG).show()
        })

    }
}