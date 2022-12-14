package com.auliamnaufal.dictionariesapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Visibility
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.auliamnaufal.dictionariesapi.data.DictionaryResponseItem
import com.auliamnaufal.dictionariesapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var viewModel: MainViewModel? = null
    
    private val mAdapter = DictionaryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContentView(binding.root)

        binding.tvDefinition.visibility = View.INVISIBLE

        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel?.getApiSearch(query)
                viewModel?.data?.observe(this@MainActivity) {
                    if (it != null) {
                        binding.tvDefinition.visibility = View.VISIBLE
                        setupView(it)

                    } else {
                        Toast.makeText(this@MainActivity, "Search Something else", Toast.LENGTH_SHORT).show()
                    }

                    val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(binding.root.windowToken, 0)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun setupView(data: List<DictionaryResponseItem>) {
        binding.apply {
            tvWordName.text = data.get(0).word
            tvPhonetics.text = data.get(0).phonetic

            rvDefinition.apply {
                mAdapter.setData(data.get(0).meanings?.get(0)?.definitions)
                adapter = mAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}