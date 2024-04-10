/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kiemtragiuaki;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static kiemtragiuaki.readResultFromFile.readResult;

/**
 *
 * @author ADMIN
 */
public class main {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> listStudent = new ArrayList<>();
        System.out.println("Nhập số lượng sinh viên cần thêm:");
       int n = scanner.nextInt();
       scanner.nextLine();
     
        for (int i = 1; i <= n; i++) {
                System.out.println("Nhập thông tin cho sinh viên thứ " + i);
                System.out.print("ID: ");
                String id = scanner.nextLine();
                System.out.print("Tên: ");
                String name = scanner.nextLine();
                System.out.print("Địa chỉ: ");
                String address = scanner.nextLine();
                System.out.print("Ngày sinh (dd/mm/yyyy): ");
                String dateOfBirth = scanner.nextLine();
                Student student = new Student(id, name, address, dateOfBirth);
                listStudent.add(student);
        }
        saveStudentToFile.writeStudentsToFile(listStudent, "student.xml");
        
        
      readFileStudentFromFile reFileStudent = new readFileStudentFromFile();
      reFileStudent.start();
      try{
          reFileStudent.join();
          List<Student> students = reFileStudent.getStudents();
          
          sumAgoeOfStudent aOfStudent = new sumAgoeOfStudent(students);
            aOfStudent.start();
            
           checkPrime prime = new checkPrime(students);
            prime.start();
         
            saveResult saResult = new saveResult(students, aOfStudent, prime);
            saResult.writeResult();

        List<Student> students1 = readResult("kq.xml");
      for (Student student : students1) {
            System.out.println(student); 
        }
      }
      catch(InterruptedException e){
          e.printStackTrace();
      }
    }
    
}
