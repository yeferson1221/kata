package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {

    /**
     * [
     *  Metodo execute() el cual contine una lista movies, me doy cuenta que pueso usar la misma lista agrego el stream
     *  para indicar que usare metodos lamda utilizo el .filter paral filtrar por valor de la peli debe ser = 5.0
     *  imprimo la coleccion  .collect(Collectors.toList());
     * @version [1,0.0]
     *
     * @author [Yeferson Valencia, alejandro.yandd@gmail.com   ]
     * @since [1,0,0]
     *
     */
    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .filter(filtrarpeliculas -> filtrarpeliculas.getRating().equals(5.0))
                .map(filtrarpeliculas -> filtrarpeliculas.getId())
                .collect(Collectors.toList());
    }
}
