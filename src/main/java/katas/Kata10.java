package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/*
    Goal: Create a datastructure from the given data:

    We have 2 arrays each containing lists, and videos respectively.
    Each video has a listId field indicating its parent list.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id and title.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber"
                },
                {
                    "id": 675465,
                    "title": "Fracture"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos()
    Output: the given datastructure
*/
public class Kata10 {
    /**
     * [
     *  Metodo execute() el cual contine una lista nuevas pelis y trailer, despues accedo con un map anidado
     *  a lal ista peliculas que esta dentro de lista  y filtro por id y nombre que tengan el mismo identificador
     *  de listya de peliculas y no del trailer
     * @version [1,0.0]
     *
     * @author [Yeferson Valencia, alejandro.yandd@gmail.com   ]
     * @since [1,0,0]
     *
     */
    public static List<Map> execute() {
        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();
        return lists.stream()
                .map(nombrePeli ->
                        Map.of("name", nombrePeli.get("name"),
                                "videos", videos.stream()
                                        .filter(video -> Objects.equals(nombrePeli.get("id"), video.get("listId")))
                                        .map(video -> Map.of("id", video.get("id"), "title", video.get("title"))
                                        )
                                        .collect(Collectors.toList())
                        )
                )
                .collect(Collectors.toList());
    }
}
