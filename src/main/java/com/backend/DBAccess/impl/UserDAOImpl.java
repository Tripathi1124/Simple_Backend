package com.backend.DBAccess.impl;

import com.backend.DBAccess.UserDAO;
import com.Model.Register.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.text.ParseException;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * UserDAOImpl
 */
public class UserDAOImpl implements UserDAO {

        @Autowired
        private DataSource dataSource;

        @Override
        public void insertUser(User user){

            String sql = "INSERT INTO user " +
                    "(phone, name, email, dob) VALUES (?, ?, ?, ?)";
            Connection conn = null;

            try {
                conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setLong(1, user.getPhoneNo());
                ps.setString(2, user.getName());
                ps.setString(3, user.getEmail());
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = formatter.parse(user.getDob());
                ps.setDate(4, (java.sql.Date) date);
                ps.executeUpdate();
                ps.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);

            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {}
                }
            }
        }
}
