package com.example.coroutineswithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutineswithmvvm.models.Products
import com.example.coroutineswithmvvm.viewmodels.MainViewModel
import com.example.coroutineswithmvvm.viewmodels.MainViewModelFactory
import com.example.mydaggerdemo.adapters.RepositoryAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private lateinit var reposListAdapter: RepositoryAdapter

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()

        (application as MyApplication).applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productsLiveData.observe(this, object :
            Observer<List<Products>> {
            override fun onChanged(t: List<Products>?) {
                if(t != null){
                    reposListAdapter.setUpdateData(t)
                    reposListAdapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@MainActivity, "Some data issues.....", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        reposListAdapter = RepositoryAdapter()
        recyclerView.adapter = reposListAdapter
    }
}