/**
 * ����� Question �������� ����� �������, �������� �������,
 * ������ ������� � ���������� �����
 * �����: ���� �. ���������� ���: ����� �.
 */
public class Question {
	public int number;
	private String question;
	private Answer[] answers;
	private Answer rightAnswer;
	/**
	 * ����������� ������
	 * @param n - ����� �������
	 * @param q - �������� �������
	 * @param a - ������ �������
	 * @param ra - ���������� �����
	 */
	public Question(int n, String q, Answer[] a, Answer ra) {
		number = n;
		question = q;
		answers = a;
		rightAnswer = ra;
	}
	/**
	 * ����� IsTrue(int a)
	 * ��������� ������������ ������ a
	 * @param a - ��������� �����
	 * @return - boolean
	 */
	public boolean IsTrue(int a) {
		if(a == rightAnswer.number)
			return true;
		return false;
	}
	/**
	 * ����� ToString()
	 * ��������� ���� �������
	 * @return String
	 */
	public String toString() {
		String s = number + ". " + question + "\r\n";
		for(int i = 0; i < answers.length; i++) {
			s += answers[i].toString();
		}
		return s;
	}
}
