package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
	try {
	return new Configuration().configure().buildSessionFactory();
	} catch (Exception e) {
	System.out.println(e.getMessage());
	return null;
	}
	}
	public static SessionFactory getSessionfacFactory()
	{
	return sessionFactory;
	}
	public static void shutdown()
	{
	getSessionfacFactory().close();
	}


}
