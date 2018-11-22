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
public Edge[] prim_MST(int vertex) {

		// 카운트 해주기 위한 변수 선언 및 초기화
		int index = 0;
		// 간선의 수 초기화, 임의의 배열 선언해줌, 최소 비용 신장 트리
		Edge[] T = new Edge[numOfVertex - 1];

		// 간선 확인 여부
		// 먼저 check 배열을 간선의 크기보다 1적게 선언한 후에
		boolean check[] = new boolean[numOfVertex];
		
		//  vertex의 사용여부는 true로 초기화
		check[vertex] = true;

		// 합친 집합을 찾기위한 것 선언
		UnionFind unfi = new UnionFind(numOfVertex);

		// 새로운 배열을 생성하기 위한 변수를 null로 초기화시킴
		T[index] = null;

		while (index < numOfVertex - 1) { // 종료조건 명시
			// min는 최소값 비교하여 저장하기 공간이므로 크게 설정, u = vert, v = targ 각각 0으로 초기화
			int min = 999, vert = 0, targ = 0;
			
			for (int i = 0; i < numOfVertex; i++) {
				// 간선이 존재하지 않으면 계속해서 돌기(vertex부터 시작하기위해 설정)
				if (check[i] == false) {
					continue;
				}
				// 저점의 개수 만큼 계속 도는데
				for (int j = 0; j < numOfVertex; j++) {
					// 최소값을 찾으면서, 0이 아니어야하고, 합쳐진 곳에 정보가 없어야 한다.
					if (min > weight[i][j] && weight[i][j] != 0 && !unfi.find(i, j)) {
						// 최소값을 찾으면 행과 열의 인덱스 값, 가중치 값을 각각 저장
						min = weight[i][j];
						vert = i;
						targ = j;

					}

				}

				
			}
			// 반환해줄 엣지 배열에 저장
			T[index] = new Edge(vert, weight[vert][targ], targ); // 새로운 간선을 경로에 추가
			// 합하여 저장
			unfi.union(vert, targ);
			// 사용했으니 true로 바꿔줌(타겟 기준으로)
			check[targ] = true;
			// 저장이 되었으니 인덱스 값을 하나 증가시켜줌
			index++;

		}
		// 스페닝트리가 아님을 출력 후 엣지 배열 반환
		if (index < numOfVertex - 1) {
			System.out.println("no spanning tree");
			return T;

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
