package com.dk.viewmodelWithActivityAndFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.dk.viewmodelWithActivityAndFragment.databinding.FragmentTestBinding


class TestFragment : Fragment() {

    private lateinit var binding : FragmentTestBinding

    private val vm : MainVM by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)

        binding.fragmentTest.text = vm.getCnt().toString()

        return binding.root
    }


}