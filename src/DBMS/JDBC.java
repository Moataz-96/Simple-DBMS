package DBMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JDBC {
	
	private Connection Connect;
	private Statement statement;
	private PreparedStatement PreStatement;
	private ResultSet resultSet;
	
	public JDBC(){
		Connect = null;
		statement = null;
		PreStatement = null;
        resultSet = null;
        connection();
	}
	
	private void connection(){
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			if(Connect == null)
			Connect = DriverManager.getConnection("jdbc:mysql://localhost/company?user=root&password=871996");
			statement = Connect.createStatement();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void addField(String fName,String lName,double salary,String dep){
		
	try {
		int insert =1;
		resultSet = statement.executeQuery("select * from employee ");
		while(resultSet.next()){
			if(insert != Integer.parseInt(resultSet.getString("empId")))
		//	insert = Integer.parseInt(resultSet.getString("empId")) + 1;
				break;
			insert++;
			}
		//Connect.prepareStatement("insert into employee (empid,firstname , lastname , salary , dep) values (7,'3zoz','m3zoz',1500,'chem')").executeUpdate();
		Connect.prepareStatement("insert into employee (empid,firstname , lastname , salary , dep) values ("+insert+",'"+
				fName +"','" + lName +"'," + salary +",'" + dep +"')").executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
	public void Modify(int index,String col,String value){
		try {
		switch(col){
		case "firstname":
		statement.executeUpdate("update employee set firstname = '" + value + "' where empid = " + index);
		// el etnen bysawo b3d
	//	Connect.prepareStatement("update employee set firstname = '" + value + "' where empid = " + index ).executeUpdate();
		break;
		case "lastname":
			Connect.prepareStatement("update employee set lastname =  " + value + " where empid = "+index).executeUpdate();
		break;
		case "salary":
			double salary_Value = Double.parseDouble(value);
			Connect.prepareStatement("update employee set salary = " +salary_Value+" where empid ="+index).executeUpdate();
		break;
		case "dep":
			Connect.prepareStatement("update employee set dep =  " + value + " where empid ="+index).executeUpdate();
		break;
		}
		
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
		
	}
	
	public void read(int index){
		try {
			resultSet = statement.executeQuery("select * from employee");
			while(resultSet.next()){
				if(resultSet.getInt("empid") == index){
					query(resultSet);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readAll(){
		try {
			resultSet = statement.executeQuery("select * from employee");
			while(resultSet.next()){
				query(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void query(ResultSet resultSet){

		try {
		String	firstname = resultSet.getString("firstname");
		String lastname = resultSet.getString("lastname");
		String salary = resultSet.getString("salary");
		String dep = resultSet.getString("dep");
		System.out.println("firstname : " + firstname);
		System.out.println("last name : " + lastname);
		System.out.println("salary : " + salary );
		System.out.println("department : " + dep);
		System.out.println("--------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void delete(int index){
		try {
			Connect.prepareStatement("delete from employee where empid ="+index).executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		
	}
	
	public void createTable(String TableName){
		try {
			statement.executeUpdate("drop table if exists " + TableName);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = " create table " + TableName 
				+ " ( personId int primary key, "
				+ "FirstName varchar(20) not null , "
				+ "lastName varchar(20) , "
				+ "number int )";
		
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteTable(String TableName){
		try {
			statement.executeUpdate("drop table if exists " + TableName);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
