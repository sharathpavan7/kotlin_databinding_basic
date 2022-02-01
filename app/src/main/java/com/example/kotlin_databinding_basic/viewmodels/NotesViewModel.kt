package com.example.kotlin_databinding_basic.viewmodels

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_databinding_basic.model.Note

class NotesViewModel: ViewModel(), Observable {

    val isDataEmpty = MutableLiveData<Boolean>()

    @Bindable
    val inputTitle = MutableLiveData<String>()

    @Bindable
    val inputDescription = MutableLiveData<String>()

    val list = MutableLiveData<ArrayList<Note>>()

    val arrayLst = ArrayList<Note>()

    init {
        isDataEmpty.value = false
    }

    fun addNote() {
        val title = inputTitle.value ?: ""
        val description = inputDescription.value ?: ""
        if (title.isBlank() || description.isBlank()) {
            isDataEmpty.value = true
        } else {
            inputTitle.value = ""
            inputDescription.value = ""
            val note = Note(title, description)
            arrayLst.add(note)
            list.value = arrayLst
        }
    }

    fun clearNote() {
        arrayLst.clear()
        list.value = arrayLst
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}