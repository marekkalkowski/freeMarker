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

@WebServlet (urlPatterns = "/students")
public class StudentsServlet extends HttpServlet {



    @Inject
    TemplateProvider templateProvider;

    @Inject
    StudentRepository studentRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        for (Student s : studentRepository.getStudents() ) {
//            resp.getWriter().println(s.toString());

        resp.setHeader("Content-Type", "text/html; charset=utf-8");

            Map<String,Object> dataModel = new HashMap<>();

            dataModel.put("students",studentRepository.getStudents());



            Template template = templateProvider.getTemplate(getServletContext(),"students");

            try {
                template.process(dataModel,resp.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }

        }

    }

