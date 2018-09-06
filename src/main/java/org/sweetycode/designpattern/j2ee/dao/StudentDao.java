package org.sweetycode.designpattern.j2ee.dao;

import java.util.List;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: 数据访问对象接口（Data Access Object Interface） - 该接口定义了在一个模型对象上要执行的标准操作。
 */
public interface StudentDao {
    public List<Student> getAllStudents();
    public Student getStudent(int rollNo);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);
}
