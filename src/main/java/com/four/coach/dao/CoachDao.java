package com.four.coach.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.four.coach.bean.CoachBean;
import com.four.util.ConnectionPool;

public class CoachDao {
// Query
	public List<CoachBean> findAll() {
		String sql = "SELECT * FROM coach;";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<CoachBean> coachs = new ArrayList<>();
		CoachBean coach = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				coach = new CoachBean();
				coach.setCoachId(rs.getInt("coachId"));
				coach.setCoachName(rs.getString("coachName"));
				coach.setCoachJob(rs.getString("coachJob"));
				coach.setCoachProfile(rs.getString("coachProfile"));
				coach.setCoachPic(rs.getString("coachPic"));
				coachs.add(coach);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(conn, stmt, rs);
		}
		return coachs;
	}

	public CoachBean findById(String coachId) {
		String sql = "SELECT * FROM coach WHERE coachId=?;";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CoachBean coach = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, coachId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				coach = new CoachBean();
				coach.setCoachId(rs.getInt("coachId"));
				coach.setCoachName(rs.getString("coachName"));
				coach.setCoachJob(rs.getString("coachJob"));
				coach.setCoachProfile(rs.getString("coachProfile"));
				coach.setCoachPic(rs.getString("coachPic"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(conn, stmt, rs);
		}
		return coach;
	}

	public List<CoachBean> findByWord(String likeword) {
		String sql = "SELECT * FROM coach WHERE coachName LIKE ? OR coachJob LIKE ? OR coachProfile LIKE ?";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<CoachBean> coachs = new ArrayList<>();
		CoachBean coach = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + likeword + "%");
			stmt.setString(2, "%" + likeword + "%");
			stmt.setString(3, "%" + likeword + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				coach = new CoachBean();
				coach.setCoachId(rs.getInt("coachId"));
				coach.setCoachName(rs.getString("coachName"));
				coach.setCoachJob(rs.getString("coachJob"));
				coach.setCoachProfile(rs.getString("coachProfile"));
				coach.setCoachPic(rs.getString("coachPic"));
				coachs.add(coach);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(conn, stmt, rs);
		}
		return coachs;
	}

//	Insert
	public void insert(CoachBean coach) {
		String sql = "INSERT INTO coach VALUES (?,?,?,?)";
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, coach.getCoachName());
			stmt.setString(2, coach.getCoachJob());
			stmt.setString(3, coach.getCoachProfile());
			stmt.setString(4, coach.getCoachPic());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(connection, stmt);
		}
	}

//Update
	public void update(CoachBean coach) {
		String sql = "UPDATE coach SET coachName=?, coachJob=?, coachProfile=?, coachPic=? WHERE coachId=?;";
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, coach.getCoachName());
			stmt.setString(2, coach.getCoachJob());
			stmt.setString(3, coach.getCoachProfile());
			stmt.setString(4, coach.getCoachPic());
			stmt.setInt(5, coach.getCoachId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(connection, stmt);
		}
	}

//Delete
	public void delete(String coachId) {
		String sql = "DELETE FROM coach WHERE coachId = ?;";
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(coachId));
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
