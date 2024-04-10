/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kiemtragiuaki;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author ADMIN
 */
public class readFileStudentFromFile extends Thread{
    private List<Student>students;
   @Override
    public void run() {
        try {
            File file = new File("student.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            FileInputStream fis = new FileInputStream(file);
            Document doc = dBuilder.parse(fis);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("student");
            students = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String id = element.getAttribute("id");
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String address = element.getElementsByTagName("address").item(0).getTextContent();
                    String dateOfBirth = element.getElementsByTagName("dateOfBirth").item(0).getTextContent();
                    students.add(new Student(id, name, address, dateOfBirth));
                }
            }
            fis.close();
            System.out.println("Thread 1: Đã đọc thông tin sinh viên từ file student.xml");
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Lỗi khi đọc file student.xml: " + e.getMessage());
        }
    }

    public List<Student> getStudents() {
        return students;
    }
}
