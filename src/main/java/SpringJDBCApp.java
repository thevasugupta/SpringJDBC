import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringJDBCApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configJDBC.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		
		String query = "SELECT * FROM STUDENT";
		List<Map<String, Object>> students = template.queryForList(query);
		for (Map<String, Object> row : students) {
			System.out.println(row.get("id")+ " - "+row.get("name"));
		}
	}

}
