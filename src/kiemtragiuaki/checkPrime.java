/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kiemtragiuaki;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public class checkPrime extends Thread{
    private List<Student> students;
    public checkPrime(List<Student> students) {
        this.students = students;
    }
   
    public void run(){
        try{
            for (Student student : students){
                 String dateOfBirth = student.getDateOfBirht();
                  int sum = sumOfDigit(dateOfBirth);
                  boolean Prime = check(sum);
                  student.setIsPrime(Prime);
            }
            System.out.println("Thread 3: Đã kiểm tra tuổi cho các sinh viên");
        } catch(Exception e){
            System.out.println("Lỗi khi kiểm tra tổng các chữ số: " + e.getMessage());
        }
    }
    public int sumOfDigit(String dateOfBirth){
        int sum = 0;
        for (char c : dateOfBirth.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }
        return sum;
    }
    public boolean check(int n){
        if(n < 2){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0){
                return  false;
            }
        }
        return true;
    }
}
