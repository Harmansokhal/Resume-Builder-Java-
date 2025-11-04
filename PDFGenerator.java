package com.resumebuilder.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.resumebuilder.model.Resume;

import java.io.FileOutputStream;

public class PDFGenerator {

    public static void generateResumePDF(Resume resume, String filePath) {
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(filePath));
            doc.open();

            Font header = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Font section = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font normal = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

            doc.add(new Paragraph(resume.getName(), header));
            doc.add(new Paragraph(resume.getEmail() + " | " + resume.getContact()));
            doc.add(new LineSeparator());
            doc.add(new Paragraph("\nEducation", section));
            doc.add(new Paragraph(resume.getEducation(), normal));
            doc.add(new Paragraph("\nExperience", section));
            doc.add(new Paragraph(resume.getExperience(), normal));
            doc.add(new Paragraph("\nSkills", section));
            doc.add(new Paragraph(resume.getSkills(), normal));
            doc.add(new Paragraph("\nAchievements", section));
            doc.add(new Paragraph(resume.getAchievements(), normal));
            doc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
