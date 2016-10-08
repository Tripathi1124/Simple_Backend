package com.backend.DBAccess.impl;

import com.Model.List.Playlist;
import com.Model.List.Song;
import com.backend.DBAccess.PlaylistDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manish on 1/10/16.
 */
public class PlaylistDAOImpl implements PlaylistDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public void insertPlaylist(Playlist playlist) {
        String sql = "INSERT INTO playlist " +
                "(phone, song_id) VALUES (?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, playlist.getPhone());
            ps.setLong(2, playlist.getSong_id());
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
    public List<Playlist> retrivePlaylist(Long phone) {
        String sql = "SELECT * from playlist where phone = ?";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, phone);
            ResultSet rs = ps.executeQuery();

            List<Playlist> list = new ArrayList<>();

            Integer i = 0;
            while(rs.next()) {
                Playlist playlist = new Playlist();
                playlist.setPhone(rs.getLong(1));
                playlist.setSong_id(rs.getLong(2));
                list.add(i, playlist);
                i++;
            }

            rs.close();

            return list;
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
