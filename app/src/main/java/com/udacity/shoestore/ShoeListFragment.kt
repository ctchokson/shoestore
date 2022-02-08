package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginLeft
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_detail.*


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {

    val model: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater, R.layout.fragment_shoe_list, container, false)

        model.shoeList.observe(viewLifecycleOwner){
            item -> val layout:LinearLayout = binding.mainLayout

            var newTextView: TextView
            for(shoe in item)
            {

                newTextView = TextView(activity)
                newTextView.layoutParams = layout.layoutParams
                newTextView.gravity = Gravity.LEFT
                newTextView.text = "Name:${shoe.name}, Size:${shoe.size}, Company:${shoe.company}, Description:${shoe.description}"
                layout.addView(newTextView)
            }
        }
       binding.floatingActionButton.setOnClickListener { it.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()) }
       setHasOptionsMenu(true)
       return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.loginFragment -> resetShoeList()
        }
            return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun resetShoeList(){
        model.resetList()
    }




}