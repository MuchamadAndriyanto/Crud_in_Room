package com.example.crudinroom.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDAO {

    @Insert
    fun insertNote(note: DataNote)

    @Query("SELECT * FROM DataNote ORDER BY id DESC ")
    fun getDataNote() : List<DataNote>

    @Delete
    fun deleteNote(note: DataNote)

    @Update
    fun updateNote(note: DataNote)

}
