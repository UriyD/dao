package jdbc.pojo;

import java.util.Objects;

public class Group_st {
    private int group_st_id;
    private String group_name;
    private String number_of_students;

    public Group_st() {
    }

    public Group_st(int group_st_id, String group_name, String number_of_students) {
        this.group_st_id = group_st_id;
        this.group_name = group_name;
        this.number_of_students = number_of_students;
    }

    public int getGroup_st_id() {
        return this.group_st_id;
    }

    public void setGroup_st_id(int group_st_id) {
        this.group_st_id = group_st_id;
    }

    public String getGroup_name() {
        return this.group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getNumber_of_students() {
        return this.number_of_students;
    }

    public void setNumber_of_students(String number_of_students) {
        this.number_of_students = number_of_students;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Group_st group_st = (Group_st)o;
            return this.group_st_id == group_st.group_st_id && this.group_name.equals(group_st.group_name) && this.number_of_students.equals(group_st.number_of_students);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.group_st_id, this.group_name, this.number_of_students});
    }

    public String toString() {
        return "Group_st{group_st_id=" + this.group_st_id + ", group_name='" + this.group_name + '\'' + ", number_of_students='" + this.number_of_students + '\'' + '}';
    }
}
