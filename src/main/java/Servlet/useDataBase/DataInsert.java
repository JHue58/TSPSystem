package Servlet.useDataBase;

import Servlet.util.DBUtil;
import Servlet.util.Data.StudentData;
import Servlet.util.Data.TeacherData;
import Servlet.util.Data.TopicData;
import Servlet.util.Data.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataInsert {
    public static Boolean insert(TeacherData teacher) {
        Boolean finish = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("insert into t_teacher ")
                    .append("(name,sex,idcard,major,birthday,edu,password)")
                    .append(" values ")
                    .append("(?,?,?,?,?,?,?)")
                    .toString();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, teacher.getName());
            stmt.setBoolean(2, teacher.getSex());
            stmt.setString(3, teacher.getIdcard());
            stmt.setString(4, teacher.getMajor());
            stmt.setDate(5, teacher.getBirthday());
            stmt.setString(6, teacher.getEdu());
            stmt.setString(7, teacher.getPassword());

            stmt.executeUpdate();

            conn.commit();


        } catch (SQLException e) {
            e.printStackTrace();
            finish = false;
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            finish = false;
        } finally {
            DBUtil.close(conn, stmt);
        }

        return finish;

    }


    public static Boolean insert(StudentData student) {
        Boolean finish = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("insert into t_student ")
                    .append("(name,sex,idcard,birthday,password)")
                    .append(" values ")
                    .append("(?,?,?,?,?)")
                    .toString();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setBoolean(2, student.getSex());
            stmt.setString(3, student.getIdcard());
            stmt.setDate(4, student.getBirthday());
            stmt.setString(5, student.getPassword());

            stmt.executeUpdate();

            conn.commit();


        } catch (SQLException e) {
            e.printStackTrace();
            finish = false;
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            finish = false;
        } finally {
            DBUtil.close(conn, stmt);
        }
        return finish;

    }

    public static Boolean insert(User user) {
        Boolean finish = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("insert into t_manager ")
                    .append("(username,password)")
                    .append(" values ")
                    .append("(?,?)")
                    .toString();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            stmt.executeUpdate();

            conn.commit();


        } catch (SQLException e) {
            e.printStackTrace();
            finish = false;
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            finish = false;
        } finally {
            DBUtil.close(conn, stmt);
        }
        return finish;

    }

    public static Boolean insert(TopicData topic) {
        Boolean finish = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("insert into t_topic ")
                    .append("(name,properties,source,workload,level,description,mission,Student)")
                    .append(" values ")
                    .append("(?,?,?,?,?,?,?,?)")
                    .toString();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, topic.getName());
            stmt.setString(2, topic.getProperties());
            stmt.setString(3, topic.getSource());
            stmt.setString(4, topic.getWorkload());
            stmt.setString(5, topic.getLevel());
            stmt.setString(6, topic.getDescription());
            stmt.setString(7, topic.getMission());
            stmt.setInt(8, topic.getStudent());

            stmt.executeUpdate();

            conn.commit();


        } catch (SQLException e) {
            e.printStackTrace();
            finish = false;
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            finish = false;
        } finally {
            DBUtil.close(conn, stmt);
        }
        return finish;

    }


}
