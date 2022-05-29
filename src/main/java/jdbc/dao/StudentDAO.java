package jdbc.dao;

import java.util.List;
import jdbc.pojo.Student;

public interface StudentDAO {
    void add(Student var1);

    List<Student> getALL();

    Student getById(int var1);

    void removeById(int var1);

    void updateById(Student var1);
}