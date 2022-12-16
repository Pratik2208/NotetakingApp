package com.servlets;

import com.entities.Note;
import com.helper.factoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "SaveNotServlet", value = "/SaveNotServlet")
public class SaveNoteServlet extends DeleteServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            Note note = new Note(title,content,new Date());

            // Saving data with hibernate
            Session session = factoryProvider.getFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(note);
            transaction.commit();
            session.close();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1 style='text-align:center;'> Note Added Successfully </h1>");
            out.println("<h1 style='text-align:center;'> <a href='all_notes.jsp'>View All Notes</a> </h1>");


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
