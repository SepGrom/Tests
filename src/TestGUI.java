import java.awt.*; // Using AWT container and component classes
import java.awt.event.*; // Using AWT event classes and listener interfaces

/**
 * Класс TestGUI содержит интерфейс пользователя для тестирования
 * 
 * Автор: Цуман А., Шуба С. Критиковал код: Шуба С., Цуман А.
 */
//An AWT program inherits from the top-level container java.awt.Frame
public class TestGUI extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Label lblQuestion; // Declare component Label
	private Label lblAnswer; // Declare component Label
	private TextArea tfQuestion; // Declare component TextField
	private TextField tfAnswer; // Declare component TextField
	private Button btnConfirm; // Declare component Button
	Question[] questions;
	int i = 0;
	long startTime;
	int num;

	/** Constructor to setup GUI components and event handling */
	public TestGUI() {
		setLayout(null);

		lblQuestion = new Label("Тестирование."); // construct Label
		lblQuestion.setLocation(30, 30);
		lblQuestion.setSize(120, 30);
		add(lblQuestion); // "super" Frame adds Label
		lblAnswer = new Label("Ответ: "); // construct Label
		lblAnswer.setLocation(30, 300);
		lblAnswer.setSize(120, 30);
		add(lblAnswer); // "super" Frame adds Label

		tfQuestion = new TextArea("", 100, 10, 1); // construct TextField
		tfQuestion.setLocation(30, 90);
		tfQuestion.setSize(510, 180);
		tfQuestion.setEditable(false); // set to read-only
		add(tfQuestion); // "super" Frame adds tfCount
		
		tfAnswer = new TextField("", 100); // construct TextField
		tfAnswer.setLocation(210, 300);
		tfAnswer.setSize(120, 30);
		add(tfAnswer); // "super" Frame adds tfCount

		btnConfirm = new Button("Начать"); // construct Button
		btnConfirm.setLocation(420, 300);
		btnConfirm.setSize(120, 30);
		add(btnConfirm); // "super" Frame adds Button

		btnConfirm.addActionListener(this);
		// Clicking Button source fires ActionEvent
		// btnCount registers this instance as ActionEvent listener

		setTitle("Тестирование"); // "super" Frame sets title
		setSize(600, 360); // "super" Frame sets initial window size

		setVisible(true); // "super" Frame shows
		
		this.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
				  System.exit(0);  
			  }
			});

		tfQuestion.setText("Итак, приступим.\n");
		questions = DataBaseTools.getQuestions(); // Создаем базу вопросов
	}

	/** 
	 * ActionEvent handler - Called back upon button-click. 
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(!btnConfirm.getLabel().equals("Начать")) {
			questionsCycle();
		}
		if(i == 0) {
			askFirstQuestion();
		}
	}
	
	/**
	 * Метод askOneQuestion задает пользователю один вопрос
	 */
	public void askOneQuestion() {
		String res = new String();
		num = Test.getRandomUniqueQuestionNumber(questions, Test.getIntList0to9());
		res += (Test.askOneQuestion(questions, i, num));
		tfQuestion.setText(res);
	}
	
	/**
	 * Метод checkOneQuestion - проверяет ответ на вопрос
	 * @param ans - ответ, введенный пользователем
	 * @param num - номер вопроса в массиве вопросов
	 */
	public void checkOneQuestion(String ans, int num) {
		Test.checkOneQuestion(questions, i, num, ans);
		Test.answerNumbersForDB[i] = new Integer(ans);
	}
	
	/**
	 * Метод getTestResults - записывает результаты тестирования в БД и выдает их на экран
	 */
	public void getTestResults() {
		String res = new String();
		// Записываем результаты тестирования в БД
		DataBaseTools.writeDBLog(Test.studentInfo[0], Test.studentInfo[1],
		Test.studentInfo[2], Test.quesionNumbersForDB, Test.answerNumbersForDB,
		Test.quesionMarksForDB, Test.answerTimeForDB, Test.mark);
		// Выводим результаты тестирования
		res += "Результаты теста:\n";
		res += DataBaseTools.getResults();
		tfQuestion.setText(res);		
	}
	
	public void questionsCycle() {
		if(i < 5) {
			checkOneQuestion(tfAnswer.getText(), num);
			long timeSpent = System.currentTimeMillis() - startTime;
			Test.answerTimeForDB[i] = (int) timeSpent;
			if(i != 4) {
				askOneQuestion();
			}
			i++;
			startTime = System.currentTimeMillis();
		} else if(i == 5) {
			getTestResults();
			i++;
			btnConfirm.setLabel("Завершить");
		} else if(i == 6) {
			this.dispose();
			System.exit(0);
		}
	}
	
	public void askFirstQuestion() {
		btnConfirm.setLabel("Подтвердить");
		askOneQuestion();
		startTime = System.currentTimeMillis();
		i++;
	}
}
