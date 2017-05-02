package com.messageboard.dao.impl;

import com.messageboard.dao.MassageBoardDAO;
import com.messageboard.database.DatabaseConnection;
import com.messageboard.dean.Message;
import com.messageboard.exception.KeyDuplicateException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicholas on 17-4-20.
 */
public class MessageBoardDaoImpl implements MassageBoardDAO {
    private Connection connection = null;

    public MessageBoardDaoImpl() throws SQLException, ClassNotFoundException {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public void duplicate(Message message) throws SQLException, KeyDuplicateException {
        String            title     = message.getTitle();
        String            sql       = "SELECT `time` FROM `message` WHERE `title` = ? LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, title);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            throw new KeyDuplicateException("主题重复");
        }
    }

    @Override
    public void insert(Message message) throws SQLException, KeyDuplicateException {
        duplicate(message);
        String            sql       = "INSERT INTO `message`(`title`, `message`, `from`, `time`) VALUE(?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, message.getTitle());
        statement.setString(2, message.getMessage());
        statement.setString(3, message.getFrom());
        statement.setString(4, message.getTime());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public List findAll() throws SQLException, ClassNotFoundException {
        List<Message>     allMessage = new ArrayList<>();
        Message           message    = null;
        String            sql        = "SELECT * FROM `message` ORDER BY `time` DESC ";
        PreparedStatement statement  = connection.prepareStatement(sql);
        ResultSet         result     = statement.executeQuery();
        while (result.next()) {
            message = new Message();
            message.setId(result.getInt("id"));
            message.setTitle(result.getString("title"));
            message.setMessage(result.getString("message"));
            message.setFrom(result.getString("from"));
            message.setTime(result.getString("time"));
            allMessage.add(message);
        }
        result.close();
        statement.close();
        return allMessage;
    }
}
