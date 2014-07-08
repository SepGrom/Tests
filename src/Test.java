import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * ����� Test �������� ����� ����� � ��������� � �������� ���� ����������
 * 
 * �����: ����� �. ���������� ���: ���� �.
 */
public class Test {

	// ������� ���������� ��� ����������� ���������� ��
	static String[] studentInfo = new String[3];
	static int[] quesionNumbersForDB = new int[5];
	static int[] answerNumbersForDB = new int[5];
	static String[] quesionMarksForDB = new String[5];
	static int[] answerTimeForDB = new int[5];
	static int mark = 0;

	/**
	 * ����� main(String[] args) ����� ����� � ���������, �������� �������� ����
	 * ���������� ���������
	 * 
	 * @param args
	 * @throws IOException
	 *             - ����������, ����������� ��� ������������� ������
	 *             �����-������.
	 */
	public static void main(String[] args) throws IOException {
		// �������� ���������� ���������� ������
		if (args[0].equals("setup")) {
			DataBaseTools.createDB();
			if (args[1].equals("Music")) {
				DataBaseTools.fillDBMusic();
				System.out.println("���������� �������: ������.");
			} else if (args[1].equals("Literature")) {
				DataBaseTools.fillDBLiterature();
				System.out.println("���������� �������: ����������.");
			}
		} else if (args[0].equals("run")) {			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // ����� ��� ������ �� �������
			String s = new String(); // ������ ��� �������� ����������� ����������
			Question[] questions = DataBaseTools.getQuestions(); // ������� ���� ��������
			String ans; // �����, ��������� �������������
			
			// ������ ������������
			System.out.println("������������.\n������� ���� ���, ������� � ������� ������.");
			s = in.readLine();
			studentInfo = getStudentInfo(s);
			System.out.println("����, ���������.\n������ ������:");
			int num = getRandomUniqueQuestionNumber(questions, getIntList0to9());
			// ���� ��������� ��������
			for (int i = 0; i < 5; i++) {
				long startTime = System.currentTimeMillis();
				System.out.println(askOneQuestion(questions, i, num));
				ans = in.readLine();
				long timeSpent = System.currentTimeMillis() - startTime;
				answerTimeForDB[i] = (int) timeSpent;
				answerNumbersForDB[i] = new Integer(ans);
			}

			// ���������� ���������� ������������ � ��
			DataBaseTools.writeDBLog(studentInfo[0], studentInfo[1],
					studentInfo[2], quesionNumbersForDB, answerNumbersForDB,
					quesionMarksForDB, answerTimeForDB, mark);
			// ������� ���������� ������������
			System.out.println("���������� �����:");
			System.out.println(DataBaseTools.getResults());
		} else if (args[0].equals("gui")) {
			new RegistrationGUI();
		}
	}

	/**
	 * ����� checkOneQuestion ��������� ������������ ������ �� ������
	 * � ������� ��������������� ����������
	 * @param questions - ������ ��������
	 * @param i - ����� ��������
	 * @param num - ����� ������� � ������� ��������
	 * @param ans - �����
	 * @return String - ������ �����������
	 */
	public static String checkOneQuestion(Question[] questions, int i, int num, String ans) {
		String result = new String();
		if (i != 4) {
			if (questions[num].IsTrue(new Integer(ans))) {
				result += ("�� �������� �����.\n��������� ������:");
				mark++;
				quesionMarksForDB[i] = "�����.";
			} else {
				result += ("�� �������� �������.\n��������� ������:");
				quesionMarksForDB[i] = "�������.";
			}
		} else {
			if (questions[num].IsTrue(new Integer(ans))) {
				result += ("�� �������� �����.\n���� ��������.");
				mark++;
				quesionMarksForDB[i] = "�����.";
			} else {
				result += ("�� �������� �������.\n���� ��������.");
				quesionMarksForDB[i] = "�������.";
			}
		}
		return result;
	}

	/**
	 * ����� askOneQuestion - ��������� ���� ������
	 * @param questions - ������ ��������
	 * @param i - ����� ���������
	 * @param num - ����� ������� � �������
	 * @return String - ������ �������
	 */
	public static String askOneQuestion(Question[] questions, int i, int num) {
		String result = new String();
		quesionNumbersForDB[i] = questions[num].number;
		// ������ ������
		result += (questions[num].toString());
		return result;
	}

	/**
	 * ����� getRandomUniqueQuestionNumber - ���������� ��������� ����� �������
	 * @param questions - ������ ��������
	 * @param questionNumbers - ������ �������
	 * @return int - ��������� ����� �������
	 */
	public static int getRandomUniqueQuestionNumber(Question[] questions, List<Integer> questionNumbers) {
		// ������ �������� � ����������� ��������
		// ��������� ������ ������� �� 0 �� 9
		Random rand = new Random();
		// ��������� ����� �� 0 �� ������� ������ �� ������� ������
		int numb = rand.nextInt(questionNumbers.size());
		// ��������� ������� ������ (�� 0 �� 10)
		int num = questionNumbers.get(numb);
		// �������� ��������� ������� �� ������, ����� ���� ������� ���
		questionNumbers.remove(numb);
		return num;
	}

	/**
	 * ����� getIntList0to9 - ��������������� �����, ���������� ������ � �������� �� 0 �� 9
	 * @return List<Integer> - ������ � �������� �� 0 �� 9
	 */
	public static List<Integer> getIntList0to9() {
		List<Integer> questionNumbers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			questionNumbers.add(i);
		}
		return questionNumbers;
	}

	/**
	 * ����� writeStudentInfo(String s) �� ������ s �������� ���������� � ������������
	 * 
	 * @param s - ������� ������
	 * @throws IOException - ����������, ����������� ��� ������������� ������ �����-������.
	 */
	public static String[] getStudentInfo(String s) {
		String[] info = new String[3];
		info = s.split(" ");
		return info;
	}

}
