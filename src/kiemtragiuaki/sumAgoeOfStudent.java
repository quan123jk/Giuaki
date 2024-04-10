/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kiemtragiuaki;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class sumAgoeOfStudent extends Thread{
    private List<Student> students;
    public sumAgoeOfStudent(List<Student> students) {
        this.students = students;
    }
    @Override
    public void run() {
        try {
            for (Student student : students) {
                
               String[] dateParts = student.getDateOfBirht().split("/");
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);
                 LocalDate birthDate = LocalDate.of(year, month, day);
                LocalDate currentDate = LocalDate.now();
                 int age = Period.between(birthDate, currentDate).getYears();
              
                String encodedAge = encodeSHA256(String.valueOf(age));

               
                student.setEncodedAge(encodedAge);
            }
            System.out.println("Thread 2: Đã tính và mã hóa tuổi cho các sinh viên.");
        } catch (Exception e) {
            System.out.println("Lỗi khi tính và mã hóa tuổi: " + e.getMessage());
        }
    }

    private String encodeSHA256(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
        for (byte b : encodedHash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}

