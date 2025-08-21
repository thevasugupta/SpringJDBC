package springjdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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



	@Override
	public void getStudent(Student student) {
		String query = "SELECT * FROM STUDENT";
		
		 List<Student> students = template.query(query, (rs, rowNum) -> {
		        Student s = new Student();
		        s.setId(rs.getString("id"));
		        s.setName(rs.getString("name"));
		        return s;
		    });
		
		System.out.println("Displaying Records:");
		for (Student s : students) {
	        System.out.println("ID: " + s.getId() + ", Name: " + s.getName());
	    }
	}
	
}
