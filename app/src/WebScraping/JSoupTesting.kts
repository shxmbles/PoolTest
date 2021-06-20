val wiki = "https://en.wikipedia.org"

fun JSoupTesting() {
    val doc = Jsoup.connect("$wiki/wiki/List_of_films_with_a_100%25_rating_on_Rotten_Tomatoes").get()    // <1>
    doc.select(".wikitable:first-of-type tr td:first-of-type a")    // <2>
            .map { col -> col.attr("href") }    // <3>
            .parallelStream()    // <4>
            .map { extractMovieData(it) }    // <5>
            .filter { it != null }
            .forEach { println(it) }
}
class Movie {
    var title: String? = ""
    var directedBy: String = ""
    var producedBy: String = ""
    var writtenBy: String = ""
    var starring: String = ""
    var musicBy: String = ""
    var releaseDate: String = ""

    override fun toString(): String {
        return "Movie(title='$title')"
    }

}