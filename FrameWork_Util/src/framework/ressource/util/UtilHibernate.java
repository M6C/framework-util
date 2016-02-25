package framework.ressource.util;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilHibernate {

	private static SessionFactory sessionFactory;
	private static Configuration configuration;

	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	
	public static final void configuration(File file) throws HibernateException {
		if (configuration==null)
			configuration = new Configuration().configure(file);
	}

	public static final void configuration() throws HibernateException {
		if (configuration==null)
			configuration = new Configuration().configure();
	}

	public static final void reconfiguration(File file) throws HibernateException {
		configuration = new Configuration().configure(file);
	}

	protected static final Configuration getConfiguration() throws HibernateException {
		configuration();
		return configuration;
	}

	protected static final SessionFactory getSessionFactory() throws HibernateException {
		if (sessionFactory == null)
			// Crée la SessionFactory
			sessionFactory = getConfiguration().buildSessionFactory();
		return sessionFactory;
	}

	public static Session openSession() throws HibernateException {
		// Initialise la configuration si nescessaire
		configuration();
		// Recupère une Session
		Session s = (Session) session.get();
		// Ouvre une nouvelle Session, si ce Thread n'en a aucune
		if (s == null) {
			s = getSessionFactory().openSession();
			session.set(s);
		}
		return s;
	}

	public static void closeSession()
	throws HibernateException {
		Session s = (Session) session.get();
		session.set(null);
		if (s != null) {
			s.flush();
			//s.clear();
			if (s.isOpen())
				s.close();
		}
		getSessionFactory().close();
	}

}
