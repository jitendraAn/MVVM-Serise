package com.example.viewmodelandlivedatademo.usermodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodelandlivedatademo.models.User
import com.example.viewmodelandlivedatademo.utils.UserDataList

class UserViewModel:ViewModel() {

    val userList: MutableLiveData<List<User>> = MutableLiveData()

    fun getUserList()
    {
        val user=UserDataList.setUserList()
        userList.value=user
    }
}