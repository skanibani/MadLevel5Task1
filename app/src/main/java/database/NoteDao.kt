package database

import androidx.lifecycle.LiveData
import androidx.room.*
import model.Note

@Dao
interface NoteDao {

    // Wrapping data in LiveData automatically
    // makes it operate in a background thread.
    // This eliminates the manual creation of a coroutine.
    @Query("SELECT * FROM noteTable LIMIT 1")
    suspend fun getNotepad(): LiveData<Note?>

    @Insert
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(vararg note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE FROM noteTable")
    suspend fun deleteAllNotes()
}