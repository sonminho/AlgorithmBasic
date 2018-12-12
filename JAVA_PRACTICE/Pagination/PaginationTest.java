
import java.util.List;
import java.util.Scanner;

public class PaginationTest {
	public static void main(String[] args) {
		List<Member> list = Member.getTestList();
		Pagination pagination = new Pagination(list);
			
		Scanner scanner = new Scanner(System.in);
		
		int page = 1;
		int totalPage = pagination.getTotalPage();
		
		while(true) {
			List<Member> pageList = pagination.getPage(page);
			printList(pageList, page);
			System.out.println("n : 다음페이지, p : 이전페이지, q : 종료");
			System.out.print("선택 : ");
			
			String cmd = scanner.nextLine().toLowerCase();

			if(cmd.equals("q")) {
				System.out.println("검색을 종료합니다.");
				System.exit(0);
			}
			else if(cmd.equals("p")) {
				page = page == 1 ? 1: --page;
			} else if(cmd.equals("n")) {
				page = page == totalPage ? totalPage : ++page;
			}
		}
	}
	
	public static void printList(List<Member> list, int page) {
		System.out.printf("\n[%d 페이지]\n", page);
		System.out.println("======================");
		System.out.println("이름            나이");
		System.out.println("======================");
		
		for(Member m : list) {
			System.out.printf("%-10s%-10d\n", m.getUserId(), m.getAge());
		}
	}
}
