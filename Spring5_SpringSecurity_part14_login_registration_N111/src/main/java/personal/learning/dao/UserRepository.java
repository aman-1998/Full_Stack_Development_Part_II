package personal.learning.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	//public Map<String, String> getCountryMap

}
