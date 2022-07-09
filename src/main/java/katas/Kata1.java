package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.InterestingMoment;
import model.Movie;
import util.DataUtil;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    public static void main(String[] args){new Kata1();}
        public Kata1(){
            Logger log = Logger.getLogger(Kata1.class.getName());
            log.info("mensaje: "+ execute());

        }

    public static List<ImmutableMap<Integer, String>> execute() {
        List<Movie> movies = DataUtil.getMovies();

        List<ImmutableMap<Integer, String>> repelis = movies.stream().map((repeli)
                        -> ImmutableMap.of(repeli.getId(), repeli.getTitle()))
                           .collect(Collectors.toList());
        ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys"));
        return repelis;
    }
}
