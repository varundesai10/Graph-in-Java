
public class GraphVertex{
	Triangle node;
	myArrayList<GraphEdge> adjlist;
	public boolean marked = false;
	
	public GraphVertex() {
		adjlist = new myArrayList<GraphEdge>();
	}
	
	public GraphVertex(Triangle T) {
		node = T;
		adjlist = new myArrayList<GraphEdge>();
	}
	public String toString() {
		return "Contains Triangle: " + node.toString() + "\n + AdjList: " + adjlist.toString() + "\n";
	}
	public int degree() {
		return adjlist.size();
	}
	public void mark() {
		marked = true;
	}
	
	public void unmark() {
		marked = false;
	}
	
	public boolean marked() {
		return marked;
	}
}
