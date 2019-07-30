package com.brianvega.ucm_app.models.heroMovie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heromovie")
class HeroMovie {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
    @ColumnInfo(name = "id_hero")
    var idHero: Long? = null
    @ColumnInfo(name = "id_movie")
    var idMovie: Long? = null
    @ColumnInfo(name = "operation_id")
    var operationId: Int? = null

    constructor()

    constructor(idHero: Long?, idMovie: Long?, operationId: Int?) {
        this.idHero = idHero
        this.idMovie = idMovie
        this.operationId = operationId
    }


}