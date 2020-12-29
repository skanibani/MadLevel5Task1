package com.example.madlevel5task1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.madlevel5task1.R
import com.example.madlevel5task1.databinding.FragmentAddNoteBinding
import com.example.madlevel5task1.model.NoteViewModel

class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {

            saveNote()

            // Back to Notepad
            findNavController().navigate(R.id.action_AddNoteFragment_to_NotepadFragment)
        }

        observeNote()
    }

    private fun observeNote() {
        viewModel.note.observe(viewLifecycleOwner, Observer {
            note ->
                note?.let {
                    binding.inputTitle?.setText(it.title)
                    binding.inputNote?.setText(it.text)
                }
        })
    }

    private fun saveNote() {
        viewModel.updateNote(
                binding.inputTitle?.text.toString(),
                binding.inputNote?.text.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}