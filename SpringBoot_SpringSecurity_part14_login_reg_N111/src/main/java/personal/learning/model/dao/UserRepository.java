package personal.learning.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import personal.learning.model.entity.Country;
import personal.learning.model.entity.Language;
import personal.learning.model.entity.Role;
import personal.learning.model.entity.Users;

@Repository
public class UserRepository {
	
	@Autowired
    private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
    }
	
	@Transactional
	public void save(Users user) {
		Session session = getSession();
		Transaction txn = null;
		try {
			txn = session.beginTransaction();
			session.save(user);
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			//sessionFactory.close();
		}
	}

	public List<Country> getCountryList() {
		
		Session session = getSession();
		Transaction txn = null;
		List<Country> listOfCountry = new ArrayList<>();
		try {
			txn = session.beginTransaction();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT * FROM country");
			listOfCountry = new GeneralRepository<Country>().query(session, sb.toString(), Country.class);
			
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			//sessionFactory.close();
		}
		
		return listOfCountry;
	}

	public List<Language> getLangList() {
		Session session = getSession();
		Transaction txn = null;
		List<Language> listOfLang = new ArrayList<>();
		try {
			txn = session.beginTransaction();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT * FROM language");
			listOfLang = new GeneralRepository<Language>().query(session, sb.toString(), Language.class);
			
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			//sessionFactory.close();
		}
		
		return listOfLang;
	}

	public Optional<Country> getCountryByName(String countryName) {
		Session session = getSession();
		Transaction txn = null;
		Country country = new Country();
		try {
			txn = session.beginTransaction();
			StringBuilder sb = new StringBuilder();
			sb.append("select * from country where country_name = " + "'" + countryName +"'");
			
			List<Country> resultList = new GeneralRepository<Country>().query(session, sb.toString(), Country.class);
			if(ObjectUtils.isEmpty(resultList)) {
				throw new Exception("Country Name not found: " + countryName);
			}
			
			country = resultList.get(0);
			txn.commit();
			
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			//sessionFactory.close();
		}
		
		return Optional.ofNullable(country);
	}

	public Optional<Language> getLangByName(String lang) {
		Session session = getSession();
		Transaction txn = null;
		Language language = new Language();
		try {
			txn = session.beginTransaction();
			StringBuilder sb = new StringBuilder();
			sb.append("select * from language lan where lan.lang_name = " + "'" + lang + "'");
			List<Language> resultList = new GeneralRepository<Language>().query(session, sb.toString(), Language.class);
			
			if(ObjectUtils.isEmpty(resultList)) {
				throw new Exception("Language Not found: " + lang);
			}
			
			language = resultList.get(0);
			txn.commit();
			
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			//sessionFactory.close();
		}
		
		return Optional.ofNullable(language);
	}

	public Optional<Role> getRoleByName(String roleName) {
		Session session = getSession();
		Transaction txn = null;
		Role role = new Role();
		try {
			txn = session.beginTransaction();
			StringBuilder sb = new StringBuilder();
			
			sb.append("select * from role r where r.role_name = " + "'" + roleName + "'");
			List<Role> resultList = new GeneralRepository<Role>().query(session, sb.toString(), Role.class);
			
			if(ObjectUtils.isEmpty(resultList)) {
				throw new Exception("Role Not found: " + role);
			}
			
			role = resultList.get(0);
			txn.commit();
			
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			//sessionFactory.close();
		}
		
		return Optional.ofNullable(role);
	}

	public int getPkByUserName(String username) {
		Session session = getSession();
		Transaction txn = null;
		int id = -1;
		try {
			txn = session.beginTransaction();
			StringBuilder sb = new StringBuilder();
			sb.append("select u.id from users u where u.user_name = " + "'" + username + "'");
			List<Integer> resultList = new GeneralRepository<Integer>().query(session, sb.toString());
			if(ObjectUtils.isNotEmpty(resultList)) {
				id = resultList.get(0);
			}
			
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			//sessionFactory.close();
		}
		
		return id;
	}

	public int getPkByEmail(String email) {
		Session session = getSession();
		Transaction txn = null;
		int id = -1;
		try {
			txn = session.beginTransaction();
			StringBuilder sb = new StringBuilder();
			sb.append("select u.id from users u where u.email = " + "'" + email + "'");
			List<Integer> resultList = new GeneralRepository<Integer>().query(session, sb.toString());
			if(ObjectUtils.isNotEmpty(resultList)) {
				id = resultList.get(0);
			}
			
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			//sessionFactory.close();
		}
		
		return id;
	}

	public List<Role> getRoleList() {
		Session session = getSession();
		Transaction txn = null;
		List<Role> listOfRole = new ArrayList<>();
		try {
			txn = session.beginTransaction();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT * FROM role");
			listOfRole = new GeneralRepository<Role>().query(session, sb.toString(), Role.class);
			
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			//sessionFactory.close();
		}
		
		return listOfRole;
	}
	
//	public Language test() {
//	    Session session = getSession();
//	    Transaction txn = null;
//	    Language lang = null;
//	    try {
//	        txn = session.beginTransaction();
//
//	        Query<Language> query = session.createQuery("from Language where id = :pk").setParameter("pk", Integer.valueOf(1));
//	        lang = query.getSingleResult(); // Use getSingleResult() instead of getResultList().get(0)
//	        System.out.println(lang);
//
//	        txn.commit();
//	    } catch(Exception ex) {
//	        if(txn != null) {
//	            txn.rollback();
//	        }
//	        ex.printStackTrace();
//	    } finally {
//	        session.close();
//	    }
//
//	    return lang;
//	}


}
