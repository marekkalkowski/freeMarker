package com.infoshareacademy.web;

import com.infoshareacademy.freemarker.TemplateProvider;
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

@WebServlet (urlPatterns = "/Welcome")
public class WelcomeServlet extends HttpServlet {

    private Map<String, Object> dataModel = new HashMap<>();

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        dataModel.put("name","Marek");
        dataModel.put("surname","Kalkowski");

        Template template = templateProvider.getTemplate(getServletContext(),"welcome-user");

        try {
            template.process(dataModel,resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}


