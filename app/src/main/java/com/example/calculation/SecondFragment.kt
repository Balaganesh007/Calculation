package com.example.calculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.calculation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_second,
            container,
            false
        )
        val args = SecondFragmentArgs.fromBundle(arguments!!)
        val addition = args.addition
        val subtraction = args.subtraction
        val multiplication = args.multiplication
        val division = args.division
        binding.additionTV.text = addition
        binding.SubtractionTV.text = subtraction
        binding.divisionTV.text = division
        binding.multiplicationTV.text = multiplication

        return binding.root
    }

}