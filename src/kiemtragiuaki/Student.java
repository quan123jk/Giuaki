/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kiemtragiuaki;

/**
 *
 * @author ADMIN
 */
public class Student {
    private String id;
    private String name;
    private String address;
    private String dateOfBirht;
     private String encodedAge;
     private boolean isPrime;
     private String ageAfter;

    public Student() {
    }

    public Student(String id, String name, String address, String dateOfBirht) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirht = dateOfBirht;
    }

    public Student(String id, String ageAfter, boolean isPrime) {
        this.id = id;
        this.ageAfter = ageAfter;
        this.isPrime = isPrime;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirht() {
        return dateOfBirht;
    }

    public void setDateOfBirht(String dateOfBirht) {
        this.dateOfBirht = dateOfBirht;
    }
     public String getEncodedAge() {
        return encodedAge;
    }

    public void setEncodedAge(String encodedAge) {
        this.encodedAge = encodedAge;
    }

    public boolean GetIsPrime() {
        return isPrime;
    }

    public void setIsPrime(boolean isPrime) {
        this.isPrime = isPrime;
    }

    public String getAgeAfter() {
        return ageAfter;
    }

    public void setAgeAfter(String ageAfter) {
        this.ageAfter = ageAfter;
    }
    

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", Age=" + ageAfter + ", isPrime=" + isPrime + '}';
    }
    
}
