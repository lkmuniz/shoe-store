package br.com.muniz.shoestore.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.muniz.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        fillShoeList()
    }

    private fun fillShoeList() {
        _shoeList.value = listOf(
            Shoe("Nike Shoks", 35.0, "Nike", "Nike SHoks", mutableListOf("image1")),
            Shoe("Puma ", 36.0, "Puma", "Puma", mutableListOf("image2")),
            Shoe("Olympikus ", 37.0, "Olympikus", "Olympikus", mutableListOf("image2")),
            Shoe("Adidas ", 38.0, "Adidas", "Adidas", mutableListOf("image2")),
            Shoe("Mizuno ", 39.0, "Mizuno", "Mizuno", mutableListOf("image2")),
            Shoe("Topper ", 40.0, "Topper", "Topper", mutableListOf("image2")),
            Shoe("Reebok ", 41.0, "Reebok", "Reebok", mutableListOf("image2")),
            Shoe("Umbro ", 42.0, "Umbro", "Umbro", mutableListOf("image2"))
        )
    }
}