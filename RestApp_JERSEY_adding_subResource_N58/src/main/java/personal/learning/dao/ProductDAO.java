package personal.learning.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import personal.learning.entity.Product;

public class ProductDAO {
	
	SessionFactory sessionFactory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Product.class)
			.buildSessionFactory();

	public List<Product> getProductsByBrandId(int brandId) {
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			txn = session.beginTransaction();
			Query query = session.createQuery("from PRODUCT pr where pr.brandId = :brandId ");
			query.setInteger("brandId", brandId);
			productList = query.getResultList();
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
		return productList;
	}

}
