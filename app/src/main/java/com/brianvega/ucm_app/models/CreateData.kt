package com.brianvega.ucm_app.models

import com.brianvega.ucm_app.models.hero.Hero
import com.brianvega.ucm_app.models.movie.Movie
import java.util.*

object CreateData {

    fun createDataHeroeV1(): List<Hero> {
        val heroes = mutableListOf<Hero>()
        val descriptionIronMan =
            "Iron Man —también conocido en español como el Hombre de Hierro— es un superhéroe ficticio que aparece en los cómics estadounidenses publicados por Marvel Comics. El personaje fue co-creado por el escritor y editor Stan Lee, desarrollado por el guionista Larry Lieber y diseñado por los artistas Don Heck y Jack Kirby."
        val ironMan = Hero("Iron Man", "", descriptionIronMan)
        val descriptionCaptainAmerica =
            "Capitán América cuyo nombre real es Steven Grant Rogers, es un superhéroe ficticio que aparece en los cómics estadounidenses publicados por Marvel."
        val captainAmerica = Hero("Capitan America", "", descriptionCaptainAmerica)
        val descriptionBlackWindow =
            "Natalia Alianovna Romanova, coloquial: Viuda Negra es una superheroína ficticia que aparece en el cómic estadounidense y libros publicados por Marvel Comics. Creado por el editor y trazador Stan Lee, el guionista Don Rico y el artista Don Heck, el personaje debutó en Tales of Suspense # 52."
        val blackWindow = Hero("Viuda Negra", "", descriptionBlackWindow)
        val descriptionThor =
            "Thor es un superhéroe ficticio que aparece en los cómics estadounidenses publicados por Marvel Comics."
        val thor = Hero("Thor", "", descriptionThor)
        val descriptionBruceBanner =
            "Hulk es un personaje ficticio, que aparece en los cómics estadounidenses publicados por la editorial Marvel Comics. El personaje fue creado por los escritores Stan Lee y Jack Kirby siendo su primera aparición en The Incredible Hulk #1 publicado en mayo de 1962."
        val bruceBanner = Hero("Bruce Banner", "", descriptionBruceBanner)
        val descriptionSpiderMan =
            "Spider-Man es un superhéroe ficticio creado por los escritores y editores Stan Lee y Steve Ditko. Apareció por primera vez en el cómic de antología Amazing Fantasy # 15 en la Edad de Plata de los cómics."
        val spiderMan = Hero("Spider Man", "", descriptionSpiderMan)
        val descriptionHackEye =
            "Ojo de Halcón, es un superhéroe de ficción que aparece en los cómics estadounidenses publicados por Marvel Comics. Creado por el escritor Stan Lee y el artista Don Heck, el personaje apareció por primera vez como un villano en Tales of Suspense # 57 y más tarde se unió a los Vengadores en The Avengers # 16."
        val hackEye = Hero("Ojo de Halcon", "", descriptionHackEye)
        val descriptionDoctorStrange =
            "Después de sufrir un accidente, un brillante y arrogante cirujano busca rehabilitarse mediante técnicas alternativas. Sus intentos le llevan a descubrir que ha sido designado para encabezar la lucha contra una fuerza oscura y sobrenatural."
        val doctorStrange = Hero("Doctor Strange", "", descriptionDoctorStrange)
        val descriptionCaptainMarvel =
            "Carol Susan Jane Danvers es una superheroína ficticia que aparece en cómics estadounidenses publicados por Marvel Comics. Fue creada por el escritor Roy Thomas y el artista Gene Colan, Danvers apareció por primera vez como oficial de la Fuerza Aérea de los Estados Unidos y colega del superhéroe Kree, Mar-Vell en Marvel Super-HeroesFragment # 13 (marzo de 1968)."
        val captainMarvel = Hero("Capitan Marvel", "", descriptionCaptainMarvel)

        heroes.add(ironMan)
        heroes.add(captainAmerica)
        heroes.add(blackWindow)
        heroes.add(thor)
        heroes.add(bruceBanner)
        heroes.add(spiderMan)
        heroes.add(hackEye)
        heroes.add(doctorStrange)
        heroes.add(captainMarvel)
        return heroes
    }


    fun createDataMovieV1(): List<Movie> {
        val movies = mutableListOf<Movie>()
        val summaryIronMan =
            "Iron Man (titulada Iron Man: el hombre de hierro en Hispanoamérica) es una película de superhéroes. Es la primera entrega del Universo cinematográfico de Marvel. "
        val ironMan = Movie("Iron Man", "", Date(), 1.2, summaryIronMan)
        val summaryCaptainAmerica =
            "Capitán América: El primer vengador (título original en inglés: Captain America: The First Avenger) es una película de superhéroes estadounidense de 2011 basada en el personaje homónimo de Marvel Comics, producida por Marvel Studios y distribuida por Paramount Pictures."
        val captainAmerica = Movie("Capitán América", "", Date(), 1.2, summaryCaptainAmerica)
        val summaryThor =
            "Thor es una película de superhéroes estadounidense de 2011 basada en el personaje homónimo de Marvel Comics, producida por Marvel Studios y distribuida por Paramount Pictures."
        val thor = Movie("Thor", "", Date(), 1.2, summaryThor)
        val summarySpiderMan =
            "Spider-Man: Homecoming (titulada Spider-Man: de regreso a casa en Hispanoamérica) es una película de superhéroes estadounidense de 2017 basada en el personaje de Marvel Comics Spider-Man, co-producida por Columbia Pictures y Marvel Studios, y distribuida por Sony Pictures Releasing."
        val spiderMan = Movie("Spider-Man", "", Date(), 1.2, summarySpiderMan)
        val summaryDoctorStrange =
            "Doctor Strange (titulada Doctor Strange: Hechicero Supremo en Hispanoamérica) es una película de superhéroes estadounidense de 2016 basada en el personaje homónimo de Marvel Comics, producida por Marvel Studios y distribuida por Walt Disney Studios Motion Pictures."
        val doctorStrange = Movie("Doctor Strange", "", Date(), 1.2, summaryDoctorStrange)
        val summaryCaptainMarvel =
            "Capitana Marvel (título original en inglés: Captain Marvel) es una película estadounidense de superhéroes basada en el personaje de Carol Danvers / Capitana Marvel. Producida por Marvel Studios y distribuida por Walt Disney Studios Motion Pictures, es la vigesimoprimera película del Universo cinematográfico de Marvel (MCU, por sus siglas en inglés). "
        val captainMarvel = Movie("Capitana Marvel", "", Date(), 1.2, summaryCaptainMarvel)
        val summaryInfinityWar =
            "Avengers: Infinity War (titulada Vengadores: Infinity War en España) es una película estadounidense de superhéroes de 2018, basada en el equipo de superhéroes de Marvel Comics los Vengadores, producida por Marvel Studios y distribuida por Walt Disney Studios Motion Pictures."
        val infinityWar = Movie("Avengers: Infinity War", "", Date(), 1.2, summaryInfinityWar)
        val summaryEndGame =
            "Avengers: Endgame (Vengadores: Endgame en España) es una película de superhéroes estadounidense de 2019 basada en el grupo los Vengadores de Marvel Comics, producida por Marvel Studios y distribuida por Walt Disney Studios Motion Pictures."
        val endGame = Movie("Avengers: Endgame", "", Date(), 1.2, summaryEndGame)
        movies.add(ironMan)
        movies.add(captainAmerica)
        movies.add(thor)
        movies.add(spiderMan)
        movies.add(doctorStrange)
        movies.add(captainMarvel)
        movies.add(infinityWar)
        movies.add(endGame)
        return movies
    }


}