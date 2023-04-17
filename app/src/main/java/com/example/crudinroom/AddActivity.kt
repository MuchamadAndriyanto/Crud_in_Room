package com.example.crudinroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crudinroom.databinding.ActivityAddBinding
import com.example.crudinroom.room.DataNote
import com.example.crudinroom.room.NoteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class AddActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddBinding
    var dbNote : NoteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        initiate db note
        dbNote =NoteDatabase.getInstance(this)

        binding.btnSaveNote.setOnClickListener{
            addNote()
        }
    }

    fun addNote(){
        GlobalScope.async {
            var title = binding.noteTitle.text.toString()
            var note = binding.noteContent.text.toString()

            dbNote!!.noteDao().insertNote(DataNote(0,title, note))
        }
        finish()
    }
}
