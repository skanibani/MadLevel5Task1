package com.example.madlevel5task1.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.madlevel5task1.database.NoteRepository

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val noteRepository = NoteRepository(application.applicationContext)

    // LiveData!
    val note = noteRepository.getNotepad()


}