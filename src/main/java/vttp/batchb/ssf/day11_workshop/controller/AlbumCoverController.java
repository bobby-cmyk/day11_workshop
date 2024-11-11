package vttp.batchb.ssf.day11_workshop.controller;

import java.io.File;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path={"/", "/index.html"})
public class AlbumCoverController {

    @GetMapping()
    public String getIndex(Model model) {
        
        model.addAttribute("albumCoverPath", "/albumcover/" + getAlbumCoverOfTheDay());

        return "album_cover_of_the_day";
    }

    private String getAlbumCoverOfTheDay() {

        File albumCoverFolder = new File("src/main/resources/static/albumcover");

        File[] albumCovers = albumCoverFolder.listFiles();

        Random rand = new Random();

        int randomAlbumCover = rand.nextInt(albumCovers.length);

        String albumCoverPath = albumCovers[randomAlbumCover].getName();

        return albumCoverPath;
    }
}
