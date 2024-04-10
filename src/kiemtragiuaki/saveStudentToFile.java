/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kiemtragiuaki;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class saveStudentToFile {
    public static void writeStudentsToFile(List<Student> students, String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<students>\n");

            for (Student student : students) {
                writer.write("  <student id=\"" + student.getId() + "\">\n");
                writer.write("    <name>" + student.getName() + "</name>\n");
                writer.write("    <address>" + student.getAddress() + "</address>\n");
                writer.write("    <dateOfBirth>" + student.getDateOfBirht()+ "</dateOfBirth>\n");
                writer.write("  </student>\n");
            }

            writer.write("</students>");
            writer.close();

            System.out.println("Đã lưu thông tin sinh viên vào file " + filename);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}
