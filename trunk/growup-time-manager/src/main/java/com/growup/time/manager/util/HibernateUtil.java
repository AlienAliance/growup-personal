package com.growup.time.manager.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
	
	private static final SessionFactory SESSION = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration config = new Configuration().	addResource("/com/growup/time/manager/persistence/database.cfg.xml");
			ServiceRegistryBuilder registryBuilder = new ServiceRegistryBuilder();
			registryBuilder.applySettings(config.getProperties());
			registryBuilder.configure("/com/growup/time/manager/persistence/hibernate.cfg.xml");
			return config.buildSessionFactory(registryBuilder.buildServiceRegistry());			
		} catch (Throwable e) {
			logger.error("Loading hibernate configuration error", e);
			throw new ExceptionInInitializerError();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return SESSION;
	}
	
	public static void shutdown() {
		getSessionFactory().close();
	}
}
