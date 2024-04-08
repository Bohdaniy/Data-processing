package Servlet;
import Crud.Lab2CrudInterface;
import Entity.Entity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet1")
public class Servet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ServletConfigInterface servletConfig;
    Lab2CrudInterface lab2Crud;
public Servet1(){
    super();
    this.servletConfig = new ServletConfig();
    this.lab2Crud = servletConfig.getCrud();
}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("[" + lab2Crud.readEntity() + "]");
    }
/**/
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String title = req.getParameter("title");
    int age = Integer.parseInt(req.getParameter("age"));
    float width = Float.parseFloat(req.getParameter("width"));

        lab2Crud.updateEntity(new Entity(title, age, width ));
    }
    /*  Entity entity = new Entity("Entity1", 18,1.81f);
        out.println("["+entity+"]");
    }
*/


}