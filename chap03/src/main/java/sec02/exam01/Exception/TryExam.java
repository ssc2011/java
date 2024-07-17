package sec02.exam01.Exception;

public class TryExam {
    public static void main(String[] args) {
        String s1 = null;
//        System.out.println(s1.length());
        System.out.println(s1);

        String s2 = "20";
        int age=0;
        try{
            age = Integer.parseInt(s2);
            System.out.println(age+1);
            ThrowsTest tt = new ThrowsTest();
            tt.human(3);

        }catch (HumanException he){
            String message = he.getMessage();
            if("EC05".equals(message)){
                System.out.println("5미만을 입력하셨군요. 확인 ㄱㄱ");
            }else if("EC06".equals(message)){
                System.out.println("10초과를 입력하셨군요. 확인 ㄱㄱ");
            }
        }
        catch(Exception e){
            System.out.println("오류 발생");
            e.printStackTrace();
        }

    }
}
