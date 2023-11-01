package org.rusty.servlet;

import lombok.extern.slf4j.Slf4j;
import org.rusty.service.CourseService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
@Slf4j
public class HomeServlet extends HttpServlet {

    private final CourseService courseService = new CourseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        courseService.init();
        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.write("Добро пожаловать!");
            printWriter.write("\n");
            printWriter.write("Здесь Вы найдёте информацию о курсах!");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}