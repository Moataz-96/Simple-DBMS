package DBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBConnection {
	private Connection Connect;
	private Statement statement;
	private PreparedStatement PreStatement;
	private ResultSet resultSet;
	private String Name;
    Scanner scan = new Scanner(System.in);
    
	public JDBConnection(){
		Connect = null;
		statement = null;
		PreStatement = null;
		resultSet = null;
		Connection();
	}
	private void Connection(){
		
		System.out.println("Enter Your Database");
		String DatabaseName = scan.nextLine();
		System.out.println("Enter Your Username");
		String username = scan.nextLine();
		System.out.println("Enter Your Password");
		String password = scan.nextLine();
		String url = "jdbc:mysql://localhost/"+DatabaseName;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if(Connect == null){
				try {
					Connect = DriverManager.getConnection(url,username,password);
					statement = Connect.createStatement();
				}
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Database not found");
					e.printStackTrace();
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		public void AddField(){
			String sql ,DataType;
			int i ;
			System.out.print("Enter Table Name");
			String TableName = scan.nextLine();
			try {
				
				resultSet = statement.executeQuery("select * from "+TableName);
				int count = resultSet.getMetaData().getColumnCount();
			
				sql = "insert into "+ TableName + " ( ";
				for(i =1 ; i<count ; i++){
					sql += resultSet.getMetaData().getColumnLabel(i) + " , ";
				}
				
				sql += resultSet.getMetaData().getColumnLabel(i) + " ) values ( ";
				
				for(i =1 ; i<count ; i++){
					DataType =resultSet.getMetaData().getColumnTypeName(i);
					System.out.print("Enter " + resultSet.getMetaData().getColumnLabel(i) + " : ");
					if(DataType.equalsIgnoreCase("VARCHAR"))
					sql += "'" + scan.nextLine() + "' , ";
					else 
					sql += scan.nextLine() + " , ";
					
					}
				
				DataType =resultSet.getMetaData().getColumnTypeName(i);
				System.out.print("Enter " + resultSet.getMetaData().getColumnLabel(i) + " : ");
				if(DataType.equalsIgnoreCase("VARCHAR"))
				sql += "'" +scan.nextLine() + "' ) ";
				else 
				sql += scan.nextLine() + " ) ";
				
				statement.executeUpdate(sql);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.err.println("\n\nFailed to Create Field , Please Try Again !!\n\n\n");
				return;
			}
			System.out.println("\n\nField has been added Succefully\n");
		}
		
		
		public void deleteField(){
			String TableName = Name;
			
			String sql,DataType;
			int x=1;
			System.out.println("Enter Number of Field You wanna delete : ");
			int del = scan.nextInt();
			try {
				
				resultSet = statement.executeQuery("select * from "+ TableName);
				int count = resultSet.getMetaData().getColumnCount();
				
				sql  = "delete from " + TableName + " where "  ;
				while(resultSet.next()){
					if(x == del){
				for(int i =1; i<=count ; i++){
					DataType =resultSet.getMetaData().getColumnTypeName(i);
				if(i<count){
					if(DataType.equalsIgnoreCase("VARCHAR"))
					sql += resultSet.getMetaData().getColumnName(i) + " = '" + resultSet.getString(i) + "' and ";
					else
					sql += resultSet.getMetaData().getColumnName(i) + " = " + resultSet.getString(i) + " and ";	
					}
				if(i == count){
						if(DataType.equalsIgnoreCase("VARCHAR")){
						sql += resultSet.getMetaData().getColumnName(i) + " = '" + resultSet.getString(i) + "' " ;}
						else{
						sql += resultSet.getMetaData().getColumnName(i) + " = " + resultSet.getString(i) ;	}
						}}
				
				statement.executeUpdate(sql);
				return ;
				}
				x++;
				} 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
		public void Modify(){
			try{
			String DataType;
			
				System.out.print("Enter Table Name");
			 String TableName = scan.nextLine();
			System.out.print("Enter Number of Field :");
			int z = new Scanner(System.in).nextInt();
			System.out.print("Enter Column Name :");
			String ColName = new Scanner(System.in).nextLine();
			
			System.out.print("Enter Your Value :");
			String Value = new Scanner(System.in).nextLine();
			int x =1;
			resultSet = statement.executeQuery("select * from "+ TableName);
			int count = resultSet.getMetaData().getColumnCount();
			String sql = "update "+TableName+ " set ";
			
			int checkvalidate=0;
					
				
				
					while(resultSet.next()){
						if(x == z){
					for(int i =1; i<=count ; i++){
						DataType =resultSet.getMetaData().getColumnTypeName(i);
						
					if(i<count){
						if(DataType.equalsIgnoreCase("VARCHAR")){
							if(checkvalidate == 0){
								sql +=  ColName + " =  '" + Value + "' where " ;
								checkvalidate = 10;
							}
						
						sql += resultSet.getMetaData().getColumnName(i) + " = '" + resultSet.getString(i) + "' and ";}
						else{
							if(checkvalidate == 0){
								sql +=  ColName + " =  " + Value + " where " ;
								checkvalidate = 10;
							}
						sql += resultSet.getMetaData().getColumnName(i) + " = " + resultSet.getString(i) + " and ";	}
						}
					if(i == count){
							if(DataType.equalsIgnoreCase("VARCHAR")){
							sql += resultSet.getMetaData().getColumnName(i) + " = '" + resultSet.getString(i) + "' " ;}
							else{
							sql += resultSet.getMetaData().getColumnName(i) + " = " + resultSet.getString(i) ;	}
							}}
					
					statement.executeUpdate(sql);
					return ;
					}
						x++;}
			
			
			
		} catch(SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
			
			
		}
	  
	public void readALL(){
		int fieldnum=1;
		
		System.out.print("Enter Table Name");
		 String TableName = scan.nextLine();
		 
	Name = TableName;
		
		
		try {
			resultSet = statement.executeQuery("select * from "+ TableName);
			
			int count = resultSet.getMetaData().getColumnCount();
			
			while(resultSet.next()){
				System.out.println("----------------------");
				
					System.out.println("Field #" + fieldnum);
					fieldnum ++;
				for(int i=1;i<=count ;i ++){
					
				System.out.print(resultSet.getMetaData().getColumnName(i)+" : ");
				System.out.println(resultSet.getString(i));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void CreateTable(){
		String ColName;
		System.out.print("Enter Table Name");
		String TableName = scan.nextLine();
		System.out.print("Enter the number of Columns :");
		int cols = scan.nextInt();
		
		String sql = " create table " + TableName + " ( ";
		 try {
				statement.executeUpdate("drop table if exists " + TableName);
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		for(int i = 1 ;i<= cols ; i++){
			System.out.println("--------------------------------");
			System.out.println("Enter #" + i + " Column Details :");
			System.out.print("Enter Column Name :");
			if(i==1)
			ColName = scan.nextLine();
			ColName = scan.nextLine();
			
			if(i<cols)
			sql += " " + ColName + " " + ColDataType() + " " + ColConstraint() + " , ";
			else
			sql += " " + ColName + " " + ColDataType() + " " + ColConstraint() + " ";
			System.out.println("--------------------------------");
		}
		 sql += " )";
		
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-------Your Table has Succefully Created !-------------------------");
	}
	
	private String ColDataType(){
		String DType;
		
		do{
			System.out.print("Enter Your DataType : string / int / double  : ");
			DType = scan.nextLine();
			DType = DType.toLowerCase();
		switch(DType){
		
		case "string":
			return "varchar(100)";
		
		case "int":
		case "integer":	
			return "int";
		
		case "double":
			return "double";
	}}
		while(true);
		
	
	}
	
	private String ColConstraint(){
		String Constraint;
		do{
		System.out.print("Enter Your Constraint : (not null) / (Primary Key) / (None)  :");
		Constraint = scan.nextLine();
		Constraint = Constraint.toLowerCase();
		switch(Constraint){
		
		case "not null":
		case "notnull":
			return "not null";
		
		case "primary key":	
		case "primarykey":		
			return "primary key";
			
		case "none":
		case "nothing":
			return null;
	
	}
	}while(true);
		
	}
	
}
