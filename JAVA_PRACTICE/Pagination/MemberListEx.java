
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MemberListEx {
	public static void main(String[] args) {
		List<Member> list = new ArrayList<>();
		
		for(int i = 0; i < 32; i++) {
			list.add(new Member("홍길동" + i, 40 - i));
		}
		list.add(new Member("홍길동0", 10));
		boolean r = list.contains(new Member("홍길동0", 40));
		list.add(new Member("홍길동0", 20));
		System.out.println(r);
		
		Collections.sort(list, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				String userId1 = o1.getUserId();
				String userId2 = o2.getUserId();
				//return userId1.compareTo(userId2);
				return o1.getAge() - o2.getAge();
			}
		});
		
		for(Member member : list)
			System.out.println(member.getUserId());
		System.out.println();
		
		Collections.sort(list);
		for(Member member : list)
			System.out.println(member.getUserId() + ", " + member.getAge());
		
		//Collections.reverse(list);
	}
}
