package org.rusty.servlet;

import lombok.extern.slf4j.Slf4j;
import org.rusty.service.TeacherService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/teachers")
@Slf4j
public class TeacherServlet extends HttpServlet {

    private final TeacherService teacherService = new TeacherService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.write(teacherService.getTeacherList());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
