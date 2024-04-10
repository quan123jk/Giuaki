/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kiemtragiuaki;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author ADMIN
 */
public class readResultFromFile {
    public static List<Student> readResult(String filename){
         List<Student> students = new ArrayList<>();
         File file = new File(filename);
         try{
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("student");
            for (int i = 0; i < nodeList.getLength(); i++){
                 Element studentElement = (Element) nodeList.item(i);
                String id = studentElement.getAttribute("id");
                String encodedAge = studentElement.getElementsByTagName("age").item(0).getTextContent();
                String prime = studentElement.getElementsByTagName("isPrime").item(0).getTextContent();
                boolean isPrime = Boolean.parseBoolean(prime);
                String age = decodeEncodedString(encodedAge);
                
                 students.add(new Student(id, age, isPrime));
            }
            
         } catch(Exception e){
             e.printStackTrace();
         }
           return students;
    }
    public static String decodeEncodedString(String encodedString) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(encodedString.getBytes(StandardCharsets.UTF_8));

         
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

