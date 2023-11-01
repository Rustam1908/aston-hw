package org.rusty.servlet;

import lombok.extern.slf4j.Slf4j;
import org.rusty.service.StudentService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/students")
@Slf4j
public class StudentServlet extends HttpServlet {

    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.write(studentService.getJuniorList());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.write(studentService.saveNewStudent(request));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
