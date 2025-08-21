package springjdbc;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import springjdbc.dao.StudentDaoImpl;
import springjdbc.model.Student;

public class SpringJDBCApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configJDBC.xml");
		Student student = new Student();
		
		StudentDaoImpl studentImpl = context.getBean("daoImplementation", StudentDaoImpl.class);
		studentImpl.getStudent(student);
		}
	}
