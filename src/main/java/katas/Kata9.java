package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    /**
     * [
     *  Metodo execute() el cual contine una lista movies,y la lista de Bookmark  saco el id  de cada uno
     *  utulizo un Map of para celeccionarlos "videoId", movie.getId(), "bookmarkId", bookMark.getId()
     *  y los imprimo en un coleccion .collect(Collectors.toList());
     * @version [1,0.0]
     *
     * @author [Yeferson Valencia, alejandro.yandd@gmail.com   ]
     * @since [1,0,0]
     *
     */
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(listaPeli -> listaPeli.getVideos().stream())
                .map(listaPelicula -> Map.of(
                                "id", listaPelicula.getId(), "title", listaPelicula.getTitle(), "time", listaPelicula.getInterestingMoments().stream()
                                        .flatMap(interestingMoment -> Stream.of(interestingMoment.getTime()))
                                        .mapToLong(Date::getTime)
                                        .average()
                                        .stream().mapToObj(prom -> new Date((long) prom)), "boxart", listaPelicula.getBoxarts()
                                        .stream()
                                        .min(Comparator.comparing(boxArt -> boxArt.getUrl().length()))
                                        .orElseThrow().getUrl()
                        )
                )
                .collect(Collectors.toList());
    }
}
