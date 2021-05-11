package presentation;



import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;

public class MenuTable extends JFrame {
  public MenuTable() {
  	getContentPane().setBackground(new Color(240, 255, 255));
  	setBackground(new Color(240, 255, 255));
	 // public void startProject(){
    ArrayList columnNames = new ArrayList();
    ArrayList data = new ArrayList();
    String url = "jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
    String userid = "N01350800";
    String password = "oracle";
    String sql = "SELECT * FROM MENU ORDER BY SR_NO";

    Connection connection;
	try {
		connection = DriverManager.getConnection(url, userid, password);
	
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();
    for (int i = 1; i <= columns; i++) {
      columnNames.add(md.getColumnName(i));
    }
    while (rs.next()) {
      ArrayList row = new ArrayList(columns);
      for (int i = 1; i <= columns; i++) {
        row.add(rs.getObject(i));
      }
      data.add(row);
    }} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    Vector columnNamesVector = new Vector();
    Vector dataVector = new Vector();
    for (int i = 0; i < data.size(); i++) {
      ArrayList subArray = (ArrayList) data.get(i);
      Vector subVector = new Vector();
      for (int j = 0; j < subArray.size(); j++) {
        subVector.add(subArray.get(j));
      }
      dataVector.add(subVector);
    }
    for (int i = 0; i < columnNames.size(); i++)
      columnNamesVector.add(columnNames.get(i));
    getContentPane().setLayout(null);
    JTable table = new JTable(dataVector, columnNamesVector) {
      public Class getColumnClass(int column) {
        for (int row = 0; row < getRowCount(); row++) {
          Object o = getValueAt(row, column);
          if (o != null) {
            return o.getClass();
          }
        }
        return Object.class;
      }
    };
	  
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(44, 11, 334, 204);
    getContentPane().add(scrollPane);
    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(new Color(240, 255, 255));
    buttonPanel.setBounds(0, 251, 434, 10);
    getContentPane().add(buttonPanel);
  }
 
}

