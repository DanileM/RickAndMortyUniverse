package com.androidtavern.rickandmortyuniverse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidtavern.rickandmortyuniverse.databinding.MainActivityBinding
import com.androidtavern.rickandmortyuniverse.presentation.ui.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: MainActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}