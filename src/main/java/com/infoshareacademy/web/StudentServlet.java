package com.infoshareacademy.web;

import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.model.Student;
import com.infoshareacademy.repository.StudentRepository;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet (urlPatterns = "/student")
public class StudentServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;

    @Inject
    private StudentRepository studentRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String idStr = req.getParameter("id");
        Integer id = Integer.valueOf(idStr);

        Student student = studentRepository.getById(id);

        Map<String,Object> dataModel = new HashMap<>();
        dataModel.put("student",student);
//        dataModel.put("surname",student.getLastName());
//        dataModel.put("active",student.isActive());


        //resp.getWriter().println(student.toString());


        Template template = templateProvider.getTemplate(getServletContext(),"student");

        try {
            template.process(dataModel,resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
