package katas;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
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
public class Kata8 {

    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();

        // StreamUtils.zip()

        return StreamUtils.zip(movies.stream(), bookMarks.stream(),
                (movie, bookMark) -> Map.of("videoId", movie.getId(), "bookmarkId", bookMark.getId()))
                .collect(Collectors.toList());
    }
}
