public class Edge implements EdgeInterface, Comparable<Edge>{
	Point p1;
	Point p2;
	
	public Edge(Point p1, Point p2) {
		if(p1.compareTo(p2) < 0) {
		this.p1 = p1;
		this.p2 = p2;
		}
		else {
			this.p1 = p2;
			this.p2 = p1;
		}
	}
	public PointInterface [] edgeEndPoints() {
		PointInterface[] toBeReturned = new Point[2];
		toBeReturned[0] = p1;
		toBeReturned[1] = p2;
		return toBeReturned;
	}
	
	public int compareTo(Edge e) {
		if(p1.compareTo(e.p1) != 0) { //if p1 not equal
			return p1.compareTo(e.p1);
		}
		else return p2.compareTo(e.p2);
	}
	
	public String toString() {
		return "[" + p1.toString() + ", " + p2.toString() + "]";
	}
	
	public float length() {
		return Point.distace(p1, p2);
	}
	
	public boolean containsPoint(Point p) {
		return (p1.compareTo(p) == 0 || p2.compareTo(p) == 0);
	}
}