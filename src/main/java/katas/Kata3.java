package katas;

import com.google.common.collect.ImmutableList;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    /**
     * [
     *  Metodo execute() el cual contine una lista movies, en esta solo se debe imprimir el lisatdp de IDS de tipo Integer
     * @version [1,0.0]
     *
     * @author [Yeferson Valencia, alejandro.yandd@gmail.com   ]
     * @since [1,0,0]
     *
     */
    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        return movieLists.stream()
                .map(movie -> movie.getVideos())
                .flatMap(videos -> videos.stream())
                .map(video -> video.getId())
                .collect(Collectors.toList());
    }
}
