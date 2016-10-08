package com.backend.DBAccess;

import com.Model.List.Song;

/**
 * Created by manish on 28/9/16.
 */
public interface SongDAO {
    void insertSong(Song song);

    Song retreiveSong(Long song_id);
}
