package com.backend.DBAccess;

import com.Model.List.Playlist;

import java.util.List;

/**
 * Created by manish on 1/10/16.
 */
public interface PlaylistDAO {

    void insertPlaylist(Playlist playlist);

    List<Playlist> retrivePlaylist(Long phone);
}
