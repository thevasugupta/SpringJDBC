package springjdbcconfig.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springjdbcconfig.dao.StudentDaoImpl;
import springjdbcconfig.model.Student;

public class SpringConfigApplication {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		
		Student student = new Student();
		student.setId("250825");
		student.setName("Spring via .class");

		StudentDaoImpl studentImpl = context.getBean("daoImplementation", StudentDaoImpl.class);
		studentImpl.updateStudent(student);
	}
}
