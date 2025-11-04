package com.resumebuilder.controller;

import com.resumebuilder.model.Resume;
import com.resumebuilder.util.XMLUtil;
import com.resumebuilder.util.PDFGenerator;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@WebServlet("/ResumeServlet")
public class ResumeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Resume resume = new Resume();
        resume.setName(request.getParameter("name"));
        resume.setEmail(request.getParameter("email"));
        resume.setContact(request.getParameter("contact"));
        resume.setEducation(request.getParameter("education"));
        resume.setExperience(request.getParameter("experience"));
        resume.setSkills(request.getParameter("skills"));
        resume.setAchievements(request.getParameter("achievements"));
        resume.setTemplate(request.getParameter("template"));

        String xmlPath = getServletContext().getRealPath("/WEB-INF/resume_data.xml");
        String pdfPath = getServletContext().getRealPath("/WEB-INF/resume.pdf");

        XMLUtil.saveResumeToXML(resume, xmlPath);
        PDFGenerator.generateResumePDF(resume, pdfPath);

        request.setAttribute("resume", resume);
        request.getRequestDispatcher("preview.jsp").forward(request, response);
    }
}
