public class GraphEdge{
	Edge e;
	GraphVertex source;
	GraphVertex dest;
	
	public GraphEdge(Edge e, GraphVertex source, GraphVertex dest) {
		this.e = e;
		this.source = source;
		this.dest = dest;
	}
	
	public String toString() {
		return "Edge: " + e.toString() + "Source: " + source.node.toString() + "Dest: " + dest.node.toString() + "\n";
	}
}