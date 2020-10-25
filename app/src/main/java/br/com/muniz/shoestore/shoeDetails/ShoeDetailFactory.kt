package br.com.muniz.shoestore.shoeDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.muniz.shoestore.models.Shoe

class ShoeDetailFactory(private val shoeItem: Shoe) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeDetailViewModel::class.java)) {
            return ShoeDetailViewModel(shoeItem) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}