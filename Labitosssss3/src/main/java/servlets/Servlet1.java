package servlets;
import jdbc.Connect;
import jdbc.SqlCRUD;

import users.user1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Servlet1/*")
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    LabCRUDInterface<user1> crud = new SqlCRUD();
    Connect connect;
    public void init(ServletConfig config) throws ServletException{
        crud = new SqlCRUD();


    }
    public void destroy() {
        try {
            ((SqlCRUD) crud).getConnection().close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        response.setContentType("application/json");
        response.getWriter().println(crud.read());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        user1 user = Helpers.userParse(req);
        crud.create(user);

        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlHeaders(resp);
        int id = Integer.parseInt(req.getPathInfo().substring(1));

        resp.setContentType("application/json");
        crud.delete(id);
        doGet(req, resp);

    }



    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlHeaders(resp);
        user1 user = Helpers.userParse(req);
        int id = Integer.parseInt(req.getPathInfo().substring(1));
        resp.setContentType("application/json");
        crud.update(id, user);
        doGet(req, resp);
    }

    private void setAccessControlHeaders(HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Access-Control-Allow-Methods","*");
        resp.setHeader("Access-Control-Allow-Headers","*");

    }

}
