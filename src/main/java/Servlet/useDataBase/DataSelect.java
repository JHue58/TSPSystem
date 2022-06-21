package Servlet.useDataBase;

import Servlet.util.DBUtil;
import Servlet.util.Data.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DataSelect {

    public static TeacherList select(TeacherList teachers) {


        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("select * ")
                    .append("from t_teacher")
                    .toString();

            stmt = conn.prepareStatement(sql);
            res = stmt.executeQuery();

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            while (res.next()) {
                TeacherData teacher = new TeacherData();
                teacher.setId(res.getInt("id"));
                teacher.setName(res.getString("name"));
                teacher.setSex(res.getBoolean("sex"));
                teacher.setIdcard(res.getString("idcard"));
                teacher.setMajor(res.getString("major"));
                teacher.setBirthday(format.format(res.getDate("birthday")));
                teacher.setEdu(res.getString("edu"));
                teacher.setPassword(res.getString("password"));

                teachers.add(teacher);

            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBUtil.close(conn, stmt);
        }
        return teachers;
    }

    public static TeacherData select(TeacherData teacher) {


        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("select * ")
                    .append("from t_teacher ")
                    .append("where id=?")
                    .toString();

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, teacher.getId());

            res = stmt.executeQuery();

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            if (res.next()) {
                teacher.setId(res.getInt("id"));
                teacher.setName(res.getString("name"));
                teacher.setSex(res.getBoolean("sex"));
                teacher.setIdcard(res.getString("idcard"));
                teacher.setMajor(res.getString("major"));
                teacher.setBirthday(format.format(res.getDate("birthday")));
                teacher.setEdu(res.getString("edu"));
                teacher.setPassword(res.getString("password"));

            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBUtil.close(conn, stmt);
        }
        return teacher;
    }


    public static StudentList select(StudentList students) {


        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("select * ")
                    .append("from t_student")
                    .toString();

            stmt = conn.prepareStatement(sql);
            res = stmt.executeQuery();

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            while (res.next()) {
                StudentData student = new StudentData();
                student.setId(res.getInt("id"));
                student.setName(res.getString("name"));
                student.setSex(res.getBoolean("sex"));
                student.setIdcard(res.getString("idcard"));
                student.setBirthday(format.format(res.getDate("birthday")));
                student.setPassword(res.getString("password"));

                students.add(student);

            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBUtil.close(conn, stmt);
        }
        return students;
    }


    public static StudentData select(StudentData student) {


        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("select * ")
                    .append("from t_student ")
                    .append("where id=?")
                    .toString();

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, student.getId());

            res = stmt.executeQuery();

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            if (res.next()) {
                student.setId(res.getInt("id"));
                student.setName(res.getString("name"));
                student.setSex(res.getBoolean("sex"));
                student.setIdcard(res.getString("idcard"));
                student.setBirthday(format.format(res.getDate("birthday")));
                student.setPassword(res.getString("password"));


            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBUtil.close(conn, stmt);
        }
        return student;
    }


    public static UserList select(UserList users) {


        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("select * ")
                    .append("from t_manager")
                    .toString();

            stmt = conn.prepareStatement(sql);
            res = stmt.executeQuery();


            while (res.next()) {
                User user = new User();
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password"));

                users.add(user);

            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBUtil.close(conn, stmt);
        }
        return users;
    }


    public static User select(User user) {


        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("select * ")
                    .append("from t_manager ")
                    .append("where username=?")
                    .toString();

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, user.getId());

            res = stmt.executeQuery();


            if (res.next()) {

                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password"));


            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBUtil.close(conn, stmt);
        }
        return user;
    }

    public static TopicList select(TopicList topics) {


        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("select * ")
                    .append("from t_topic")
                    .toString();

            stmt = conn.prepareStatement(sql);
            res = stmt.executeQuery();


            while (res.next()) {
                TopicData topic = new TopicData();
                topic.setId(res.getInt("id"));
                topic.setName(res.getString("name"));
                topic.setProperties(res.getString("properties"));
                topic.setSource(res.getString("source"));
                topic.setWorkload(res.getString("workload"));
                topic.setLevel(res.getString("level"));
                topic.setDescription(res.getString("description"));
                topic.setMission(res.getString("mission"));
                topic.setStudent(res.getInt("Student"));

                topics.add(topic);

            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBUtil.close(conn, stmt);
        }
        return topics;
    }

    public static TopicData select(TopicData topic) {


        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("select * ")
                    .append("from t_topic ")
                    .append("where id=?")
                    .toString();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, topic.getId());
            res = stmt.executeQuery();


            if (res.next()) {

                topic.setId(res.getInt("id"));
                topic.setName(res.getString("name"));
                topic.setProperties(res.getString("properties"));
                topic.setSource(res.getString("source"));
                topic.setWorkload(res.getString("workload"));
                topic.setLevel(res.getString("level"));
                topic.setDescription(res.getString("description"));
                topic.setMission(res.getString("mission"));
                topic.setStudent(res.getInt("Student"));


            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBUtil.close(conn, stmt);
        }
        return topic;
    }

    public static TopicData haveTopic(StudentData student) {

        TopicData topic = new TopicData();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("select * ")
                    .append("from t_topic ")
                    .append("where student=? ")
                    .toString();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, student.getId());
            res = stmt.executeQuery();


            if (res.next()) {

                topic.setId(res.getInt("id"));
                topic.setName(res.getString("name"));
                topic.setProperties(res.getString("properties"));
                topic.setSource(res.getString("source"));
                topic.setWorkload(res.getString("workload"));
                topic.setLevel(res.getString("level"));
                topic.setDescription(res.getString("description"));
                topic.setMission(res.getString("mission"));
                topic.setStudent(res.getInt("Student"));
            } else {
                topic = null;
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBUtil.close(conn, stmt);
        }
        return topic;
    }


}
