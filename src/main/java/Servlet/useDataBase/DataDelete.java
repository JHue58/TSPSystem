package Servlet.useDataBase;

import Servlet.util.DBUtil;
import Servlet.util.Data.StudentData;
import Servlet.util.Data.TeacherData;
import Servlet.util.Data.TopicData;
import Servlet.util.Data.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataDelete {

    public static Boolean delete(TeacherData teacher) {
        Boolean finish = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("delete from t_teacher ")
                    .append("where id=?")
                    .toString();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, teacher.getId());


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

    public static Boolean delete(StudentData student) {
        Boolean finish = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("delete from t_student ")
                    .append("where id=?")
                    .toString();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, student.getId());


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

    public static Boolean delete(User user) {
        Boolean finish = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("delete from t_manager ")
                    .append("where id=?")
                    .toString();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getId());


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


    public static Boolean delete(TopicData topic) {
        Boolean finish = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = new StringBuffer()
                    .append("delete from t_topic ")
                    .append("where id=?")
                    .toString();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, topic.getId());


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
