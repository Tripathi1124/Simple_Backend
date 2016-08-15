package com.backend.DBAccess.impl;

import com.backend.DBAccess.UserDAO;
import com.Model.Register.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by mankmm on 8/14/16.
 */
public class UserDAOImpl implements UserDAO {

        @Autowired
        private DataSource dataSource;

        @Override
        public void insertUser(User user){

            String sql = "INSERT INTO user " +
                    "(phone, name, email) VALUES (?, ?, ?)";
            Connection conn = null;

            try {
                conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setLong(1, user.getPhoneNo());
                ps.setString(2, user.getName());
                ps.setString(3, user.getEmail());
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
