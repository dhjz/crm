package com.dhj.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import com.dhj.domain.Customer;
import com.dhj.utils.HibernateUtils;

public class TestHib {
	
	
	
	/**
	 * 测试查询
	 */
	@Test
	public void testSel(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//创建查询接口
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for (Customer c : list) {
			System.out.println(c.getCust_name());
		}
		tr.commit();
		session.close();
	}
	/**
	 * 测试删除结果。
	 * 删除或者修改，必须先查询再删除或者修改
	 */
	@Test
	public void testDel(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		//第一个参数，javabean.class,第二个参数，主键的值
		Customer cust = session.get(Customer.class, 2L);
		session.delete(cust);
		tr.commit();
		session.close();
	}
	
	/**
	 * 通过主键查询
	 */
	@Test
	public void testGet(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		//第一个参数，javabean.class,第二个参数，主键的值
		Customer cust = session.get(Customer.class, 1L);
		System.out.println(cust.getCust_name());
		tr.commit();
		session.close();
	}
	
	@Test
	public void testSave2(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Customer cust = new Customer();
		cust.setCust_name("张一");
		session.save(cust);
		tr.commit();
		session.close();
	}
	
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
