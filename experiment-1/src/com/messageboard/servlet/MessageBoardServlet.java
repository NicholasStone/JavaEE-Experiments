package com.messageboard.servlet;

import com.messageboard.dao.MassageBoardDAO;
import com.messageboard.dean.Message;
import com.messageboard.exception.KeyDuplicateException;
import com.messageboard.exception.KeyEmptyException;
import com.messageboard.factory.MessageBoardDAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;

/**
 * Created by nicholas on 17-4-20.
 */
@WebServlet(name = "MessageBoardServlet")
public class MessageBoardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String from  = request.getParameter("from");
        String text  = request.getParameter("message");
        try {
            if (title == null || title.equals("")) {
                throw new KeyEmptyException("主题", "title");
            }
            if (from == null || from.equals("")) {
                throw new KeyEmptyException("发布人", "from");
            }
            if (text == null || text.equals("")) {
                throw new KeyEmptyException("内容", "text");
            }
            Message message = new Message();
            message.setTitle(title);
            message.setMessage(text);
            message.setFrom(from);
            MassageBoardDAO board = MessageBoardDAOFactory.getMessageBoardInstance();
            board.insert(message);
            response.sendRedirect("/");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (KeyEmptyException e) {
            request.setAttribute("err_" + e.getKey(), e.getMessage());
            request.getRequestDispatcher("/").forward(request, response);
        } catch (KeyDuplicateException e) {
            request.setAttribute("err_title", e.getMessage());
            request.getRequestDispatcher("/").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}
