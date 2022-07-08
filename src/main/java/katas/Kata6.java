package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .map(movie -> movie.getBoxarts())
                .reduce((boxArts, boxArts2) -> {
                    var comparar1 = boxArts.stream().max(Comparator.comparing(BoxArt::getWidth)).orElseThrow();
                    var comparar2 = boxArts2.stream().max(Comparator.comparing(BoxArt::getWidth)).orElseThrow();
                    var compararTotal = comparar1.getWidth() > comparar2.getWidth() ? comparar1 : comparar2;
                    return Arrays.asList(compararTotal);
                }).orElseThrow().stream().map(boxArt -> boxArt.getUrl()).findFirst().orElseThrow();
    }
}
