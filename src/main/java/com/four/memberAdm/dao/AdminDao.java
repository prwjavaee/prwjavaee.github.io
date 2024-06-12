package com.four.memberAdm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.four.memberAdm.bean.AdminBean;
import com.four.memberAdm.bean.MemberBean;
import com.four.util.ConnectionPool;

public class AdminDao {
	
	// sql指令
	String sqlInsert = "insert into member (memName, memEmail, memPassword, gender, birth, phone, nickName) values(?, ?, ?, ?, ?, ?, ?)";
	String sqlGetMem = "select * from member where memNo = ?";
	String sqlGetAllMems = "select * from member where not status = 2";
	String sqlQueryMem = "select * from member where memName LIKE ?";
	String sqlDelete = "delete from member where memNo = ?";
	String sqlBlock = "update member set status = 2 where memNo = ?";
	String sqlUpdate = "update member set memName = ?, memEmail = ?, memPassword = ?, gender = ?, birth = ?, phone = ?, status = ?, nickName = ?, memPic = ? where memNo = ?";
	
	String sqlValidateAdm = "select * from admin where admEmail = ? and admPassword = ?";
	
	
	// 確認是否有帳戶
	public boolean validate(String admEmail, String admPassword) {
        boolean status = false;
        Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sqlValidateAdm);
            stmt.setString(1, admEmail);
            stmt.setString(2, admPassword);
            ResultSet rs = stmt.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			ConnectionPool.closeResource(connection, stmt);
		}
        return status;
    }
	// 註冊
	public boolean register(AdminBean admin) {
        boolean status = false;
        Connection connection = ConnectionPool.getConnection();
		PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)");
            ps.setString(1, admin.getAdmName());
            ps.setString(2, admin.getAdmPassword());
            ps.setString(3, admin.getAdmEmail());
            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			ConnectionPool.closeResource(connection, ps);
		}
        return status;
    }
	
	// 新增
	public void insertMem(MemberBean member) {
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sqlInsert);
			stmt.setString(1, member.getMemName());
			stmt.setString(2, member.getMemEmail());
			stmt.setString(3, member.getMemPassword());
			stmt.setInt(4, member.getGender());
			stmt.setString(5, member.getBirth());
			stmt.setString(6, member.getPhone());
			stmt.setString(7, member.getNickName());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        ConnectionPool.closeResource(connection, stmt);
	    }
	}
	// 查詢一筆
	public MemberBean getMem(String memNo) {
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		MemberBean member = null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement(sqlGetMem);
			stmt.setString(1, memNo);
			rs = stmt.executeQuery();
			member = new MemberBean();
			if(rs.next()) {
				member.setMemNo(rs.getInt("memNo"));
				member.setMemName(rs.getString("memName"));
				member.setMemEmail(rs.getString("memEmail"));
				member.setMemPassword(rs.getString("memPassword"));
				member.setGender(rs.getInt("gender"));
				member.setBirth(rs.getString("birth"));
				member.setAge(rs.getInt("age"));
				member.setPhone(rs.getString("phone"));
				member.setRegDate(rs.getString("regDate"));
				member.setStatus(rs.getInt("status"));
				member.setNickName(rs.getString("nickName"));
				member.setMemPic(rs.getBytes("memPic"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        ConnectionPool.closeResource(connection, stmt, rs);
	    }
		return member;
	}
	// 查詢所有
	public List<MemberBean> getAllMems() {
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<MemberBean> members = null;
		try {
			stmt = connection.prepareStatement(sqlGetAllMems);
			rs = stmt.executeQuery();
			members = new ArrayList<>();
			MemberBean member = null;
			while(rs.next()) {
				member = new MemberBean();
				member.setMemNo(rs.getInt("memNo"));
				member.setMemName(rs.getString("memName"));
				member.setMemEmail(rs.getString("memEmail"));
				member.setGender(rs.getInt("gender"));
				member.setAge(rs.getInt("age"));
				member.setPhone(rs.getString("phone"));
				member.setRegDate(rs.getString("regDate"));
				member.setStatus(rs.getInt("status"));
				members.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        ConnectionPool.closeResource(connection, stmt, rs);
	    }
		return members;
	}
	// 查詢多筆 姓名模糊查詢
	public List<MemberBean> getQueryMem(String memName) {
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<MemberBean> members = null;
		try {
			stmt = connection.prepareStatement(sqlQueryMem);
			stmt.setString(1, "%" + memName + "%");
			rs = stmt.executeQuery();
			members = new ArrayList<>();
			MemberBean member = null;
			while(rs.next()) {
				member = new MemberBean();
				member.setMemNo(rs.getInt("memNo"));
				member.setMemName(rs.getString("memName"));
				member.setMemEmail(rs.getString("memEmail"));
				member.setGender(rs.getInt("gender"));
				member.setAge(rs.getInt("age"));
				member.setPhone(rs.getString("phone"));
				member.setRegDate(rs.getString("regDate"));
				member.setStatus(rs.getInt("status"));
				members.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        ConnectionPool.closeResource(connection, stmt, rs);
	    }
		return members;
	}
	
	// 刪除
	public void deleteEmp(String empno) {
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sqlDelete);
			stmt.setString(1, empno);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        ConnectionPool.closeResource(connection, stmt);
	    }
	}
	// 封鎖
	public void blockMem(String memNo) {
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sqlBlock);
			stmt.setString(1, memNo);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        ConnectionPool.closeResource(connection, stmt);
	    }
	}
	
	// 更新
	public MemberBean updateMem(MemberBean member) {
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
        try {
            // Prepare SQL statement
        	stmt = connection.prepareStatement(sqlUpdate);
        	stmt.setInt(10, member.getMemNo());
			stmt.setString(1, member.getMemName());
			stmt.setString(2, member.getMemEmail());
			stmt.setString(3, member.getMemPassword());
			stmt.setInt(4, member.getGender());
			stmt.setString(5, member.getBirth());
			stmt.setString(6, member.getPhone());
			stmt.setInt(7, member.getStatus());
			stmt.setString(8, member.getNickName());
			stmt.setBytes(9, member.getMemPic());
            stmt.execute();
        } catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(connection, stmt);
	    }
		return member;
	}

}
