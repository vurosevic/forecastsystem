package deloitte.forecastsystem_bih.loadforecast.exporttocsv;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExportSqlToCsv {
	
	String filepath;
	String query;
	String connectionUrl;
	Boolean withHeader;	
	Connection connection = null; 
	
	public ExportSqlToCsv() {
		// TODO Auto-generated constructor stub
	}
	
	public ExportSqlToCsv(String filepath, String query, String connectionUrl, Boolean withHeader) {		

		this.filepath = filepath;
		this.query = query;
		this.connectionUrl = connectionUrl;
		this.withHeader = withHeader;
		
	}	
	
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getConnectionUrl() {
		return connectionUrl;
	}

	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	public Boolean getWithHeader() {
		return withHeader;
	}

	public void setWithHeader(Boolean withHeader) {
		this.withHeader = withHeader;
	}	
	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public void sqlToCSV (){
		       
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	       try {
	    	   
	    	 Statement st = null;
       	     if(!connection.isClosed()) st = connection.createStatement();  		    	   

	         FileWriter fw = new FileWriter(filepath);
	         ResultSet rs = st.executeQuery(query);

	         int cols = rs.getMetaData().getColumnCount();

	         if (withHeader) {
		         for(int i = 2; i <= cols; i ++){
		            fw.append(rs.getMetaData().getColumnLabel(i));
		            if(i < cols) fw.append(',');
		            else fw.append('\n');
		         }
	         }

	         while (rs.next()) {

	            for(int i = 2; i <= cols; i ++){
	                fw.append(rs.getString(i));
	                if(i < cols) fw.append(',');
	            }
	            fw.append('\n');
	        }
	        fw.flush();
	        fw.close();
	        connection.close();
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }
	}	
	
}
