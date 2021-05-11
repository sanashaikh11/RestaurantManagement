package data;
 import java.sql.*;

import business.CProgram;

public class DBAccess1 {
	protected Connection conn=null;
	protected ResultSet rs=null;
	protected Statement stm=null;
	
	public DBAccess1() throws SQLException,ClassNotFoundException{
	this.connect();
	}
	
	protected void connect() throws SQLException,ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url ="jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
		String username = "N01350347";
		String password = "oracle";
		conn = DriverManager.getConnection(url,username,password);
		String sql = "Select * From PRG";
		stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs = stm.executeQuery(sql);
	}
	public void disconnect() throws SQLException{
		if (!rs.isClosed()) {
			rs.close();
			conn.close();
		}
	}
	
	public void refresh() throws SQLException{
		String sql = "Select * From PRG";
		stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs = stm.executeQuery(sql);
		rs.first();
	}
	
	public int addProgram(CProgram program) throws SQLException{
				
		int count=0;
		String query = "Insert into PRG values (?, ?, ?, ?)"; 
	     System.out.println(query);

		PreparedStatement preparedStmt = conn.prepareStatement(query);
	     preparedStmt.setInt(1, program.getpID());
	     preparedStmt.setString(2, program.getpName());
	     preparedStmt.setInt(3, program.getpPhn());
	     preparedStmt.setString(4, program.getpPos());
	     System.out.println(query);

	     preparedStmt.execute();
	     this.refresh();
		return count;
	}
	public int deleteProgram(String pID) throws SQLException{
		int count=0;
		String sql = "delete from PRG where id = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
	    pst.setString(1, pID);
		pst.execute();
		this.refresh();
		return count;
	}
	public int updateProgram(CProgram program) throws Exception{
		int count=0;
			 String query = "update PRG set NAME=?, PHN=?, POS=? where ID=?";
		     PreparedStatement preparedStmt = conn.prepareStatement(query);
		     preparedStmt.setString(1, program.getpName());
		    
		     preparedStmt.setInt(2, program.getpPhn());
		     preparedStmt.setString(3, program.getpPos());
		     preparedStmt.setInt(4, program.getpID());
		     preparedStmt.execute();
		     this.refresh();
		     return count;
			
		}
	
	public CProgram getNext() throws SQLException{
		CProgram program=null;
		if(rs!=null) {
			if (!rs.isLast()) {
				rs.next();
				program=this.getProgram();
			}
		}
		return program;
	}
	public CProgram getPrevious() throws SQLException{
		CProgram program=null;
		if(rs!=null) {
			if (!rs.isFirst()) {
				rs.previous();
				program=this.getProgram();
			}
		}
		return program;
	}
	public CProgram getLast() throws SQLException{
		CProgram program=null;
		if(rs!=null) {
				rs.last();
				program=this.getProgram();
		}
		return program;
	} 
	public CProgram getFirst() throws SQLException{
		CProgram program=null;
		if(rs!=null) {
				rs.first();
				program=this.getProgram();
		}
		return program;
	}
	protected CProgram getProgram() throws SQLException{
		CProgram program=null;
		if(rs!=null) {
			program=new CProgram();
			program.setpID(rs.getInt("ID"));
			program.setpName(rs.getString("Name"));
			program.setpPhn(rs.getInt("PHN"));
			program.setpPos(rs.getString("POS"));
			
		}
		return program;
			
	}
}