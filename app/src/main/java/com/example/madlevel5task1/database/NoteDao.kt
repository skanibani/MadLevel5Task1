package com.example.madlevel5task1.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.madlevel5task1.model.Note

@Dao
interface NoteDao {

    // Wrapping data in LiveData automatically
    // makes it operate in a background thread.
    // This eliminates the manual creation of a coroutine.
    @Query("SELECT * FROM noteTable LIMIT 1")
    fun getNotepad(): LiveData<Note?>

    @Insert
    fun insertNote(note: Note)

    @Update
    fun updateNote(vararg note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("DELETE FROM noteTable")
    fun deleteAllNotes()
}