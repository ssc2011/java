package sec01.exam01;

public class TypeCastingExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2 + 2 * 2;
		long b = (long) a; // int인 a를 long 타입으로 바꿔라

		long c = a;// 자동 형변환

		System.out.println("c : " + c);
		a = (int) c; // 큰거에서 작은거로 바뀔때는 손실이 있을 수 있다
						// 형변환 생략 불가능

		long d = 3000000000L;
		int a2 = (int) d;
		System.out.println("a2 : " + a2);
		
		double d2 = 3.14;
		int i =(int)d2;
		System.out.println(i);

	}

}
