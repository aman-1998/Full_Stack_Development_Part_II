package personal.learning.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import personal.learning.model.Customer;

public class AppDAOImpl implements AppDAO {
	
	private DataSource dataSource;
	
	public AppDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Customer> listCustomers() {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		StringBuffer sb = new StringBuffer();
		sb.append("select email, name, gender, language, dob, country, address ");
		sb.append("from ");
		sb.append("customer   cus, ");
		sb.append("country    con ");
		sb.append("where ");
		sb.append("cus.country_id = con.country_pk ");
		String query = sb.toString();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			LinkedList<String> emailList = new LinkedList<String>();
			LinkedList<String> nameList = new LinkedList<String>();
			LinkedList<String> genderList = new LinkedList<String>();
			LinkedList<String> langList = new LinkedList<String>();
			LinkedList<String> dobList = new LinkedList<String>();
			LinkedList<String> countryList = new LinkedList<String>();
			LinkedList<String> addressList = new LinkedList<String>();
			while(rs.next()) {
				emailList.add(rs.getString("email"));
				nameList.add(rs.getString("name"));
				genderList.add(rs.getString("gender"));
				langList.add(rs.getString("language"));
				dobList.add(rs.getString("dob"));
				countryList.add(rs.getString("country"));
				addressList.add(rs.getString("address"));
			}
			LinkedList<String> tempEmailList = (LinkedList<String>) emailList.clone();
			int index = 1;
			for(String email : emailList) {
				if(emailList.subList(index, emailList.size()).contains(email)) {
					tempEmailList.remove(index-1);
				}
				index++;
			}
			
			for(String email1 : tempEmailList) {
				String cusEmail = null;
				String cusName = null;
				String cusGender = null;
				String cusDob = null;
				String cusCountry = null;
				String[] cusLang = new String[4];
				String cusAddress = null;
				index = 0;
				int langIndex = 0;
				for(String email2 : emailList) {
					if(email1.equals(email2)) {
						cusEmail = emailList.get(index); // email2
						cusName = nameList.get(index);
						cusGender = genderList.get(index);
						cusDob = dobList.get(index);
						cusCountry = countryList.get(index);
						cusLang[langIndex] = langList.get(index);
						if(addressList.get(index) != null) {
							if(!addressList.get(index).isEmpty()) {
								cusAddress = addressList.get(index);
							}
						}
						langIndex++;
					}
					index++;
				}
				customerList.add(new Customer(cusEmail, cusName, cusGender, cusDob, cusCountry, cusLang, cusAddress));
			}
		} catch (SQLException e) {
			System.out.println("Failed to read data from database");
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Failed to close database connection");
					e.printStackTrace();
				}
			}
		}
		
		return customerList;
	}
}
