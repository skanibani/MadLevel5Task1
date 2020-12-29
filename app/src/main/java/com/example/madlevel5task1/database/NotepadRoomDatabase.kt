package com.example.madlevel5task1.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.madlevel5task1.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class NotepadRoomDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        private const val DATABASE_NAME = "NOTEPAD_DATABASE"

        @Volatile
        private var INSTANCE: NotepadRoomDatabase? = null

        fun getDatabase(context: Context): NotepadRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(NotepadRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                                context.applicationContext,
                                NotepadRoomDatabase::class.java, DATABASE_NAME
                        )
                                .fallbackToDestructiveMigration()
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}