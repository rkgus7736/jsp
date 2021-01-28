package config;


import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBManager {
	private static DBManager instance = new DBManager();
	private SqlSessionFactory factory;
	private SqlSession session;
	//차후 마이바티스로 변경 완료시 아래 코드들은 전부 삭제될 영역
	private Connection conn;
	private DBManager() {
		String resource = "db/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession(true);//false : not auto commit
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static DBManager getInstance() {
		if (instance == null)
			instance = new DBManager();
		return instance;
	}

	public SqlSession getSession() {
		return session;
	}
	
	public Connection getConn() {
		try {
			Class.forName(DBConfig.DB_DRIVER);
			conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USER, DBConfig.DB_PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}







