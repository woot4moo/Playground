package com.example.servlet;

import com.example.ejb.RecordDAO;
import com.example.ejb.TextDAO;
import com.example.model.jpa.Record;
import com.example.model.jpa.Text;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Servlet for dynamic interactions.
 */
@WebServlet(name="DynamicServlet",urlPatterns={"/dynamic"})
public class DynamicServlet extends HttpServlet {

    @EJB
    private TextDAO textDAO;
    @EJB
    private RecordDAO recordDAO;

    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Display the list of guests:
        request.setAttribute("guests", textDAO.getAllText());
        request.getRequestDispatcher("/guest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Handle a new guest:
        String name = request.getParameter("name");
        if (name != null) {
            Record record = new Record();
            record.setRecordId(UUID.randomUUID().toString());
            recordDAO.persist(record);
            Text toPersist = new Text();
            toPersist.setValue(name);
            toPersist.setKey("servlet");
            toPersist.setTextId(UUID.randomUUID().toString());
            toPersist.setPosition(1);
            toPersist.setRecordId(record.getRecordId());
            textDAO.persist(toPersist);
        }
        // Display the list of guests:
        doGet(request, response);
    }}
