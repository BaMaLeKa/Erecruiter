package com.example.erecruit.controller;

import com.example.erecruit.model.Student;
import com.example.erecruit.pdf.StudentPDFExporter;
import com.example.erecruit.service.StudentService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/**
 * klasa kontroluje połączenia z edpointami naszej aplikacji
 * strona główna,strony z formularzem, pomoc, pobieranie pdf
 */
@Controller
@RequestMapping("/")
public class ApiController {

    private final StudentService studentService;
    private Student student;

    @Autowired
    public ApiController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("index")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/help")
    public String help() {
        return "help";
    }

    @GetMapping("/form")  // sposób na ustawienie listy rozszerzeń/kierunków
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);

        List<String> extensionList = Arrays.asList(
                "Technik_Mechanik",
                "Technik_Elektryk",
                "Technik_Informatyk",
                "Technik_Cukiernik"
        );
        model.addAttribute("extensionList", extensionList);
        return "form";
    }

    @PostMapping("/form") // endpoint (wysyłanie forma)
    public String submitForm(@ModelAttribute("student") Student student) {
        System.out.println(student);
        studentService.addStudentForm(student);
        return "formSuccess";
    }


    @RequestMapping("/formSuccess")
    public String checkForm(/*@ModelAttribute("student") Student student*/ @RequestBody Student student) {
//        studentService.getStudents();
        return "formSuccess";
    }


    @GetMapping("/singleDownload")
    public void exportSingleToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

//      ustala podstawowe info o nazwie pliku
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename= FormularzZgloszeniowy_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

//      wyciąda dane z bazy danych
        List<Student> listStudents = studentService.getStudent();
        StudentPDFExporter exporter = new StudentPDFExporter(listStudents);
        exporter.export(response);
    }
}
