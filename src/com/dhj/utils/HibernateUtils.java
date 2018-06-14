package com.dhj.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate框架的工具类
 * @author MYKJDHJ
 *
 */
public class HibernateUtils {
	private static final Configuration CONFIG;
	private static final SessionFactory FACTORY;
	
	//编写静态代码块，赋值
	static{
		//加载xml配置文件
		CONFIG  = new Configuration().configure();
		FACTORY = CONFIG.buildSessionFactory();
	}
	
	/**
	 * 从工厂中获取Session对象
	 * @return
	 */
	public static Session getSession(){
		return FACTORY.openSession();
	}
	
	/**
	 * 从工厂中获取绑定线程的session
	 * @return
	 */
	public static Session getCurrentSession(){
		return FACTORY.getCurrentSession();
	}
	
	
}
