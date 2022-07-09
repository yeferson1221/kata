package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    /**
     * [
     *  Metodo execute() el cual contine una lista movies, aqui se accede a una lista  y con reduce
     *  busco el rating masl alto donde hago la comparacion peli1 mas peli2
     * @version [1,0.0]
     *
     * @author [Yeferson Valencia, alejandro.yandd@gmail.com   ]
     * @since [1,0,0]
     *
     */
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .reduce((peli1, peli2) -> (peli1.getRating() > peli2.getRating()) ? peli1 : peli2)
                .orElseThrow().getRating();
    }
}
