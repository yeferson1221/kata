package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

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

    /**
     * [
     *  Metodo execute() el cual contine una lista movies  despues creo una lista Inmutable para recorrerla con map
     *  ImmutableMap <Integer, String> recibe entero y un tipo texto, despues de recorrela con repeli la variable creada
     *  para recorrer el map accedo con repeli.getId(), repeli.getTitle() al id y nombre con esto imprimo el listado
     * ]
     * @version [1,0.0]
     *
     * @author [Yeferson Valencia, alejandro.yandd@gmail.com   ]
     * @since [1,0,0]
     *
     */
    public static List<ImmutableMap<Integer, String>> execute() {
        List<Movie> movies = DataUtil.getMovies();

        List<ImmutableMap<Integer, String>> repelis = movies.stream().map((repeli)
                        -> ImmutableMap.of(repeli.getId(), repeli.getTitle()))
                           .collect(Collectors.toList());
        return repelis;
    }
}
