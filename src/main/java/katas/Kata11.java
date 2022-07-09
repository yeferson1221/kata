package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/*
    Goal: Create a datastructure from the given data:

    This time we have 4 seperate arrays each containing lists, videos, boxarts, and bookmarks respectively.
    Each object has a parent id, indicating its parent.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id, title, bookmark time, and smallest boxart url.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber",
                    "time": 32432,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"
                },
                {
                    "id": 675465,
                    "title": "Fracture",
                    "time": 3534543,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/Fracture120.jpg"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard",
                    "time": 645243,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys",
                    "time": 984934,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos(), DataUtil.getBoxArts(), DataUtil.getBookmarkList()
    Output: the given datastructure
*/
public class Kata11 {
    /**
     * [
     *  Metodo execute() el cual contine4 listas donde buscamos en la lista dentro de las listas el array mas pequeño
     *  tanto de nuevas peliculas y trailer depues se imprimen  utilizo map aninado para recorrer cada una de las listas
     *  y con la clase Map.of selecciono con los get y filtro por id para imprimir la lisra que cumple con la condiccion
     * ]
     * @version [1,0.0]
     *
     * @author [Yeferson Valencia, alejandro.yandd@gmail.com   ]
     * @since [1,0,0]
     *
     */
    public static List<Map> execute() {
        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();
        List<Map> boxArts = DataUtil.getBoxArts();
        List<Map> bookmarkList = DataUtil.getBookmarkList();

        return lists.stream()
                .map(listaMusica ->
                        Map.of("name", listaMusica.get("name"),
                                "videos", videos.stream()
                                        .filter(video -> Objects.equals(listaMusica.get("id"), video.get("listId")))
                                        .map(
                                                video -> Map.of("id", video.get("id"),
                                                        "title", video.get("title"),
                                                        "boxart", boxArts.stream()
                                                                .filter(boxArt -> Objects.equals(boxArt.get("videoId"), video.get("id")))
                                                                .map(boxArt -> boxArt.get("url")),
                                                        "time", bookmarkList.stream()
                                                                .filter(bookmark -> Objects.equals(bookmark.get("videoId"), video.get("id")))
                                                                .map(bookmark -> bookmark.get("time"))
                                                )
                                        )
                                        .collect(Collectors.toList())
                        )
                )
                .collect(Collectors.toList());
    }
}
