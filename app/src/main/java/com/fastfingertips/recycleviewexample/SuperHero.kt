package com.fastfingertips.recycleviewexample

import java.io.Serializable

class SuperHero(
    val name: String,
    val job: String,
    val image: Int? = R.drawable.default_image) : Serializable {

}