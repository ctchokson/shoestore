package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_detail.*


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {
    val model: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater, R.layout.fragment_shoe_detail, container, false)
        binding.cancelButton.setOnClickListener { it.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(null)) }
        binding.saveButton.setOnClickListener {
            if(validateAllFields()) {
                val newShoe = Shoe(
                    binding.nameEditText.text.toString(),
                    binding.shoeSizeEdittext.text.toString().toDouble(),
                    binding.companyEdittext.text.toString(),
                    binding.descriptionEdittext.text.toString(),
                    mutableListOf()
                )
                model.addNewShoe(newShoe)
                it.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(newShoe))}
            }

        return binding.root
    }

    private fun validateAllFields(): Boolean {
        if(name_editText.text.isNullOrEmpty()){
            name_editText.error = "This field is required"
            return false
        }
        if(shoe_size_edittext.text.isNullOrEmpty() || shoe_size_edittext.text.isDigitsOnly().not()){
            shoe_size_edittext.error = "This field is required and should be a number"
            return false
        }
        if(company_edittext.text.isNullOrEmpty()){
            company_edittext.error = "This field is required"
            return false
        }
        if(description_edittext.text.isNullOrEmpty()){
            description_edittext.error = "This field is required"
            return false
        }

        return true
    }

}