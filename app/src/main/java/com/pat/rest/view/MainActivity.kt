package com.pat.rest.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.pat.rest.viewmodel.MainViewModel
import com.pat.rest.databinding.ActivityMainBinding
import com.pat.rest.model.CatFactItem
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeFactItem()
        mainViewModel.getFact()
        binding.button.setOnClickListener()
        {
            binding.textView.text = ""
            binding.progressBar.visibility = View.VISIBLE
            mainViewModel.getFact()
        }

    }

    private fun observeFactItem() {
        mainViewModel.catFactLiveData.observe(this, Observer {
            binding.progressBar.visibility = View.INVISIBLE
            binding.textView.text = it.text

        })
    }

}


