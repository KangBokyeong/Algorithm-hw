```java
import java.util.*;

public class PrimMain {
    public static void main(String[] args) {
        WG graph = new WG(6);
        graph.insertEdge(0, 5, 1); graph.insertEdge(0, 4, 2);
        graph.insertEdge(1, 2, 2); graph.insertEdge(1, 7, 3);
        graph.insertEdge(2, 6, 3); graph.insertEdge(2, 9, 4);
        graph.insertEdge(3, 3, 4); graph.insertEdge(3, 8, 5);
        graph.insertEdge(4, 8, 5); 
 
        System.out.println("Print Graph");
        graph.print();
        
        System.out.println("\nPrim MST (start - weight - end)");
        Edge[] prim = graph.prim_MST(0);
        for(int i = 0; i < prim.length; i++)
        	System.out.print("("+prim[i].vertex + "-" + prim[i].weight + "-" + prim[i].target +") ");

    }
}
```
