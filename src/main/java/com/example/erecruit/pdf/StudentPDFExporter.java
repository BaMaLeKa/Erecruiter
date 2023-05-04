package com.example.erecruit.pdf;

import com.example.erecruit.model.Student;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentPDFExporter {
    private final List<Student> listStudents;

    public StudentPDFExporter(List<Student> listStudents) {
        this.listStudents = listStudents;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setPadding(10);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);

        cell.setPhrase(new Phrase("Id"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("ID")));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Imię"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("FirstName")));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Nazwisko"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("Surname")));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Data urodzenia"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("BirthDate")));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Miejsce urodzenia"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("BirthPlace")));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Email"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("Email")));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Adres"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("Address")));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Kod pocztowy"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("ZipCode")));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Miejscowość"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("City")));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Województwo"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("Province")));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Imię Opiekuna"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("GuardName")));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Nazwisko Opiekuna"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("GuardSurname")));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Telefon do opiekuna"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("GuardTelephone")));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Email do opiekuna"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("GuardEmail")));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Szkoła pierwszego wyboru?"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("FirstChoice")));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Profil zawodowy"));
        table.addCell(cell);
        cell.setPhrase(new Phrase(getValueFromStudent("Extension")));
        table.addCell(cell);
    }

    //Funkcja, która zwraca konkretne zmienne o które prosimy
    private String getValueFromStudent(String w) {

        for(Student student : listStudents) {
            switch(w) {
                case "ID":
                    return String.valueOf(student.getId());
                case "FirstName":
                    return student.getName();
                case "Surname":
                    return student.getSurname();
                case "BirthDate":
                    return student.getBirthDate();
                case "BirthPlace":
                    return student.getBirthPlace();
                case "Email":
                    return student.getEmail();
                case "Address":
                    return student.getAddress();
                case "Province":
                    return student.getProvince();
                case "ZipCode":
                    return student.getZipcode();
                case "City":
                    return student.getCity();
                case "GuardName":
                    return student.getGuardName();
                case "GuardSurname":
                    return student.getGuardSurname();
                case "GuardTelephone":
                    return student.getGuardTelephone();
                case "GuardEmail":
                    return student.getGuardEmail();
                case "FirstChoice":
                    return String.valueOf(student.getFirstChoice());
                case "Extension":
                    return student.getExtension();
            }
        }

        return null;
    }

    private void writeTableData(PdfPTable table) {
//        wydrukuj wszystkich studentów
        for (Student student : listStudents) {
            table.addCell(String.valueOf(student.getId()));
            table.addCell(student.getName());
            table.addCell(student.getSurname());
            table.addCell(student.getBirthDate());
            table.addCell(student.getBirthPlace());
            table.addCell(student.getEmail());

            table.addCell(student.getAddress());
            table.addCell(student.getCity());
            table.addCell(student.getZipcode());
            table.addCell(student.getProvince());

            table.addCell(student.getGuardName());
            table.addCell(student.getGuardSurname());
            table.addCell(student.getGuardTelephone());
            table.addCell(student.getGuardEmail());

            table.addCell(String.valueOf(student.getFirstChoice()));
            table.addCell(student.getGuardSurname());
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        document.add(new Paragraph("Formularz zgłoszeniowy - rekrutacja 2021/2022"));
//        CREATE TABLE
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);

        writeTableHeader(table);
//        writeTableData(table);

        document.add(table);
        document.close();
    }

}
