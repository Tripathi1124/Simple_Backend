package com.backend.controller;

import com.Model.List.Playlist;
import com.Model.List.Song;
import com.Model.Register.Band;
import com.Model.type.FormType;
import com.backend.DBAccess.BandDAO;
import com.backend.DBAccess.PlaylistDAO;
import com.backend.DBAccess.SongDAO;
import com.backend.DBAccess.UserDAO;
import com.Model.Register.User;

import java.io.*;
import java.lang.String;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletResponse;

@Controller
public class BaseController {

    Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BandDAO bandDAO;

    @Autowired
    private SongDAO songDAO;

    @Autowired
    private PlaylistDAO playlistDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public ModelAndView loginForm() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView registration(FormType formType) {
        if (formType.getType() == 1)
            return new ModelAndView("user");
        else if (formType.getType() == 2)
            return new ModelAndView("band");
        else if (formType.getType() == 3)
            return new ModelAndView("channel");
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(User user) {
        logger.info(String.format("Date of Birth : [%s]", user.getDob()));
        userDAO.insertUser(user);
        return "index";
    }

    @RequestMapping(value = "/addBand", method = RequestMethod.POST)
    public String addBand(Band band) {
        bandDAO.insertBand(band);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("phone") Long phone, ModelMap model) {

        model.addAttribute("phone", phone);
        return "playlist";
    }

    @RequestMapping(value = "/playlist", method = RequestMethod.GET)
    public ModelAndView playlist(@RequestParam("phone") Long phone) {
        ModelAndView model = new ModelAndView("playlist");
        model.addObject(phone);
        return model;
    }

    @RequestMapping(value = "/addPlaylist", method = RequestMethod.GET)
    public String addPlaylist(Playlist playlist, ModelMap model) {
        playlistDAO.insertPlaylist(playlist);
        model.addAttribute("phone", playlist.getPhone());
        return "playlist";
    }

    @RequestMapping(value = "/myPlaylist", method = RequestMethod.GET)
    public ModelAndView getdata(@RequestParam("phone") Long phone) {

        List<Long> list = getPlaylist(phone);

        //return back to index.jsp
        ModelAndView model = new ModelAndView("temp");
        model.addObject("lists", list);

        return model;

    }

    private List<Long> getPlaylist(final Long phone) {
        List<Long> songIds = new ArrayList<>();
        List<Playlist> list = playlistDAO.retrivePlaylist(phone);

        for(Playlist playlist : list) {
            songIds.add(playlist.getSong_id());
        }
        return songIds;
    }

/*    @RequestMapping(value = "/playSong", method = RequestMethod.GET)
    public ModelAndView playSong(Song song) {
        Song song1 = songDAO.retreiveSong(song.getName());
        String location = "\""+ song1.getLocation() + "\"";
        ModelAndView model = new ModelAndView("playlist");
        model.addObject("location", location);
        return model;
    }*/

    @RequestMapping(value = "/playSong", method = RequestMethod.GET)
    @ResponseBody
    public void getPreview2(@RequestParam("song_id") Long song_id, HttpServletResponse response) {
        Song song = songDAO.retreiveSong(song_id);
        String location = song.getLocation();
        File file = new File(location);
        FileInputStream fis;
        byte[] buffer = null;
        try {
            fis = new FileInputStream(file);
            buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.setContentType("audio/mpeg");
        try {
            response.getOutputStream().write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
