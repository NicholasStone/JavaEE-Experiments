package com.messageboard.factory;

import com.messageboard.dao.MassageBoardDAO;
import com.messageboard.dao.impl.MessageBoardDaoImpl;

import java.sql.SQLException;

/**
 * Created by nicholas on 17-4-20.
 */
public class MessageBoardDAOFactory {
    public static MassageBoardDAO getMessageBoardInstance() throws SQLException, ClassNotFoundException {
        return new MessageBoardDaoImpl();
    }
}
