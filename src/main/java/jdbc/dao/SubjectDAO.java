package jdbc.dao;

import java.util.List;
import jdbc.pojo.Subject;

public interface SubjectDAO {
    void add(Subject var1);

    List<Subject> getALL();

    Subject getById(int var1);

    void removeById(int var1);

    void updateById(Subject var1);
}

