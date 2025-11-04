<%@ page import="com.resumebuilder.model.Resume" %>
<%
Resume resume = (Resume) request.getAttribute("resume");
%>
<div style="border:1px solid black; padding:10px;">
  <h2><%= resume.getName() %></h2>
  <p>Email: <%= resume.getEmail() %> | Contact: <%= resume.getContact() %></p>
  <h3>Education</h3><p><%= resume.getEducation() %></p>
  <h3>Experience</h3><p><%= resume.getExperience() %></p>
  <h3>Skills</h3><p><%= resume.getSkills() %></p>
  <h3>Achievements</h3><p><%= resume.getAchievements() %></p>
</div>
