package com.messageboard.dao.impl;

import com.messageboard.dao.MassageBoardDAO;
import com.messageboard.dean.Message;
import com.messageboard.exception.KeyDuplicateException;
import com.messageboard.factory.MessageBoardDAOFactory;

import java.util.Date;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nicholas on 17-4-20.
 */
public class MessageBoardDaoImplTest {
    public static void main(String args[]) {
        insert();
//        findAll();
    }

    private static void insert() {
        Message message = new Message();
        message.setTitle("测试标题");
        message.setMessage("测试内容");
        message.setFrom("测试留言用户");
        message.setTime(new Date());
        try {
            MassageBoardDAO messageBoard = MessageBoardDAOFactory.getMessageBoardInstance();
            messageBoard.insert(message);
        } catch (SQLException | ClassNotFoundException | KeyDuplicateException e) {
            e.printStackTrace();
        }
    }

    private static void findAll() {
        try {
            MassageBoardDAO   messageBoardDao = MessageBoardDAOFactory.getMessageBoardInstance();
            List              messages        = messageBoardDao.findAll();
            Iterator<Message> messageIterator = messages.iterator();
            Message           message         = null;
            while (messageIterator.hasNext()) {
                message = messageIterator.next();
                System.out.println(message.getId());
                System.out.println(message.getTitle());
                System.out.println(message.getMessage());
                System.out.println(message.getFrom());
                System.out.println(message.getTime());
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
