package com.example.viewmodelandlivedatademo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelandlivedatademo.adapters.UserAdapter
import com.example.viewmodelandlivedatademo.models.User
import com.example.viewmodelandlivedatademo.usermodels.UserViewModel
import com.example.viewmodelandlivedatademo.utils.CheckNetworkConnectivity

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private lateinit var checkNetworkConnectivity: CheckNetworkConnectivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intiRecyclerView()
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.getUserList()
        userViewModel.userList.observe(this, Observer {
            userAdapter.setUserData(it as ArrayList<User>)
        })

        checkNetworkConnectivity = CheckNetworkConnectivity(application)
        checkNetworkConnectivity.observe(this,{
            Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
        })
    }

    private fun intiRecyclerView() {
        recyclerView = findViewById(R.id.rcv)
        userAdapter = UserAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }
}