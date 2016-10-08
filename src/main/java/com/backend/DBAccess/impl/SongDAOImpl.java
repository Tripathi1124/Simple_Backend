package com.backend.DBAccess.impl;

import com.Model.List.Song;
import com.backend.DBAccess.SongDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by manish on 28/9/16.
 */
public class SongDAOImpl implements SongDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public void insertSong(Song song) {
        String sql = "INSERT INTO song " +
                "(id, name, location) VALUES (?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, song.getId());
            ps.setString(2, song.getName());
            ps.setString(3, song.getLocation());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    @Override
    public Song retreiveSong(Long song_id) {
        String sql = "SELECT * from song where song_id = ?";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, song_id);
            ResultSet rs = ps.executeQuery();
            Song song = new Song();

            while(rs.next()) {
                song.setId(rs.getLong(1));
                song.setName(rs.getString(2));
                song.setLocation(rs.getString(3));
            }

            rs.close();

            return song;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}
