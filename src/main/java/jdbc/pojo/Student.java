package jdbc.pojo;

import java.util.Objects;

public class Student {
    private int student_id;
    private String first_name;
    private String last_name;
    private int group_st_id;

    public Student() {
    }

    public Student(int student_id, String first_name, String last_name, int group_st_id) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        if (group_st_id <= 3 && group_st_id >= 0) {
            this.group_st_id = group_st_id;
        } else {
            System.out.println("Invalid value");
        }

    }

    public int getStudent_id() {
        return this.student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getGroup_st_id() {
        return this.group_st_id;
    }

    public void setGroup_st_id(int group_st_id) {
        if (group_st_id <= 3 && group_st_id >= 0) {
            this.group_st_id = group_st_id;
        } else {
            System.out.println("Invalid value");
        }

    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Student student = (Student)o;
            return this.student_id == student.student_id && this.group_st_id == student.group_st_id && this.first_name.equals(student.first_name) && this.last_name.equals(student.last_name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.student_id, this.first_name, this.last_name, this.group_st_id});
    }

    public String toString() {
        return "Student{student_id=" + this.student_id + ", first_name='" + this.first_name + '\'' + ", last_name='" + this.last_name + '\'' + ", group_st_id=" + this.group_st_id + '}';
    }
}
