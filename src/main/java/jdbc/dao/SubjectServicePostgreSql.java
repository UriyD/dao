package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.pojo.Subject;

public class SubjectServicePostgreSql implements SubjectDAO {
    public SubjectServicePostgreSql() {
    }

    public void add(Subject subject) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "INSERT INTO subject (subject_name, lecturer) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, subject.getSubject_name());
            preparedStatement.setString(2, subject.getLecturer());
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

    public List<Subject> getALL() {
        Connection connection = null;
        Statement statement = null;
        ArrayList subjects = new ArrayList();

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "SELECT * FROM subject";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(insert);

            while(resultSet.next()) {
                Subject subject = new Subject();
                subject.setSubject_id(resultSet.getInt("subject_id"));
                subject.setSubject_name(resultSet.getString("subject_name"));
                subject.setLecturer(resultSet.getString("lecturer"));
                subjects.add(subject);
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

        return subjects;
    }

    public Subject getById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Subject subject = new Subject();

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "SELECT * FROM subject WHERE subject_id = ?";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                subject.setSubject_name(resultSet.getString("subject_name"));
                subject.setLecturer(resultSet.getString("lecturer"));
            }

            subject.setSubject_id(id);
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

        return subject;
    }

    public void removeById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "DELETE FROM subject WHERE subject_id = ?";
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

    public void updateById(Subject subject) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "UPDATE subject SET subject_name = ?, lecturer = ? WHERE subject_id = ?";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, subject.getSubject_name());
            preparedStatement.setString(2, subject.getLecturer());
            preparedStatement.setInt(3, subject.getSubject_id());
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
