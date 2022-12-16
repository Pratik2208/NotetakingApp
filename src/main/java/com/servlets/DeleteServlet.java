package com.servlets;

import com.entities.Note;
import com.helper.factoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int note_id = Integer.parseInt(request.getParameter("note_id").trim());
            Session session = factoryProvider.getFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Note note = (Note) session.get(Note.class,note_id);
            session.delete(note);
            transaction.commit();
            session.close();
            response.sendRedirect("all_notes.jsp");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
