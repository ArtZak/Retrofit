package com.example.retrofit

data class DataModel(
    var code: Int,
    var meta: String,
    var data: Data? = null){

    data class Data(
        var id: Int,
        var name: String,
        var description: String,
        var price: String,
        var discount_amount: String
    )
}