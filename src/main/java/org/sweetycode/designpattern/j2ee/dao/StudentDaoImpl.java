package org.sweetycode.designpattern.j2ee.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: 数据访问对象实体类（Data Access Object concrete class） - 该类实现了上述的接口。该类负责从数据源获取数据，数据源可以是数据库，也可以是 xml，或者是其他的存储机制。
 */
public class StudentDaoImpl implements StudentDao {
    // 列表是当作一个数据库
    List<Student> students;

    public StudentDaoImpl(){
        students = new ArrayList<Student>();
        Student student1 = new Student("Robert",0);
        Student student2 = new Student("John",1);
        students.add(student1);
        students.add(student2);
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudent(int rollNo) {
        return students.get(rollNo);
    }

    @Override
    public void updateStudent(Student student) {
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student: Roll No " + student.getRollNo()
                + ", updated in the database.");
    }

    @Override
    public void deleteStudent(Student student) {
        students.remove(student);
        System.out.println("Student: Roll No " + student.getRollNo()
                + ", deleted from database.");
    }
}
