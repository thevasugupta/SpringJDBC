package springjdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import springjdbc.model.Student;

public class StudentDaoImpl implements StudentDao {
	
	JdbcTemplate template;
	
	

	public JdbcTemplate getTemplate() {
		return template;
	}



	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}



	@Override
	public void insertStudent(Student student) {
		
		
		String url = "jdbc:mysql://localhost:3306/advjava?useSSL=false";

        String username = "root";
        String password = "sql_qwerty";

        String query = "INSERT INTO STUDENT (id,name) VALUES (?,?)";
        
        template.update(query,student.getId(),student.getName());
	}
	
}
