package com.example.jmdb.screens.detailsmovie

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.jmdb.network.Movie

/**
 *  The [ViewModel] associated with the [DetailFragment], containing information about the selected
 *  [Movie].
 */
class DetailsMovieViewModel(movie: Movie, app: Application) : AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<Movie>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<Movie>
        get() = _selectedProperty

    // Initialize the _selectedProperty MutableLiveData
    init {
        _selectedProperty.value = movie
    }
    /*
    // The displayPropertyPrice formatted Transformation Map LiveData, which displays the sale
    // or rental price.
    val displayPropertyPrice = Transformations.map(selectedProperty) {
        app.applicationContext.getString(
            when (it.isRental) {
                true -> R.string.display_price_monthly_rental
                false -> R.string.display_price
            }, it.price)
    }

    // The displayPropertyType formatted Transformation Map LiveData, which displays the
    // "For Rent/Sale" String
    val displayPropertyType = Transformations.map(selectedProperty) {
        app.applicationContext.getString(R.string.display_type,
            app.applicationContext.getString(
                when(it.isRental) {
                    true -> R.string.type_rent
                    false -> R.string.type_sale
                }))
    }*/
}