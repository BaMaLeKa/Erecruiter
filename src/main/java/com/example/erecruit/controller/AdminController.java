package com.example.erecruit.controller;

import com.example.erecruit.db.UserRepository;
import com.example.erecruit.model.Student;
import com.example.erecruit.model.User;
import com.example.erecruit.pdf.StudentPDFExporter;
import com.example.erecruit.service.StudentService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * klasa kontroluje połączenia z edpointami dla admina po zalogowaniu (jeszcze niedostępne-można pominąć)
 */
@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentService studentService;


    // lista studentów
    @GetMapping("/students")
    public List<Student> getStudentList() {
        return studentService.getStudents();
    }


    // lista userów
    @GetMapping("/users")           // to powinno być w /admin/users
    public String listUsers(Model model) {
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    // lista studentów PDF
    @GetMapping("/formDownload")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

//      GET DATA FROM DATABASE
        List<Student> listStudents = studentService.getStudents();
        StudentPDFExporter exporter = new StudentPDFExporter(listStudents);
        exporter.export(response);
    }
}
