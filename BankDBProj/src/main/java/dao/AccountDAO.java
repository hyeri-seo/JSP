package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Account;

public class AccountDAO {
	public void insertAccount(Account acc) {
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into account values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getId());
			pstmt.setString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			pstmt.setString(4, acc.getType());
			pstmt.setString(5, acc.getGrade());
			pstmt.executeQuery();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		JdbcUtil.close(conn);
	}
	public Account selectAccount(String id) {
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account acc = null;
		String sql = "select * from account where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				acc = new Account();
				acc.setId(rs.getString("id"));
				acc.setName(rs.getString("name"));
				acc.setBalance(rs.getInt("balance"));
				acc.setType(rs.getString("type"));
				acc.setGrade(rs.getString("grade"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		JdbcUtil.close(conn);
		return acc;
	}
	 public List<Account> selectAllAccounts() {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        List<Account> accountList = new ArrayList<>();

	        try {
	            conn = JdbcUtil.getConnection();
	            String sql = "SELECT * FROM Account"; // 모든 계좌 정보를 가져오는 SQL 쿼리
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();

	            while (rs.next()) {
	                Account account = new Account();
	                account.setId(rs.getString("id"));
	                account.setName(rs.getString("name"));
	                account.setBalance(rs.getInt("balance"));
	                account.setType(rs.getString("type"));
	                account.setGrade(rs.getString("grade"));
	                accountList.add(account);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            // SQLException 처리를 할 수 있음
	        } finally {
	            JdbcUtil.close(conn);
	        }
	        return accountList;
	    }
	public void updateAccount(Account acc) {
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update Account set balance=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acc.getBalance());
			pstmt.setString(2, acc.getId());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		JdbcUtil.close(conn);
	}


}
