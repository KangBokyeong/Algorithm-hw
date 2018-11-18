interface CompKey
{
	public int compareTo(Object obj);
}
public class Edge {
	
	int vertex, weight, target;
	
	public Edge(int vertex, int weight, int target)
	{
		this.vertex = vertex; 	  //vertex
		this.weight = weight; 	  //weight
		this.target = target;	  //target
	}
	
}
