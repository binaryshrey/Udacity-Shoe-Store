package com.example.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.MainActivity
import com.example.shoestore.model.Shoe
import com.example.shoestore.utils.PreferencesUtil

class ShoeViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: MutableLiveData<String>
        get() = _email

    private val _password = MutableLiveData<String>()
    val password: MutableLiveData<String>
        get() = _password

    private val _eventIntro = MutableLiveData<Boolean>()
    val eventIntro: LiveData<Boolean>
        get() = _eventIntro

    private val _eventOpenShoeList = MutableLiveData<Boolean>()
    val eventOpenShoeList : LiveData<Boolean>
        get() = _eventOpenShoeList

    private val _eventAddShoeDetails = MutableLiveData<Boolean>()
    val eventAddShoeDetails : LiveData<Boolean>
        get() = _eventAddShoeDetails

    private val _eventSave = MutableLiveData<Boolean>()
    val eventSave : LiveData<Boolean>
        get() = _eventSave

    private val _eventCancel = MutableLiveData<Boolean>()
    val eventCancel : LiveData<Boolean>
        get() = _eventCancel

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes : LiveData<MutableList<Shoe>>
        get() = _shoes
    private val shoeList = ArrayList<Shoe>()

    private val _eventLogin = MutableLiveData<Boolean>()
    val eventLogin: LiveData<Boolean>
        get() = _eventLogin

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean>
        get() = _isLoggedIn

    private val _isLoggedOut = MutableLiveData<Boolean>()
    val isLoggedOut: LiveData<Boolean>
        get() = _isLoggedOut

    init {
        _email.value = ""
        _password.value = ""
        _shoes.value = ArrayList()
    }

    fun storeLoginState(activity: MainActivity, isLoggedIn: Boolean) {
        PreferencesUtil.storeLoginStateToPreferences(activity, isLoggedIn)
    }

    fun getLoginState(activity: MainActivity) {
        val isLoggedIn = PreferencesUtil.getLoginStateFromPreferences(activity)
        _isLoggedIn.value = isLoggedIn
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

    fun onIntroComplete(){
        _eventIntro.value = false
    }

    fun onOpenShoeList(){
        _eventOpenShoeList.value = true
    }

    fun onOpenShoeListComplete(){
        _eventOpenShoeList.value = false
    }

    fun onAddShoeDetails(){
        _eventAddShoeDetails.value = true
    }

    fun onAddShoeDetailsComplete(){
        _eventAddShoeDetails.value = false
    }

    fun onEventSave(shoe: Shoe?){
        if(shoe != null){
            shoeList.add(shoe)
            _shoes.value = shoeList
            _eventSave.value = true
        }
    }

    fun onEventSaveCompleted(){
        _eventSave.value = false
    }

    fun onEventCancel(){
        _eventCancel.value = true
    }

    fun onEventCancelCompleted(){
        _eventCancel.value = false
    }

    fun onLogOutComplete(){
        _isLoggedOut.value = false
    }

    fun onLogOut(activity: MainActivity) {
        storeLoginState(activity, false)
        _isLoggedOut.value = true
    }
}

