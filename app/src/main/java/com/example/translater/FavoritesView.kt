package com.example.translater

import model.favorites.Favorites

/**
 * Created by Марат on 2017-11-27.
 */
interface FavoritesView{
    fun getAllFavorites()
    fun setFavorites(list:List<Favorites>)
    fun deleteAllFavorites()
}