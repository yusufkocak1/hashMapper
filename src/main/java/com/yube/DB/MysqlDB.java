package com.yube.DB;

import com.mysql.cj.xdevapi.JsonArray;
import com.yube.data.hashdata;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.JSONArray;

import java.util.Collection;
import java.util.List;

public class MysqlDB extends Database {

	@Override
	public boolean Execute(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List Select(Class object,String sql) {
		// TODO Auto-generated method stub
		SessionFactory factory = Connection(object);
		Transaction tx = null;
		Session session = factory.getCurrentSession();
		JSONArray jsonArray = new JSONArray();

		List hashDatas=null;
		try {
			tx = session.beginTransaction();
			 hashDatas = session.createQuery(sql).list();

		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return hashDatas;
	}

	@Override
	public boolean Delete(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("finally")
	@Override
	public boolean Insert(Object object) {
		SessionFactory factory = Connection(object.getClass());
		Session session = factory.getCurrentSession();
		boolean result = false;
		try {
			session.beginTransaction();
			session.save(object);
			session.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			factory.close();
			return result;
		}

	}

}
