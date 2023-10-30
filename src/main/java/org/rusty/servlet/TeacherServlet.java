package org.rusty.servlet;

import org.rusty.service.TeacherService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/teachers")
public class TeacherServlet extends HttpServlet {

    private final TeacherService teacherService = new TeacherService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(teacherService.getTeacherList());
        printWriter.close();
    }
}
