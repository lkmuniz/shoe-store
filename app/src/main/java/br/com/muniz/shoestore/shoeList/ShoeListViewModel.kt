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
            Shoe("Venetto Social", 35.0, "Venetto", "Mixing classic and modern, the social shoe kit in synthetic varnish leather with belt and wallet combines with casual looks even the most stripped down. Featuring Metal detail and textures in synthetic varnish leather, the kit also features elastic closure, applying agility and comfort in the daily rush. its PU inner lining, guarantee well-being and comfort when walking.", mutableListOf("venetto1","venetto2","venetto3")),
            Shoe("Leather Walkabout  ", 36.0, "Walkabout ", "The Walkabout Social Shoe is ideal to compose the look in an elegant classic style. Developed in leather and modern design, it is a practical option that offers comfort and great durability for your routine.", mutableListOf("walkabout1","walkabout2","walkabout3")),
            Shoe("BR2 Footwear ", 37.0, "Footwear", "The BR2 FOOTWEAR Social Shoe is synonymous with style and elegance. With the comfort and durability of leather, it has internal lining in fabric PU Gel insole lined in fabric that provides comfort for the feet. Non-slip rubber sole with high durability, which guarantees stability when walking.", mutableListOf("footwear1","footwear2","footwear3")),
            Shoe("Democrata Prime ", 38.0, "Democrata", "Men's casual shoe in bovine leather, ideal for working, walking or composing your costume in formal appointments. With non-slip rubber outsole, elongated shape, with excellent handmade finish. Excellent cost benefit. Immediate Shipping.", mutableListOf("democrata1","democrata2","democrata3")),
            Shoe("Nevano Leather ", 39.0, "Nevano", "Nevano Leather Casual Shoes for Men. Made of leather, foam insole", mutableListOf("nevano1","nevano2","nevano3")),
            Shoe("Calprado Casual ", 40.0, "Calprado", "Mixing the classic and the modern, the Calprado shoe in suede combines with casual looks even the most stripped down, the model also brings the lace closure, applying agility and comfort in the daily rush, guaranteeing well-being and comfort when walking. The rubber sole applies security to the product, which is a wild card to use with jeans and shirt.", mutableListOf("calprado1","calprado2","calprado3")),
            Shoe("Oxford Casual Brogue Premium Confort ", 41.0, "Oxford ", "Casual, but fully adaptable to the sophisticated, this product offers countless possibilities, all full of originality. From work to ballad, this item is compatible with any occasion, just combine it with the desired look and be happy.", mutableListOf("oxford1","oxford2","oxford3"))
        )
    }
}