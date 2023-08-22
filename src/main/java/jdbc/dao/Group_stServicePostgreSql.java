package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.pojo.Group_st;

public class Group_stServicePostgreSql implements Group_stDAO {
    public Group_stServicePostgreSql() {
    }

    public void add(Group_st group) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "INSERT INTO group_st (group_name, numder_of_students) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, group.getGroup_name());
            preparedStatement.setString(2, group.getNumber_of_students());
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

    public List<Group_st> getALL() {
        Connection connection = null;
        Statement statement = null;
        ArrayList group_sts = new ArrayList();

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "SELECT * FROM group_st";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(insert);

            while(resultSet.next()) {
                Group_st group_st = new Group_st();
                group_st.setGroup_st_id(resultSet.getInt("group_st_id"));
                group_st.setGroup_name(resultSet.getString("group_name"));
                group_st.setNumber_of_students(resultSet.getString("numder_of_students"));
                group_sts.add(group_st);
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

        return group_sts;
    }

    public Group_st getById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Group_st group_st = new Group_st();

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "SELECT * FROM group_st WHERE group_st_id = ?";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                group_st.setGroup_name(resultSet.getString("group_st_id"));
                group_st.setGroup_name(resultSet.getString("group_name"));
                group_st.setNumber_of_students(resultSet.getString("numder_of_students"));
            }

            group_st.setGroup_st_id(id);
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

        return group_st;
    }

    public void removeById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "DELETE FROM group_st WHERE group_st_id = ?";
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

    public void updateById(Group_st group_st) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionGet.getConnectionFor();
            String insert = "UPDATE group_st SET group_name = ?, numder_of_students = ? WHERE group_st_id = ?";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, group_st.getGroup_name());
            preparedStatement.setString(2, group_st.getNumber_of_students());
            preparedStatement.setInt(3, group_st.getGroup_st_id());
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