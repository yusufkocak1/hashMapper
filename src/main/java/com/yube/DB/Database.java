package com.yube.DB;

import com.mysql.cj.xdevapi.JsonArray;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public abstract class Database {
public  SessionFactory Connection(Class object) {
	SessionFactory factory = new Configuration() 
			.configure("/hibernate.cfg.xml")
			.addAnnotatedClass(object)
			.buildSessionFactory();
	
	return factory;
}
public abstract boolean Execute(String sql);
public abstract List Select(Class object, String sql);
public abstract boolean Delete(String sql);
public abstract boolean Update(String sql);
public abstract boolean Insert (Object object);
}
