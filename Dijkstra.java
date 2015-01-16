import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Dijkstra {
	private UndirectedGraph<String> graph;
	private HashMap<String, Route<String>> distances;	//dictionary of vertices and their routes
	private HashSet<String> usedVerts;	//keeps track of vertices that have already been looked at
	private vertQueue vertQ;	//queue of vertices to look at sequentially
	private String root;
	private String target;
	private int baconNum;
	
	public Dijkstra(UndirectedGraph<String> g, String start, String end) {
		graph = g;
		root = start;
		target = end;
		baconNum = 0;
		vertQ = new vertQueue();
		usedVerts = new HashSet<String>(graph.getVertexCount());
		distances = new HashMap<String, Route<String>>(graph.getVertexCount());
	}
	
	public void start() {
		distances.put(root, new Route<String>("", 0));
		vertQ.addToEnd( new vertNode(root));
	}
	
	public boolean isNext() { return !vertQ.empty(); }
	
	public String popFront() {
		String node = vertQ.rmFirst().getID();
		return node;
	}
	
	public boolean checkNeighbors(String s) {
		String node = s;
		Set<String> neighbors = graph.getNeighbors(node);
		for (String v : neighbors ) {
			if (v.equals(target)) { 
				int num = distances.get(node).getNumEdges()+1;
				distances.put(v, new Route<String>(node, num));
				return true;
			}
			else if (!usedVerts.contains(v)) {
				int num = distances.get(node).getNumEdges()+1;
				distances.put(v, new Route<String>(node, num));
				vertQ.addToEnd(new vertNode(v));
			}
		}
		usedVerts.add(node);
		return false;
	}
	
	public void traceRoute(String node) {
		baconNum = distances.get(node).getNumEdges();
		while (node.length() > 0) {
			System.out.print( node );
			if( distances.get(node).getNumEdges() > 0 )
				System.out.print( " -> ");
			node = distances.get( node ).getPrev();
		}
		System.out.println("\nDistance: " + baconNum + " steps");
	}
	
}





