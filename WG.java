public class WG {
	private int numOfVertex; // 정점의 개수
	private int numOfEdge; // 간선의 개수
	private int[][] weight; // 간선의 가중치

	// 생성자
	public WG(int numOfVertex) {
		this.numOfVertex = numOfVertex; // 정점의 개수를 인자 값으로 받음
		weight = new int[numOfVertex][numOfVertex]; // 간선의 수와 가중치를 저장할 2차원 배열
		for (int i = 0; i < weight.length; i++) {
			for (int j = 0; j < weight.length; j++) {
				if (i == j) {
					weight[i][j] = 0;
				} else {
					weight[i][j] = 999;
				}
			}
		}
	}

	// 간선 삽입
	public void insertEdge(int v, int w, int t) {
		weight[v][t] = w;
		weight[t][v] = w;
		numOfEdge++;

	}

	// prim algorithm
	public Edge[] prim_MST(int s) {

		// 카운트 해주기 위한 변수 선언 및 초기화
		int index = 0;
		// 간선의 수 초기화, 임의의 배열 선언해줌, 최소 비용 신장 트리
		Edge[] T = new Edge[numOfVertex - 1];
		// T[index].vertex = s;
		// 간선 확인 여부
		boolean check[] = { false };
		// 합친 집합을 찾기위한 것 선언
		UnionFind unfi = new UnionFind(numOfVertex);
		
		// 삭제한 것을 저장하기 위한 변수 선언
		T[index] = null;
		// 초기화
		
		while (index < numOfVertex - 1) { // 종료조건 명시
			int min = 999, n = -1;
			
			for (int i = 0; i < numOfVertex; i++) {
				if (weight[index][i] < min && weight[index][i] != 0) {
					min = weight[index][i];
					n = i;
				}
			}
			
			if (!unfi.find(index, n) && !check[index]) {

				// 합치기!!!
				unfi.union(index, n);
				check[index] = true;

				// 인덱스 값 하나 증가 시키기
				index++;
				// T = T ∪ {(u, v)};
				// V(T) = V(T) ∪ {v};

			} else {
				// 스패닝 트리가 아님을 출력 후 반환
				System.out.println("no spanning tree");
				return T;
			}

		}
		
		// 최종적으로 T 배열 반환
		return T;
	}

	// Graph print
	public void print() {
		for (int i = 0; i < numOfVertex; i++) {
			for (int j = 0; j < numOfVertex; j++) {
				System.out.printf("|%3d|", weight[i][j]);
			}
			System.out.println();
		}
	}
}
