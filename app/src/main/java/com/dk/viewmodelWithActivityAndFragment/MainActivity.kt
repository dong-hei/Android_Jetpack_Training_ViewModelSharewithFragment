package com.dk.viewmodelWithActivityAndFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dk.viewmodelWithActivityAndFragment.databinding.ActivityMainBinding

/**
 * VM -> Activity/Fragment 공유
 * 왜? Activity의 값을 Fragment로 쓰고싶거나 Fragment에서 값을 VM의 값으로 사용하기 위해
 */
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var vm :MainVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        vm = ViewModelProvider(this).get(MainVM::class.java)

        binding.resultArea.text = vm.getCnt().toString()

        binding.plus.setOnClickListener {
            vm.plus()
            binding.resultArea.text = vm.getCnt().toString()
        }

        binding.minus.setOnClickListener {
            vm.minus()
            binding.resultArea.text = vm.getCnt().toString()
        }

        val manager = supportFragmentManager

        binding.framgmentBtn.setOnClickListener{
            val transaction = manager.beginTransaction()
            val fragment = TestFragment()
            transaction.replace(R.id.FrameArea, fragment)
            transaction.commit()
        }

    }
}