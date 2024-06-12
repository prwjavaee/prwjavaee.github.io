package com.four.schedule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.four.schedule.bean.ScheduleBean;
import com.four.schedule.bean.ScheduleBean2;
import com.four.util.ConnectionPool;

public class ScheduleDao {
// Query
	public List<ScheduleBean> findAll() {
		String sql = "SELECT scheduleId,s.courseId AS courseId,courseName,weekday,daytime FROM schedule s JOIN course c ON s.courseId = c.courseId";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ScheduleBean> schedules = new ArrayList<>();
		ScheduleBean schedule = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				schedule = new ScheduleBean();
				schedule.setScheduleId(rs.getInt("scheduleId"));
				schedule.setWeekday(rs.getString("weekday"));
				schedule.setDaytime(rs.getString("daytime"));
				schedule.setCourseId(rs.getInt("courseId"));
				schedule.setCourseName(rs.getString("courseName"));
				schedules.add(schedule);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(conn, stmt, rs);
		}
		return schedules;
	}

	public List<ScheduleBean> findByCourseId(String courseId) {
		String sql = "SELECT scheduleId,s.courseId AS courseId,courseName,weekday,daytime FROM schedule s JOIN course c ON s.courseId = c.courseId WHERE s.courseId=?;";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ScheduleBean> schedules = new ArrayList<>();
		ScheduleBean schedule = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, courseId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				schedule = new ScheduleBean();
				schedule.setScheduleId(rs.getInt("scheduleId"));
				schedule.setWeekday(rs.getString("weekday"));
				schedule.setDaytime(rs.getString("daytime"));
				schedule.setCourseId(rs.getInt("courseId"));
				schedule.setCourseName(rs.getString("courseName"));
				schedules.add(schedule);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(conn, stmt, rs);
		}
		return schedules;
	}

	public List<ScheduleBean> findByWord(String likeword) {
		String sql = "SELECT * FROM schedule WHERE courseId LIKE ? or weekday LIKE ? or daytime LIKE ?";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ScheduleBean> schedules = new ArrayList<>();
		ScheduleBean schedule = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + likeword + "%");
			stmt.setString(2, "%" + likeword + "%");
			stmt.setString(3, "%" + likeword + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				schedule = new ScheduleBean();
				schedule.setScheduleId(rs.getInt("scheduleId"));
				schedule.setCourseId(rs.getInt("courseId"));
				schedule.setWeekday(rs.getString("weekday"));
				schedule.setDaytime(rs.getString("daytime"));
				schedules.add(schedule);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(conn, stmt, rs);
		}
		return schedules;
	}

//	Insert
	public void insert(ScheduleBean schedule) {
		String sql = "INSERT INTO schedule VALUES (?,?,?)";
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, schedule.getCourseId());
			stmt.setString(2, schedule.getWeekday());
			stmt.setString(3, schedule.getDaytime());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(connection, stmt);
		}
	}

//Update
	public void update(ScheduleBean schedule) {
		String sql = "UPDATE schedule SET courseId=?, weekday=?, daytime=? WHERE scheduleId=?;";
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, schedule.getCourseId());
			stmt.setString(2, schedule.getWeekday());
			stmt.setString(3, schedule.getDaytime());
			stmt.setInt(4, schedule.getScheduleId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(connection, stmt);
		}
	}

//Delete
	public void delete(String scheduleId) {
		String sql = "DELETE FROM schedule WHERE scheduleId = ?;";
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(scheduleId));
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//QueryCourseListById
	public List<ScheduleBean2> findAllGroupByCourseId() {
		String sql = "SELECT c.courseId,c.courseName,STRING_AGG(s.scheduleId, ', ') AS scheduleIds,STRING_AGG(s.weekday, ', ') AS weekdays,STRING_AGG(s.daytime, ', ') AS daytimes,ch.coachId,ch.coachName\r\n"
				+ "FROM course c\r\n"
				+ "JOIN schedule s ON c.courseId = s.courseId JOIN coach ch ON c.coachId = ch.coachId\r\n"
				+ "GROUP BY c.courseId,c.courseName,ch.coachId,ch.coachName;";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ScheduleBean2> schedules = new ArrayList<>();
		ScheduleBean2 schedule = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				schedule = new ScheduleBean2();
				schedule.setScheduleIds(rs.getString("scheduleIds").split(", "));
				schedule.setWeekdays(rs.getString("weekdays").split(", "));
				schedule.setDaytimes(rs.getString("daytimes").split(", "));
				schedule.setCourseId(rs.getString("courseId"));
				schedule.setCourseName(rs.getString("courseName"));
				schedule.setCoachId(rs.getString("coachId"));
				schedule.setCoachName(rs.getString("coachName"));
				schedules.add(schedule);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(conn, stmt, rs);
		}
		return schedules;
	}
}
