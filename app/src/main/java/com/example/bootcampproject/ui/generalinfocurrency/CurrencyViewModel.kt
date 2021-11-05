package com.example.bootcampproject.ui.generalinfocurrency

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bootcampproject.data.repo.CurrencyRepo
import com.example.bootcampproject.domain.Currency
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val currencyRepo: CurrencyRepo
) : ViewModel(){
    private val _currencies: MutableLiveData<List<Currency>> = MutableLiveData()
    val currencies: LiveData<List<Currency>> = _currencies

    fun getActualCurrencies(){
        currencyRepo.getCurrencies(_currencies)
    }
}