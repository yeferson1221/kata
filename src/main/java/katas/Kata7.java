package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    /**
     * [
     *  Metodo execute() el cual contine una lista movies, aqui se accede a una lista  se debe imprimir
     *  lista de pelis con su  imagen  id nombre o titulo uso el flatMap
     * @version [1,0.0]
     *
     * @author [Yeferson Valencia, alejandro.yandd@gmail.com   ]
     * @since [1,0,0]
     *
     */
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(listaPeliculas -> listaPeliculas.getVideos().stream())
                .map(listaPelicula -> Map.of("id", listaPelicula.getId(), "title", listaPelicula.getTitle(),
                                                "boxart", listaPelicula.getBoxarts().stream().min(Comparator.comparing(boxArt
                                                      -> boxArt.getUrl().length())).orElseThrow().getUrl())
                )
                .collect(Collectors.toList());
    }
}
