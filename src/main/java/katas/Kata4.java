package katas;

import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    /**
     * [
     *  Metodo execute() el cual contine una lista movies, aqui se accede a una lista  interna y se toma id
     *  titulo la url de la imagen Map.of accedo con get  a los datos que voy a imprimir que son recorridos con el map
     *  y impresos  .collect(Collectors.toList()
     * @version [1,0.0]
     *
     * @author [Yeferson Valencia, alejandro.yandd@gmail.com   ]
     * @since [1,0,0]
     *
     */
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(movieList -> movieList.getVideos().stream())
                .map(movie -> Map.of(
                                "id", movie.getId(), "title", movie.getTitle(),
                                "boxart", movie.getBoxarts().stream().filter(boxArt -> boxArt.getWidth() == 150 && boxArt.getHeight() == 200).findFirst().orElseThrow()
                        )
                )
                .collect(Collectors.toList());
    }
}
