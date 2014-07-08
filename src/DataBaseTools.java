import java.sql.*;

/**
 * ����� DataBaseTools �������� ����������� ��� ������ � �� SQLite
 * 
 * �����: ����� �., ���� �., ���������� ���: ���� �., ����� �.
 */
public class DataBaseTools {

	/**
	 * ����� createDB() ������������ � �� test.db
	 * � ������� � ��� ������� TEST
	 */
	public static void createDB() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS TEST"
					+ "(ID INT PRIMARY KEY     NOT NULL,"
					+ " QUESTION       TEXT    NOT NULL, "
					+ " ANSWER1        TEXT    NOT NULL, "
					+ " ANSWER2        TEXT    NOT NULL, "
					+ " ANSWER3        TEXT    NOT NULL, "
					+ " ANSWER4        TEXT    NOT NULL, "
					+ " NANSWER        INT     NOT NULL, "
					+ " RANSWER        TEXT    NOT NULL)";

			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}

	/**
	 * ����� fillDBMusic() ��������� ������� TEST �� test.db
	 * ��������� ���������� ������� - ������
	 */
	public static void fillDBMusic() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();

			String sqlDel = "DELETE FROM TEST;";
			stmt.executeUpdate(sqlDel);
			c.commit();

			String sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) "
					+ "VALUES (1, '��� �� ���������� Deep Purple ������� �� ������� ������ ������?', '������ ������', '�� ����', '���� ����', '��� ������', 2, '�� ����' );";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) "
					+ "VALUES (2, '�������� ����� ��������� ������ �������� ���� ������?', 'Blackmore-s Night', 'Black Crowles', 'Black Sabbath', 'Bal-Sagoth', 3, 'Black Sabbath' );";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) "
					+ "VALUES (3, '��� ���������� ���� �� ����� ��������� ����� Led Zeppelin?', 'Door to Hell', 'Stairway to the Skies', 'Knockin on Heaven-s Door', 'Stairway to Heaven', 4, 'Stairway to Heaven' );";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) "
					+ "VALUES (4, '��� �� ���������� ������������� ������� The Beatles ���� ������?', '���� ������', '��� ���������', '������ ��������', '����� �����', 1, '���� ������' );";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) "
					+ "VALUES (5, '���������� � ���������� ����� ������ ��� ����� ������?', 'Deep Purple', 'Korn', 'Pink Floyd', 'Led Zeppelin', 3, 'Pink Floyd' );";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) "
					+ "VALUES (6, '����� ������ ���������� ���-������� House of the Rising Sun?', 'AC/DC', 'Aerosmith', 'Metallica', 'The Animals', 4, 'The Animals' );";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) "
					+ "VALUES (7, '��� ����� ������� Rainbow, ������� ������ ���������� ������������ ����?', '���� ��� �����', '����� ������ ���', '���� ��� ������', '����� ��� ����', 2, '����� ������ ���' );";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) "
					+ "VALUES (8, '��� �������� ������� ����� The Man Who Sold The World?', '���� ������', '����� ����', '���� ����', '������ �����', 2, '����� ����' );";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) "
					+ "VALUES (9, '��� ���������������� �������� ������ R.E.M.?', 'Rock Enemy Malfunction', 'Rebelous Ego Monster', 'Rienstahdt Esse Mussichen', 'Rapid Eye Movement', 4, 'Rapid Eye Movement' );";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) "
					+ "VALUES (10, '����� ��������� ��� ����� �����������?', '���� ����������', '������ ���������', '������ ���������', '���� ���� ����', 1, '���� ����������' );";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}
	
	/**
	 * ����� fillDBLiterature() ��������� ������� TEST �� test.db
	 * ��������� ���������� ������� - ����������
	 */
	public static void fillDBLiterature() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();

			String sqlDel = "DELETE FROM TEST;";
			stmt.executeUpdate(sqlDel);
			c.commit();

			stmt = c.createStatement();
		    String sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) " +
		                 "VALUES (1, '��� ������� ������� �������� ������� ������� �������� � ������� �����?', '����� ���������', '������ ���������', '����� �������', '����� ������', 2, '������ ���������' );"; 
		    stmt.executeUpdate(sql);

		    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) " +
		            "VALUES (2, '������ ����������� �������� ����� ������ �� ����� ������������?', '����� � ����������', '�����', '�������� ����', '����� ������ �����', 1, '����� � ����������' );"; 
		    stmt.executeUpdate(sql);

		    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) " +
		            "VALUES (3, '�� ������� ����� ������� ����� ���� �������� ����� � ���?', '����', '���', '���', '������', 4, '������' );"; 
		    stmt.executeUpdate(sql);  
		    
		    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) " +
		            "VALUES (4, '����� �� ������������� ���� ����� �� ����� ���� �������������� ��������� ��������?', '����� �����', '�����', '��������', '�� ����� ��������', 2, '�����' );"; 
		    stmt.executeUpdate(sql); 
		    
		    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) " +
		            "VALUES (5, '������ ������ ����� ��������� ������ ����?', '�����', '�����', '������� ����������', '������', 1, '�����' );"; 
		    stmt.executeUpdate(sql); 
		    
		    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) " +
		            "VALUES (6, '��������� ����� ������ ���� ��� ����?', '���', '��������', '���������� �������', '��������������', 3, '���������� �������' );"; 
		    stmt.executeUpdate(sql); 
		    
		    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) " +
		            "VALUES (7, '��� ���� ������� ����� ������ ������� ����� ��������� � �����������?', '���������������', '��������', '��������', '��������', 4, '��������' );"; 
		    stmt.executeUpdate(sql); 
		    
		    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) " +
		            "VALUES (8, '����� ������� ��������� ����� ������� ��������� �� ��� ������ �������?', '������ ������� �����', '������ ������� �����', '����������� ����� � �������', '������� ��������� � ���', 3, '����������� ����� � �������' );"; 
		    stmt.executeUpdate(sql); 
		    
		    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) " +
		            "VALUES (9, '���� �������� ������� ����� ������ ���� ���� �������� ��� ������� �������?', '����������� ������', '��������������� ��������', '������', '��� �����������', 2, '��������������� ��������' );"; 
		    stmt.executeUpdate(sql); 
		    
		    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER,RANSWER) " +
		            "VALUES (10, '��� ���� ������ ���������� ��������� ������ � ������ ���������� ������� ������ ���������� ������?', '��������', '��������� ��������', '������', '�����������', 4, '�����������' );"; 
		    stmt.executeUpdate(sql); 

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}

	/**
	 * ����� getQuestions() ��������� ������ �������� �� ������ ������� TEST �� test.db
	 * @return Question[]
	 */
	public static Question[] getQuestions() {
		Connection c = null;
		Statement stmt = null;
		Question[] questions = new Question[10];
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TEST;");
			for (int i = 0; i < 10; i++) {
				int id = rs.getInt("ID");
				String question = rs.getString("QUESTION");
				String answer1 = rs.getString("ANSWER1");
				String answer2 = rs.getString("ANSWER2");
				String answer3 = rs.getString("ANSWER3");
				String answer4 = rs.getString("ANSWER4");
				int nanswer = rs.getInt("NANSWER");
				String ranswer = rs.getString("RANSWER");
				questions[i] = new Question(id, question, new Answer[] {
						new Answer(1, answer1), new Answer(2, answer2),
						new Answer(3, answer3), new Answer(4, answer4) },
						new Answer(nanswer, ranswer));
				rs.next();
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return questions;
	}

	/**
	 * ����� writeDBLog(String fname, String lname, String group,
	 *		int[] questions, int[] answers, String[] marks, int[] time, int total)
	 * ����������� � �� log.db � ������� � ��� ������� LOG
	 * ������� ��������� ���������� ����������		
	 * @param fname - ��� ��������
	 * @param lname - �������
	 * @param group - ������
	 * @param questions - ������ ������� ��������, �� ������� ������� ������������
	 * @param answers - ������ ������� ������������ 
	 * @param marks - ������ ���������� �������
	 * @param time - ������ � ��������� ��������
	 * @param total - ��������� �����
	 */
	public static void writeDBLog(String fname, String lname, String group,
			int[] questions, int[] answers, String[] marks, int[] time, int total) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:log.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS LOG"
					+ "(ID INT PRIMARY KEY ,"
					+ " FNAME       TEXT    NOT NULL, "
					+ " LNAME        TEXT    NOT NULL, "
					+ " NGROUP       TEXT    NOT NULL, "
					+ " QUESTION1        INT    NOT NULL, "
					+ " ANSWER1        INT    NOT NULL, "
					+ " MARK1        TEXT    NOT NULL, "
					+ " TIME1        TEXT    NOT NULL, "
					+ " QUESTION2        INT    NOT NULL, "
					+ " ANSWER2        INT    NOT NULL, "
					+ " MARK2        TEXT    NOT NULL, "
					+ " TIME2        TEXT    NOT NULL, "
					+ " QUESTION3        INT    NOT NULL, "
					+ " ANSWER3        INT    NOT NULL, "
					+ " MARK3        TEXT    NOT NULL, "
					+ " TIME3        TEXT    NOT NULL, "
					+ " QUESTION4        INT    NOT NULL, "
					+ " ANSWER4        INT    NOT NULL, "
					+ " MARK4        TEXT    NOT NULL, "
					+ " TIME4        TEXT    NOT NULL, "
					+ " QUESTION5        INT    NOT NULL, "
					+ " ANSWER5        INT    NOT NULL, "
					+ " MARK5        TEXT    NOT NULL, "
					+ " TIME5        TEXT    NOT NULL, "
					+ " TOTAL        INT    NOT NULL)";
			stmt.executeUpdate(sql);

			// String sqlDel = "DELETE FROM LOG;";
			// stmt.executeUpdate(sqlDel);
			// c.commit();

			sql = "INSERT INTO LOG (FNAME, LNAME, NGROUP, QUESTION1, ANSWER1, MARK1, TIME1, QUESTION2, ANSWER2, MARK2, TIME2, QUESTION3, ANSWER3, MARK3, TIME3, QUESTION4, ANSWER4, MARK4, TIME4, QUESTION5, ANSWER5, MARK5, TIME5, TOTAL) "
					+ "VALUES ('" + fname + "', '" + lname + "', '" + group + "', "
					+ questions[0] + ", " + answers[0] + ", '" + marks[0] + "', " + time[0] + ", "
					+ questions[1] + ", " + answers[1] + ", '" + marks[1] + "', " + time[1] + ", "
					+ questions[2] + ", " + answers[2] + ", '" + marks[2] + "', " + time[2] + ", "
					+ questions[3] + ", " + answers[3] + ", '" + marks[3] + "', " + time[3] + ", "
					+ questions[4] + ", " + answers[4] + ", '" + marks[4] + "', " + time[4] + ", " 
					+ total + ");";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	/**
	 * ����� getResults() ��������� ������, ���������� ���������� � ����������� �����
	 * @return ������ �����������
	 */
	public static String getResults() {
		Connection c = null;
		Statement stmt = null;
		String result = new String();
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:log.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM LOG ORDER BY ID DESC LIMIT 1;");
			String fname = rs.getString("FNAME");
			String lname = rs.getString("LNAME");
			String ngroup = rs.getString("NGROUP");
			int[] question = new int[5];
			int[] answer = new int[5];
			String[] mark = new String[5];
			int[] time = new int[5];
			result += ("���: " + fname + "\r\n");
			result += ("�������: " + lname + "\r\n");
			result += ("������: " + ngroup + "\r\n");
			result += ("���������� �����:\r\n");
			for(int i = 1; i < 6; i++) {
				question[i-1] = rs.getInt("QUESTION" + i);
				answer[i-1] = rs.getInt("ANSWER" + i);
				mark[i-1] = rs.getString("MARK" + i);
				time[i-1] = rs.getInt("TIME" + i);
				
				result += ("������ �" + question[i-1] + ". �����: " + answer[i-1] + ". " + mark[i-1] + " ���������� �����: " + time[i-1] + " ����.\r\n");
			}
			int total = rs.getInt("TOTAL");
			result += ("������: " + total);
			
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return result;
	}
}
