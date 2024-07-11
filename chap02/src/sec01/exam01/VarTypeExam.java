package sec01.exam01;

public class VarTypeExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 127;
//		b=128;

		char c = 97;
		System.out.println(c);
		c = 97 + 5;
		System.out.println(c);

		long balance = 30000000L; // 명확하게 long으로 지정하려면 숫자뒤에 L 또는 l 을 붙여준다
		
		String s = "문자열";
		System.out.println(s);
		
		float f = 0.1234567890123456789F;
		// float : 소수점 7번째 자리까지 정확
		System.out.println(f);
		double d = 0.1234567890123456789;
		// double : 소수점 16번쨰 자리까지 정확함
		System.out.println(d);

		
		boolean car = true;
		int phone_count = 5;
		String name = "서수찬";
		double number = 3.3;
		System.out.println(number * 5);
	}

}
