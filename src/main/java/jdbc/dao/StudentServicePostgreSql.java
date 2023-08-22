package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.pojo.Student;

public class StudentServicePostgreSql implements StudentDAO {
    public StudentServicePostgreSql() {
    }

    public void add(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "INSERT INTO student (first_name, last_name, group_st_id) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, student.getFirst_name());
            preparedStatement.setString(2, student.getLast_name());
            preparedStatement.setInt(3, student.getGroup_st_id());
            preparedStatement.executeUpdate();
        } catch (SQLException var17) {
            System.out.println("Connection Failed");
            var17.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException var16) {
                    var16.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException var15) {
                    var15.printStackTrace();
                }
            }

        }

    }

    public List<Student> getALL() {
        Connection connection = null;
        Statement statement = null;
        ArrayList students = new ArrayList();

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "SELECT * FROM student";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(insert);

            while(resultSet.next()) {
                Student student = new Student();
                student.setStudent_id(resultSet.getInt("student_id"));
                student.setFirst_name(resultSet.getString("first_name"));
                student.setLast_name(resultSet.getString("last_name"));
                student.setGroup_st_id(resultSet.getInt("group_st_id"));
                students.add(student);
            }
        } catch (SQLException var19) {
            System.out.println("Connection failed");
            var19.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException var18) {
                    var18.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException var17) {
                    var17.printStackTrace();
                }
            }

        }

        return students;
    }

    public Student getById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Student student = new Student();

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "SELECT * FROM student WHERE student_id = ?";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                student.setFirst_name(resultSet.getString("first_name"));
                student.setLast_name(resultSet.getString("last_name"));
                student.setGroup_st_id(resultSet.getInt("group_st_id"));
            }

            student.setStudent_id(id);
        } catch (SQLException var19) {
            System.out.println("Connection failed");
            var19.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException var18) {
                    var18.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException var17) {
                    var17.printStackTrace();
                }
            }

        }

        return student;
    }

    public void removeById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "DELETE FROM student WHERE student_id = ?";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException var17) {
            System.out.println("Connection failed");
            var17.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException var16) {
                    var16.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException var15) {
                    var15.printStackTrace();
                }
            }

        }

    }

    public void updateById(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "UPDATE student SET first_name = ?, last_name = ?, group_st_id = ? WHERE student_id = ?";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, student.getFirst_name());
            preparedStatement.setString(2, student.getLast_name());
            preparedStatement.setInt(3, student.getGroup_st_id());
            preparedStatement.setInt(4, student.getStudent_id());
            preparedStatement.executeUpdate();
        } catch (SQLException var17) {
            System.out.println("Connection failed");
            var17.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException var16) {
                    var16.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException var15) {
                    var15.printStackTrace();
                }
            }

        }

    }
}