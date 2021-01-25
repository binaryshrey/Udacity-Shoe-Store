package com.example.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.MainActivity
import com.example.shoestore.utils.PreferencesUtil

class ShoeViewModel : ViewModel() {


    private val _email = MutableLiveData<String>()
    val email: MutableLiveData<String>
        get() = _email

    private val _password = MutableLiveData<String>()
    val password: MutableLiveData<String>
        get() = _password

    private val _eventLogin = MutableLiveData<Boolean>()
    val eventLogin: LiveData<Boolean>
        get() = _eventLogin

    private val _eventIntro = MutableLiveData<Boolean>()
    val eventIntro: LiveData<Boolean>
        get() = _eventIntro

    private val _eventOpenShoeList = MutableLiveData<Boolean>()
    val eventOpenShoeList : LiveData<Boolean>
        get() = _eventOpenShoeList


    init {
        _email.value = ""
        _password.value = ""
    }

    fun storeLoginState(activity: MainActivity, isLoggedIn: Boolean) {
        PreferencesUtil.storeLoginStateToPreferences(activity, isLoggedIn)
    }

    fun onLogin() {
        _eventLogin.value = true
    }

    fun onLoginComplete() {
        _eventLogin.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun onIntro(){
        _eventIntro.value = true
    }

    fun onOpenShoeList(){
        _eventOpenShoeList.value = true
    }

    fun onOpenShoeListComplete(){
        _eventOpenShoeList.value = false
    }

}

