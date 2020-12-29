package database

import androidx.room.*
import model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM noteTable")
    suspend fun getAllNotes(): List<Note>

    @Insert
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(vararg note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE FROM noteTable")
    suspend fun deleteAllNotes()
}