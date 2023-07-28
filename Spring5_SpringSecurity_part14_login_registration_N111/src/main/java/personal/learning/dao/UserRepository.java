package personal.learning.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import personal.learning.model.Country;
import personal.learning.model.User;

@Repository
public class UserRepository {
	
	@Autowired
    private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
    }
	
	public void save(User user) {
		
		Session session = getSession();
		Transaction txn = session.beginTransaction();
		
	}

	public List<Country> getCountryMap() {
		
		Session session = getSession();
		Transaction txn = null;
		List<Country> listOfCountry = new ArrayList<>();
		try {
			txn = session.beginTransaction();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT * FROM country");
			listOfCountry = new GeneralRepository<Country>().query(session, sb.toString(), Country.class);
			
		} catch(Exception ex) {
			ex.printStackTrace();
			if(txn != null) {
				txn.rollback();
			}
		} finally {
			session.close();
			sessionFactory.close();
		}
		
		return listOfCountry;
	}

	public LinkedHashMap<String, String> getLangMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getSchoolName() throws Exception {
		Session session = getSession();
		Transaction txn = session.beginTransaction();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append("    sc.school_name ");
		sb.append("FROM ");
		sb.append("    school sc ");
		sb.append("WHERE ");
		sb.append("    school_code = 'KHEMS' ");
		
		Query query = session.createNativeQuery(sb.toString());
		List<String> resultList = new GeneralRepository<String>().query(session, sb.toString());
		if(ObjectUtils.isEmpty(resultList)) {
			throw new Exception("School Name not found");
		}
		String schoolName = resultList.get(0);
		
		txn.commit();
		return schoolName;
	}

}
