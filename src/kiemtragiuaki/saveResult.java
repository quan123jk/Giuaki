/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kiemtragiuaki;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class saveResult {
    private List<Student> students;
    private Thread threads2;
    private Thread threads3;

    public saveResult(List<Student> students, Thread threads2, Thread threads3) {
        this.students = students;
        this.threads2 = threads2;
        this.threads3 = threads3;
    }

    public void writeResult() {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("kq.xml"))) {
            try {
                threads2.join();
                  threads3.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(saveResult.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            // Ghi thông tin của mỗi sinh viên vào tệp XML
            writer.write("<students>\n");
            for (Student student : students) {
                 writer.write("  <student id=\"" + student.getId() + "\">\n");
                writer.write("    <age>" + student.getEncodedAge() + "</age>\n");
                writer.write("    <isPrime>" + student.GetIsPrime()+ "</isPrime>\n");
                writer.write("  </student>\n");
            }
            writer.write("</students>\n");

            System.out.println("File kq.xml đã được tạo thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi tệp kq.xml: " + e.getMessage());
        }
    }
}
