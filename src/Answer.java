/**
 * ����� Answer �������� ����� ������
 * � ���� �������� ������
 * �����: ���� �. ���������� ���: ����� �.
 */
public class Answer {
	public int number;
	private String description;
	public Answer(int n, String s) {
		number = n;
		description = s;
	}
	/**
	 * ����� ToString()
	 * ��������� ������ ������
	 * @return String
	 */
	public String toString() {
		String s = number + ") " + description + "\r\n";
		return s;
	}
}