package com.joaovictor.contactslist.screens.contacts_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log.i
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.joaovictor.contactslist.MainActivity
import com.joaovictor.contactslist.R
import com.joaovictor.contactslist.databinding.FragmentContactsListBinding


class ContactsListFragment : Fragment() {

    private lateinit var binding: FragmentContactsListBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_contacts_list,
            container,
            false
        )


        activity?.intent?.let {
            i("ContactsList", "${it.getStringExtra(EXTRA_NAME)} - ${it.getStringExtra(EXTRA_NUMBER)}")

        }

        binding.fab.setOnClickListener {
            findNavController().
            navigate(ContactsListFragmentDirections.actionContactsListFragmentToNewContactFragment())
        }

        return binding.root
    }

    companion object {
        private const val EXTRA_NAME = "EXTRA_NAME"
        private const val EXTRA_NUMBER = "EXTRA_NUMBER"

        fun getStartIntent(context: Context, name: String, number: String) : Intent {
            return Intent(context, MainActivity::class.java).apply {
                putExtra(EXTRA_NAME, name)
                putExtra(EXTRA_NUMBER, number)
            }

        }
    }
}
