package com.brianvega.ucm_app.models

import com.brianvega.ucm_app.models.hero.Hero
import com.brianvega.ucm_app.models.movie.Movie
import java.util.*

object CreateData {

    fun createDataHeroeV1(): List<Hero> {
        val heroes = mutableListOf<Hero>()
        val descriptionIronMan = "Iron Man —también conocido en español como el Hombre de Hierro— es un superhéroe ficticio que aparece en los cómics estadounidenses publicados por Marvel Comics. El personaje fue co-creado por el escritor y editor Stan Lee, desarrollado por el guionista Larry Lieber y diseñado por los artistas Don Heck y Jack Kirby."
        val ironMan = Hero("Iron Man", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/tonnystarck1.jpeg?alt=media&token=44b8712b-eac3-4e56-959b-1ae2dcf0127f", descriptionIronMan)
        val descriptionCaptainAmerica = "Capitán América cuyo nombre real es Steven Grant Rogers, es un superhéroe ficticio que aparece en los cómics estadounidenses publicados por Marvel."
        val captainAmerica = Hero("Capitan America", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/capitanamerica2.jpg?alt=media&token=c62663f9-a212-4dae-9922-00fcb4902611", descriptionCaptainAmerica)
        val descriptionBlackWindow = "Natalia Alianovna Romanova, coloquial: Viuda Negra es una superheroína ficticia que aparece en el cómic estadounidense y libros publicados por Marvel Comics. Creado por el editor y trazador Stan Lee, el guionista Don Rico y el artista Don Heck, el personaje debutó en Tales of Suspense # 52."
        val blackWindow = Hero("Viuda Negra", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/viudanegra1.jpg?alt=media&token=90ca73c9-1264-48a7-9eb3-adc1c1010fde", descriptionBlackWindow)
        val descriptionThor = "Thor es un superhéroe ficticio que aparece en los cómics estadounidenses publicados por Marvel Comics."
        val thor = Hero("Thor", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/thor2.jpg?alt=media&token=1e076ce5-d21b-4d4e-a1eb-0abfb1905ed8", descriptionThor)
        val descriptionBruceBanner = "Hulk es un personaje ficticio, que aparece en los cómics estadounidenses publicados por la editorial Marvel Comics. El personaje fue creado por los escritores Stan Lee y Jack Kirby siendo su primera aparición en The Incredible Hulk #1 publicado en mayo de 1962."
        val bruceBanner = Hero("Bruce Banner", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/hulk1.jpeg?alt=media&token=ad376352-2499-49f0-b9bf-5dde971863be", descriptionBruceBanner)
        val descriptionSpiderMan = "Spider-Man es un superhéroe ficticio creado por los escritores y editores Stan Lee y Steve Ditko. Apareció por primera vez en el cómic de antología Amazing Fantasy # 15 en la Edad de Plata de los cómics."
        val spiderMan = Hero("Spider Man", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/spiderman1.jpg?alt=media&token=e2735a29-cf6d-42f1-95e7-c243823ce39a", descriptionSpiderMan)
        val descriptionHackEye = "Ojo de Halcón, es un superhéroe de ficción que aparece en los cómics estadounidenses publicados por Marvel Comics. Creado por el escritor Stan Lee y el artista Don Heck, el personaje apareció por primera vez como un villano en Tales of Suspense # 57 y más tarde se unió a los Vengadores en The Avengers # 16."
        val hackEye = Hero("Ojo de Halcon", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/hackeye1.jpg?alt=media&token=f09aa7f9-b920-4091-b9b9-f58c307962d5", descriptionHackEye)
        val descriptionDoctorStrange = "Después de sufrir un accidente, un brillante y arrogante cirujano busca rehabilitarse mediante técnicas alternativas. Sus intentos le llevan a descubrir que ha sido designado para encabezar la lucha contra una fuerza oscura y sobrenatural."
        val doctorStrange = Hero("Doctor Strange", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/doctorstrange1.jpg?alt=media&token=886cf99a-94be-4758-80ae-680c5e5f2bae", descriptionDoctorStrange)
        val descriptionCaptainMarvel = "Carol Susan Jane Danvers es una superheroína ficticia que aparece en cómics estadounidenses publicados por Marvel Comics. Fue creada por el escritor Roy Thomas y el artista Gene Colan, Danvers apareció por primera vez como oficial de la Fuerza Aérea de los Estados Unidos y colega del superhéroe Kree, Mar-Vell en Marvel Super-HeroesFragment # 13 (marzo de 1968)."
        val captainMarvel = Hero("Capitan Marvel", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/captainmarvel1.jpg?alt=media&token=db600f2c-e803-40d7-b784-f22c7f5567ef", descriptionCaptainMarvel)

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
        val ironMan = Movie("Iron Man", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/ironman1.jpg?alt=media&token=233a34bd-5ce9-4908-a6b0-831bd56e54f1", Date(), 1.2, summaryIronMan)
        val summaryCaptainAmerica =
            "Capitán América: El primer vengador (título original en inglés: Captain America: The First Avenger) es una película de superhéroes estadounidense de 2011 basada en el personaje homónimo de Marvel Comics, producida por Marvel Studios y distribuida por Paramount Pictures."
        val captainAmerica = Movie("Capitán América", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/captainamericaposter1.png?alt=media&token=a95a805d-862d-4e0e-9ecb-801e396d52fd", Date(), 1.2, summaryCaptainAmerica)
        val summaryThor =
            "Thor es una película de superhéroes estadounidense de 2011 basada en el personaje homónimo de Marvel Comics, producida por Marvel Studios y distribuida por Paramount Pictures."
        val thor = Movie("Thor", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/thorposter1.jpg?alt=media&token=bff18151-559f-4623-9d77-d934dbb77fcf", Date(), 1.2, summaryThor)
        val summarySpiderMan =
            "Spider-Man: Homecoming (titulada Spider-Man: de regreso a casa en Hispanoamérica) es una película de superhéroes estadounidense de 2017 basada en el personaje de Marvel Comics Spider-Man, co-producida por Columbia Pictures y Marvel Studios, y distribuida por Sony Pictures Releasing."
        val spiderMan = Movie("Spider-Man", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/spidermanposter1.jpg?alt=media&token=1e4f48e0-d7fe-4499-9041-8985f0a7792f", Date(), 1.2, summarySpiderMan)
        val summaryDoctorStrange =
            "Doctor Strange (titulada Doctor Strange: Hechicero Supremo en Hispanoamérica) es una película de superhéroes estadounidense de 2016 basada en el personaje homónimo de Marvel Comics, producida por Marvel Studios y distribuida por Walt Disney Studios Motion Pictures."
        val doctorStrange = Movie("Doctor Strange", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/doctorstrangeposter1.png?alt=media&token=e4c3a3fc-9519-4976-8f34-04b8f07fe64f", Date(), 1.2, summaryDoctorStrange)
        val summaryCaptainMarvel =
            "Capitana Marvel (título original en inglés: Captain Marvel) es una película estadounidense de superhéroes basada en el personaje de Carol Danvers / Capitana Marvel. Producida por Marvel Studios y distribuida por Walt Disney Studios Motion Pictures, es la vigesimoprimera película del Universo cinematográfico de Marvel (MCU, por sus siglas en inglés). "
        val captainMarvel = Movie("Capitana Marvel", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/captainmarvelposter1.jpg?alt=media&token=87e1cad7-7526-4267-9b2b-a93a30895f19", Date(), 1.2, summaryCaptainMarvel)
        val summaryInfinityWar =
            "Avengers: Infinity War (titulada Vengadores: Infinity War en España) es una película estadounidense de superhéroes de 2018, basada en el equipo de superhéroes de Marvel Comics los Vengadores, producida por Marvel Studios y distribuida por Walt Disney Studios Motion Pictures."
        val infinityWar = Movie("Avengers: Infinity War", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/infinitywarposter1.jpg?alt=media&token=cb9ffc3e-b48f-4b5d-937e-0b1d54225197", Date(), 1.2, summaryInfinityWar)
        val summaryEndGame =
            "Avengers: Endgame (Vengadores: Endgame en España) es una película de superhéroes estadounidense de 2019 basada en el grupo los Vengadores de Marvel Comics, producida por Marvel Studios y distribuida por Walt Disney Studios Motion Pictures."
        val endGame = Movie("Avengers: Endgame", "https://firebasestorage.googleapis.com/v0/b/ucmappdev.appspot.com/o/endgameposter1.jpg?alt=media&token=baa7cfca-7192-48b6-9a36-5dd725c7e76e", Date(), 1.2, summaryEndGame)
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