package com.messageboard.dao;

import com.messageboard.dean.Message;
import com.messageboard.exception.KeyDuplicateException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by nicholas on 17-4-20.
 */
public interface MassageBoardDAO {
    public void insert(Message message) throws SQLException, KeyDuplicateException;

    public List findAll() throws SQLException, ClassNotFoundException;

    public void duplicate(Message message) throws SQLException, KeyDuplicateException;
}
