package com.example.calculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.calculation.databinding.FragmentCalculateBinding

class CalculateFragment : Fragment() {

    private lateinit var viewModel: CalculateViewModel
    private lateinit var binding: FragmentCalculateBinding

    var add = ""
    var sub = ""
    var multi = ""
    var div = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_calculate,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(CalculateViewModel::class.java)

        binding.calculateViewModel = viewModel
        binding.lifecycleOwner = this

        binding.calculateButton.setOnClickListener {
            calculate()
        }

        viewModel.add.observe(this, Observer {
            add = viewModel.add.value.toString()
            binding.additionTextView.text = viewModel.add.value.toString()
        })
        viewModel.sub.observe(this, Observer {
            sub = viewModel.sub.value.toString()
            binding.subtractionTextView.text = viewModel.sub.value.toString()
        })
        viewModel.div.observe(this, Observer {
            div = viewModel.div.value.toString()
            binding.divisionTextView.text = viewModel.div.value.toString()
        })
        viewModel.mult.observe(this, Observer {
            multi = viewModel.mult.value.toString()
            binding.multiplicationTextView.text = viewModel.mult.value.toString()
        })
        binding.nextButton.setOnClickListener {
            findNavController().navigate(CalculateFragmentDirections.actionCalculateFragmentToSecondFragment(addition = add, subtraction = sub, multiplication = multi, division = div))
        }

        return binding.root
    }

    private fun calculate() {
        val number01 = binding.editTextNumberSigned.text.toString().toInt()
        val number02 = binding.editTextNumberSigned2.text.toString().toInt()

        viewModel.addition(number01, number02)
        viewModel.subtraction(number01, number02)
        viewModel.division(number01, number02)
        viewModel.multiplication(number01, number02)
    }
}