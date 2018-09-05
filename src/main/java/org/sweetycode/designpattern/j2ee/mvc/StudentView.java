package org.sweetycode.designpattern.j2ee.mvc;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/5
 * @Description:
 */
public class StudentView {
    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}
