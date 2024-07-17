package sec02.exam01.exam07;

import java.lang.reflect.Member;
import java.util.*;

public class OrderExam {
    public static void main(String[] args) {
        MemberDTO m1 = new MemberDTO();
        MemberDTO m2 = new MemberDTO();
        MemberDTO m3 = new MemberDTO();

        m1.setName("서수찬");
        m1.setAge(20);

        m2.setName("멍멍이");
        m2.setAge(30);

        m3.setName("야옹이");
        m3.setAge(40);

        System.out.println(m1.getAge() > m2.getAge());

        MemberDTO m4 = compareMemberDTO(m1,m2);
        System.out.println(m4);

        List list = new ArrayList();
        list.add(m1);
        list.add(m3);
        list.add(m2);

        System.out.println(list);

//        Comparator comp = new OrderBy();
        //위의 new OrderBy()와 아래 코드는 완전히 같은코드임
        //아래 방법을 익명객체라고 한다
        Comparator comp = new Comparator(){ //new Comparator을 한게 아니고 Comparator를 상속받은 이름없는 클래스를 만든것임
            @Override
            public int compare(Object o1, Object o2) {
                MemberDTO dto1 = (MemberDTO) o1;
                MemberDTO dto2 = (MemberDTO) o2;
                return dto1.getAge()-dto2.getAge(); //음수는 올림차순, 양수는 내림차순
            }
        };

        Collections.sort(list,comp);
        System.out.println(list);


    }

    /*
        기능 : 둘 중에 나이가 큰 MemberDTO 돌려줌
     */

    static MemberDTO compareMemberDTO(MemberDTO dto1, MemberDTO dto2) {
        if (dto1.getAge() > dto2.getAge()) {
            return dto1;
        }else {
            return dto2;
        }
    }
}
