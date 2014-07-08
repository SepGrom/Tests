import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Класс Test содержит точку входа в программу и основной цикл выполнения
 * 
 * Автор: Цуман А. Критиковал код: Шуба С.
 */
public class Test {

	// Создаем переменные для дальнейшего заполнения БД
	static String[] studentInfo = new String[3];
	static int[] quesionNumbersForDB = new int[5];
	static int[] answerNumbersForDB = new int[5];
	static String[] quesionMarksForDB = new String[5];
	static int[] answerTimeForDB = new int[5];
	static int mark = 0;

	/**
	 * Метод main(String[] args) Точка входа в программу, содержит основной цикл
	 * выполнения программы
	 * 
	 * @param args
	 * @throws IOException
	 *             - Исключение, создаваемое при возникновении ошибки
	 *             ввода-вывода.
	 */
	public static void main(String[] args) throws IOException {
		// Проверка аргументов коммандной строки
		if (args[0].equals("setup")) {
			DataBaseTools.createDB();
			if (args[1].equals("Music")) {
				DataBaseTools.fillDBMusic();
				System.out.println("Предметная область: Музыка.");
			} else if (args[1].equals("Literature")) {
				DataBaseTools.fillDBLiterature();
				System.out.println("Предметная область: Литература.");
			}
		} else if (args[0].equals("run")) {			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // Буфер для чтения из консоли
			String s = new String(); // Строка для хранения считываемой информации
			Question[] questions = DataBaseTools.getQuestions(); // Создаем базу вопросов
			String ans; // Ответ, введенный пользователем
			
			// Начало тестирования
			System.out.println("Тестирование.\nВведите ваше имя, фамилию и учебную группу.");
			s = in.readLine();
			studentInfo = getStudentInfo(s);
			System.out.println("Итак, приступим.\nПервый вопрос:");
			int num = getRandomUniqueQuestionNumber(questions, getIntList0to9());
			// Цикл задавания вопросов
			for (int i = 0; i < 5; i++) {
				long startTime = System.currentTimeMillis();
				System.out.println(askOneQuestion(questions, i, num));
				ans = in.readLine();
				long timeSpent = System.currentTimeMillis() - startTime;
				answerTimeForDB[i] = (int) timeSpent;
				answerNumbersForDB[i] = new Integer(ans);
			}

			// Записываем результаты тестирования в БД
			DataBaseTools.writeDBLog(studentInfo[0], studentInfo[1],
					studentInfo[2], quesionNumbersForDB, answerNumbersForDB,
					quesionMarksForDB, answerTimeForDB, mark);
			// Выводим результаты тестирования
			System.out.println("Результаты теста:");
			System.out.println(DataBaseTools.getResults());
		} else if (args[0].equals("gui")) {
			new RegistrationGUI();
		}
	}

	/**
	 * Метод checkOneQuestion проверяет правильность ответа на вопрос
	 * и выводит соответствующую информацию
	 * @param questions - массив вопросов
	 * @param i - номер итерации
	 * @param num - номер вопроса в массиве вопросов
	 * @param ans - ответ
	 * @return String - строка результатов
	 */
	public static String checkOneQuestion(Question[] questions, int i, int num, String ans) {
		String result = new String();
		if (i != 4) {
			if (questions[num].IsTrue(new Integer(ans))) {
				result += ("Вы ответили верно.\nСледующий вопрос:");
				mark++;
				quesionMarksForDB[i] = "Верно.";
			} else {
				result += ("Вы ответили неверно.\nСледующий вопрос:");
				quesionMarksForDB[i] = "Неверно.";
			}
		} else {
			if (questions[num].IsTrue(new Integer(ans))) {
				result += ("Вы ответили верно.\nТест завершен.");
				mark++;
				quesionMarksForDB[i] = "Верно.";
			} else {
				result += ("Вы ответили неверно.\nТест завершен.");
				quesionMarksForDB[i] = "Неверно.";
			}
		}
		return result;
	}

	/**
	 * Метод askOneQuestion - формирует один вопрос
	 * @param questions - массив вопросов
	 * @param i - номер итерациии
	 * @param num - номер вопроса в массиве
	 * @return String - строка вопроса
	 */
	public static String askOneQuestion(Question[] questions, int i, int num) {
		String result = new String();
		quesionNumbersForDB[i] = questions[num].number;
		// Задаем вопрос
		result += (questions[num].toString());
		return result;
	}

	/**
	 * Метод getRandomUniqueQuestionNumber - возвращает случайный номер вопроса
	 * @param questions - массив вопросов
	 * @param questionNumbers - список номеров
	 * @return int - случайный номер вопроса
	 */
	public static int getRandomUniqueQuestionNumber(Question[] questions, List<Integer> questionNumbers) {
		// Решаем проблему с повторением вопросов
		// Заполняем список числами от 0 до 9
		Random rand = new Random();
		// Случайное число от 0 до размера списка на текущий момент
		int numb = rand.nextInt(questionNumbers.size());
		// Случайный элемент списка (от 0 до 10)
		int num = questionNumbers.get(numb);
		// Выбираем случайный элемент из списка, после чего удаляем его
		questionNumbers.remove(numb);
		return num;
	}

	/**
	 * Метод getIntList0to9 - вспомогательный метод, возвращает список с номерами от 0 до 9
	 * @return List<Integer> - список с номерами от 0 до 9
	 */
	public static List<Integer> getIntList0to9() {
		List<Integer> questionNumbers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			questionNumbers.add(i);
		}
		return questionNumbers;
	}

	/**
	 * Метод writeStudentInfo(String s) Из строки s получаем информацию о пользователе
	 * 
	 * @param s - входная строка
	 * @throws IOException - Исключение, создаваемое при возникновении ошибки ввода-вывода.
	 */
	public static String[] getStudentInfo(String s) {
		String[] info = new String[3];
		info = s.split(" ");
		return info;
	}

}
