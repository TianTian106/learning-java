package org.sweetycode.designpattern.j2ee.dao;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: 数据访问对象模式（Data Access Object Pattern）或 DAO 模式用于把低级的数据访问 API 或操作从高级的业务服务中分离出来。
 */
public class DaoPatternDemo {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();

        for (Student student: studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : " + student.getRollNo()
                    + ", Name : " + student.getName() + " ]");
        }


        Student student = studentDao.getStudent(0);
        student.setName("Michael");
        studentDao.updateStudent(student);
        System.out.println("Student: [RollNo : " + studentDao.getStudent(0).getRollNo()
                + ", Name : " + studentDao.getStudent(0).getName() + " ]");
    }
}
