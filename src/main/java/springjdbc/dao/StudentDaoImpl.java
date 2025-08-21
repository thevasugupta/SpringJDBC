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
	private String url = "jdbc:mysql://localhost:3306/advjava?useSSL=false";

    private String username = "root";
    private String password = "sql_qwerty";


	@Override
	public void insertStudent(Student student) {	

        String query = "INSERT INTO STUDENT (id,name) VALUES (?,?)";
        
        template.update(query,student.getId(),student.getName());
        System.out.println("Insertion Successful : ("+student.getId()+","+student.getName()+")");
	}

	@Override
	public void updateStudent(Student student) {
		String query = "UPDATE STUDENT "
				+ "SET name=? "
				+ "WHERE id=?";
		
		template.update(query, student.getName(),student.getId());
		System.out.println("Updation Success!");
		
	}
	
}
