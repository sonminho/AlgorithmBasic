
import java.util.ArrayList;
import java.util.List;

public class Member implements Comparable<Member> {
	private String userId;
	private int age;
	
	public static List<Member> getTestList() {
		List<Member> list = new ArrayList<Member>();
		
		for(int i = 0; i < 32; i++) {
			list.add(new Member("홍길동 " + i, 40 - i));
		}
		return list;
	}
	
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", age=" + age + "]";
	}

	public Member(String userId, int age) {
		super();
		this.userId = userId;
		this.age = age;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		return this.userId.equals(((Member)obj).userId);
	}

	@Override
	public int compareTo(Member o) {
		int result = this.userId.compareTo(o.userId);
		
		if(result == 0) {
			return this.age - o.age;
		}
		return result;
	}

}
