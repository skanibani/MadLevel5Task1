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

import com.example.madlevel5task1.databinding.FragmentNotepadBinding
import com.example.madlevel5task1.model.NoteViewModel

class NotepadFragment : Fragment() {

    private var _binding: FragmentNotepadBinding? = null
    private val binding get() = _binding!!

    // ViewModel
    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNotepadBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_NotepadFragment_to_AddNoteFragment)
        }

        observeAddNoteResult()
    }

    private fun observeAddNoteResult() {

        // Functional
        viewModel.note.observe(viewLifecycleOwner, Observer{ note ->
            note?.let {
                binding.tvTitle.text = it.title
                binding.tvLastUpdated.text = getString(R.string.notepad_last_updated, it.lastUpdated.toString())
                binding.tvNote.text = it.text
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}