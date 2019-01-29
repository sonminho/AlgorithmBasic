import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//입력 예시(부모노드, 자식노드, 가중치)
//12
//1 2 3
//1 3 2
//2 4 5
//3 5 11
//3 6 9
//4 7 1
//4 8 7
//5 9 15
//5 10 4
//6 11 6
//6 12 10

class MakingTree {
	static class Node {
		Node left;
		Node right;
		int num; // 노드의 번호
		int cost; // 부모 노드와의 거리

		Node(Node left, Node right, int num, int cost) {
			this.left = left;
			this.right = right;
			this.num = num;
			this.cost = cost;
		}
	}

	static Node search(Node node, int value) {
		Node node1 = null;
		Node node2 = null;

		if (node.num == value) { // 추가할 노드를 찾음
			return node;
		}

		if (node.left != null) {
			node1 = search(node.left, value);
		}

		if (node.right != null) {
			node2 = search(node.right, value);
		}

		if (node1 != null) {
			return node1;
		} else if (node2 != null) {
			return node2;
		} else {
			return null;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Node root = new Node(null, null, 1, 0); // 최상위 노드
		int n = Integer.parseInt(br.readLine()) - 1;

		StringTokenizer stk = null;

		while (n-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");

			int parentNum = Integer.parseInt(stk.nextToken());
			int nodeNum = Integer.parseInt(stk.nextToken());
			int cost = Integer.parseInt(stk.nextToken());

			Node node = search(root, parentNum);
			//System.out.println("부모 " + node.num);

			if (node.left == null) {
				node.left = new Node(null, null, nodeNum, cost);
			} else {
				node.right = new Node(null, null, nodeNum, cost);
			}

			 System.out.println(node.num + "에 " + nodeNum + "을 추가합니다.");
		}
	}
}