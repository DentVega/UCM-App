package com.brianvega.ucm_app.models.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "movie")
class Movie {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
    @ColumnInfo(name = "name")
    var name: String? = null
    @ColumnInfo(name = "url_movie_poster")
    var urlMoviePoster: String? = null
    @ColumnInfo(name = "release_date")
    var releaseDate: Date? = null
    @ColumnInfo(name = "amount_collected")
    var amountCollected: Double? = null
    @ColumnInfo(name = "short_summary")
    var shortSummary: String? = null
    @Ignore
    var heroe: List<Int>? = null

    constructor()

    constructor(name: String?, urlMoviePoster: String?, releaseDate: Date?, amountCollected: Double?,
        shortSummary: String?) {
        this.name = name
        this.urlMoviePoster = urlMoviePoster
        this.releaseDate = releaseDate
        this.amountCollected = amountCollected
        this.shortSummary = shortSummary
    }

}