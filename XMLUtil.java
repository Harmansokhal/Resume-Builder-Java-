package com.resumebuilder.util;

import com.resumebuilder.model.Resume;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLUtil {

    public static void saveResumeToXML(Resume resume, String filePath) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element root = doc.createElement("Resume");
            doc.appendChild(root);

            root.appendChild(createElement(doc, "Name", resume.getName()));
            root.appendChild(createElement(doc, "Email", resume.getEmail()));
            root.appendChild(createElement(doc, "Contact", resume.getContact()));
            root.appendChild(createElement(doc, "Education", resume.getEducation()));
            root.appendChild(createElement(doc, "Experience", resume.getExperience()));
            root.appendChild(createElement(doc, "Skills", resume.getSkills()));
            root.appendChild(createElement(doc, "Achievements", resume.getAchievements()));
            root.appendChild(createElement(doc, "Template", resume.getTemplate()));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));

            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Element createElement(Document doc, String tag, String value) {
        Element el = doc.createElement(tag);
        el.appendChild(doc.createTextNode(value));
        return el;
    }
}
