package br.com.muniz.shoestore.viewModel

import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.muniz.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    fun addShoe(shoe: Shoe?) {
        shoe?.let {
            _shoeList.value?.add(it)
        }
    }

    init {
        _shoeList.postValue(mutableListOf())
    }

    object Converter {

        @InverseMethod("stringToDouble")
        @JvmStatic
        fun doubleToString(value: Double?): String {
            return value?.toString() ?: ""
        }

        @JvmStatic
        fun stringToDouble(value: String): Double? {
            return if (value.isNotEmpty()) {
                value.trim().toDouble()
            } else {
                0.0
            }
        }

        @InverseMethod("trim")
        @JvmStatic
        fun trim(string: String): String? {
            return string.replace("\n"," ").trim()
        }
    }
}