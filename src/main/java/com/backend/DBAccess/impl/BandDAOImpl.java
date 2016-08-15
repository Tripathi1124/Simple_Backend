package com.backend.DBAccess.impl;

import com.Model.Register.Band;
import com.backend.DBAccess.BandDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by mankmm on 8/14/16.
 */
public class BandDAOImpl implements BandDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public void insertBand(Band band) {
        String sql = "INSERT INTO band " +
                "(phone, band_name, email, music_genre) VALUES (?, ?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, band.getPhoneNo());
            ps.setString(2, band.getBandName());
            ps.setString(3, band.getEmail());
            ps.setString(4, band.getMusicGenre());
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
}
