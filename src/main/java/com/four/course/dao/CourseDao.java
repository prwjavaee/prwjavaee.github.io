package com.four.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.four.course.bean.CourseBean;
import com.four.util.ConnectionPool;

public class CourseDao {
// Query
	public List<CourseBean> findAll() {
		String sql = "SELECT courseId,courseName,courseProfile,c.coachId,coachName  FROM  course c JOIN coach ch ON c.coachId = ch.coachId;";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<CourseBean> courses = new ArrayList<>();
		CourseBean course = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				course = new CourseBean();
				course.setCourseId(rs.getInt("courseId"));
				course.setCourseName(rs.getString("courseName"));
				course.setCourseProfile(rs.getString("courseProfile"));
				course.setCoachId(rs.getInt("coachId"));
				course.setCoachName(rs.getString("coachName"));
				courses.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(conn, stmt, rs);
		}
		return courses;
	}

	public CourseBean findById(String courseId) {
		String sql = "SELECT courseId,courseName,courseProfile,c.coachId,coachName FROM course c JOIN coach ch ON c.coachId = ch.coachId WHERE courseId=?;";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CourseBean course = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, courseId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				course = new CourseBean();
				course.setCourseId(rs.getInt("courseId"));
				course.setCourseName(rs.getString("courseName"));
				course.setCourseProfile(rs.getString("courseProfile"));
				course.setCoachId(rs.getInt("coachId"));
				course.setCoachName(rs.getString("coachName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(conn, stmt, rs);
		}
		return course;
	}
	public List<CourseBean> findByCoachId(String coachId) {
		String sql = "SELECT courseId,courseName,courseProfile,c.coachId,coachName FROM course c JOIN coach ch ON c.coachId = ch.coachId WHERE c.coachId=?;";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CourseBean course = null;
		List<CourseBean> courses = new ArrayList<>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, coachId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				course = new CourseBean();
				course.setCourseId(rs.getInt("courseId"));
				course.setCourseName(rs.getString("courseName"));
				course.setCourseProfile(rs.getString("courseProfile"));
				course.setCoachId(rs.getInt("coachId"));
				course.setCoachName(rs.getString("coachName"));
				courses.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(conn, stmt, rs);
		}
		return courses;
	}

	public List<CourseBean> findByWord(String likeword) {
		String sql = "SELECT courseId,courseName,courseProfile,c.coachId,coachName  FROM  course c JOIN coach ch ON c.coachId = ch.coachId WHERE courseName LIKE ? OR courseProfile LIKE ? OR courseId LIKE ?";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<CourseBean> courses = new ArrayList<>();
		CourseBean course = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + likeword + "%");
			stmt.setString(2, "%" + likeword + "%");
			stmt.setString(3, "%" + likeword + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				course = new CourseBean();
				course.setCourseId(rs.getInt("courseId"));
				course.setCourseName(rs.getString("courseName"));
				course.setCourseProfile(rs.getString("courseProfile"));
				course.setCoachId(rs.getInt("coachId"));
				course.setCoachName(rs.getString("coachName"));
				courses.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(conn, stmt, rs);
		}
		return courses;
	}

//	Insert
	public void insert(CourseBean course) {
		String sql = "INSERT INTO course VALUES (?,?,?)";
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, course.getCourseName());
			stmt.setString(2, course.getCourseProfile());
			stmt.setInt(3, course.getCoachId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(connection, stmt);
		}
	}

//Update
	public void update(CourseBean course) {
		String sql = "UPDATE course SET courseName=?, courseProfile=?, coachId=? WHERE courseId=?;";
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(4, course.getCourseId());
			stmt.setString(1, course.getCourseName());
			stmt.setString(2, course.getCourseProfile());
			stmt.setInt(3, course.getCoachId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(connection, stmt);
		}
	}

//Delete
	public void delete(String courseId) {
		String sql = "DELETE FROM course WHERE courseId = ?;";
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(courseId));
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
