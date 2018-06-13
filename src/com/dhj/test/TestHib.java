package com.dhj.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.dhj.domain.Customer;

public class TestHib {

	@Test
	public void testSave(){
		//加载配置文件
		Configuration config = new Configuration();
		//默认加载src
		config.configure();
		//创建sessionFactory
		SessionFactory factory = config.buildSessionFactory();
		//创建session
		Session session = factory.openSession();
		//开启事务
		Transaction tr = session.beginTransaction();
		
		Customer cust = new Customer();
		cust.setCust_name("李四");
		cust.setCust_mobile("22222222");
		//保存客户
		session.save(cust);
		//提交事务
		tr.commit();
		session.close();
		factory.close();
		
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
