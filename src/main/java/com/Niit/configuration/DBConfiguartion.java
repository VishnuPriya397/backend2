package com.Niit.configuration;

import java.util.Properties;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.Niit.model.BlogComment;
import com.Niit.model.BlogPost;
import com.Niit.model.BlogPostLikes;
import com.Niit.model.Chat;
import com.Niit.model.Friend;
import com.Niit.model.Job;
import com.Niit.model.Notification;
import com.Niit.model.ProfilePicture;
import com.Niit.model.User;

@Configuration
@EnableTransactionManagement
public class DBConfiguartion {


	  public DBConfiguartion(){
		 System.out.println("DBConfiguration"); 
	  }
	  
	  @Bean
	  public SessionFactory sessionFactory() {
			LocalSessionFactoryBuilder lsf=
					new LocalSessionFactoryBuilder(getDataSource());
			Properties hibernateProperties=new Properties();
			hibernateProperties.setProperty(
					"hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
			hibernateProperties.setProperty("hibernate.show_sql", "true");
			lsf.addProperties(hibernateProperties);
			Class classes[]=new Class[]{User.class,Job.class,BlogPost.class,Notification.class,BlogPostLikes.class,BlogComment.class,ProfilePicture.class,Friend.class,Chat.class};//class objects of all entities
		    return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	  }
	  
	  @Bean
		public DataSource getDataSource() {
		    BasicDataSource dataSource = new BasicDataSource();
		    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		    dataSource.setUsername("ORACLE");
		    dataSource.setPassword("priya");
		    return dataSource;
		    
		}
		@Bean
		public HibernateTransactionManager hibTransManagement(){
			return new HibernateTransactionManager(sessionFactory());
		}
}
