package jdbc.dao;

import java.util.List;
import jdbc.pojo.Group_st;

public interface Group_stDAO {
    void add(Group_st var1);

    List<Group_st> getALL();

    Group_st getById(int var1);

    void removeById(int var1);

    void updateById(Group_st var1);
}
