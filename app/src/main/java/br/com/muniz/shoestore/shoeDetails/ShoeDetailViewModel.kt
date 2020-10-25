package br.com.muniz.shoestore.shoeDetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.muniz.shoestore.models.Shoe

class ShoeDetailViewModel(shoe: Shoe) : ViewModel() {

    private var _shoeName = MutableLiveData<String>()
    val shoeName: LiveData<String>
        get() = _shoeName

    private var _shoeCompany = MutableLiveData<String>()
    val shoeCompany: LiveData<String>
        get() = _shoeCompany

    private var _shoeSize = MutableLiveData<Double>()
    val shoeSize: LiveData<Double>
        get() = _shoeSize

    private var _shoeDescription = MutableLiveData<String>()
    val shoeDescription: LiveData<String>
        get() = _shoeDescription

    private var _shoeImages = MutableLiveData<String>()
    val shoeImages: LiveData<String>
        get() = _shoeImages

    init {
        _shoeName.value = shoe.name
        _shoeCompany.value = shoe.company
        _shoeSize.value = shoe.size
        _shoeDescription.value = shoe.description
    }
}