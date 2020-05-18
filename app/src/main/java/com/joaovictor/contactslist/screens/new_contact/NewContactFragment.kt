package com.joaovictor.contactslist.screens.new_contact

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.joaovictor.contactslist.R
import com.joaovictor.contactslist.databinding.FragmentNewContactBinding
import com.joaovictor.contactslist.screens.contacts_list.ContactsListFragment

class NewContactFragment : Fragment() {

    private lateinit var binding: FragmentNewContactBinding
    private lateinit var viewModelFactory: NewContactViewModelFactory
    private lateinit var viewModel: NewContactViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_new_contact,
            container,
            false
        )

        viewModelFactory = NewContactViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(NewContactViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.saveButton.setOnClickListener {
            viewModel.onSave(
                binding.newNameEdit.text.toString(),
                binding.newNumberEdit.text.toString()
            )

            context.apply {
                this?.let { contextFragment ->
                    val intent = ContactsListFragment.getStartIntent(
                        contextFragment,
                        viewModel.name.value.toString(),
                        viewModel.number.value.toString()
                    )
                    startActivity(intent)
                }
            }
        }

        return binding.root
    }
}
