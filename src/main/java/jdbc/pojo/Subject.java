package jdbc.pojo;

import java.util.Objects;

public class Subject {
    private int subject_id;
    private String subject_name;
    private String lecturer;

    public Subject() {
    }

    public Subject(int subject_id, String subject_name, String lecturer) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.lecturer = lecturer;
    }

    public int getSubject_id() {
        return this.subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return this.subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getLecturer() {
        return this.lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Subject subject = (Subject)o;
            return this.subject_id == subject.subject_id && this.subject_name.equals(subject.subject_name) && this.lecturer.equals(subject.lecturer);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.subject_id, this.subject_name, this.lecturer});
    }

    public String toString() {
        return "Subject{subject_id=" + this.subject_id + ", subject_name='" + this.subject_name + '\'' + ", lecturer='" + this.lecturer + '\'' + '}';
    }
}

