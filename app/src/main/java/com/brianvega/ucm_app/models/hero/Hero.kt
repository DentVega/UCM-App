package com.brianvega.ucm_app.models.hero

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "hero")
class Hero {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
    @ColumnInfo(name = "name")
    var name: String? = null
    @ColumnInfo(name = "url_profile_picture")
    var urlProfilePicture: String? = null
    @ColumnInfo(name = "description")
    var description: String? = null
    @Ignore
    var movies: List<Int>? = null

    constructor()

    constructor(name: String?, urlProfilePicture: String?, description: String?) {
        this.name = name
        this.urlProfilePicture = urlProfilePicture
        this.description = description
    }

    constructor(id: Long?, name: String?, urlProfilePicture: String?, description: String?) {
        this.id = id
        this.name = name
        this.urlProfilePicture = urlProfilePicture
        this.description = description
    }


}