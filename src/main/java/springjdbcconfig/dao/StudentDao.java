package springjdbcconfig.dao;

import springjdbcconfig.model.Student;

public interface StudentDao {
	public void insertStudent(Student student);
	
	public void updateStudent(Student student);
	
	public void getStudent(Student student);

}
