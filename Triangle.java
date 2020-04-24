public class Triangle implements TriangleInterface{
	
	long id;
	static long currentId = 0;
	
	Point p1, p2, p3;
	Edge e1, e2, e3;
	
	public Point[] sortPoints(Point[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if( arr[j].compareTo(arr[i]) < 0 ) {
					Point temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	
	}
	
	public Triangle(Point p1, Point p2, Point p3) {
		Point[] points = new Point[3];
		points[0] = p1; points[1] = p2; points[2] = p3;
		points = sortPoints(points);
		this.p1 = points[0];
		this.p2 = points[1];
		this.p3 = points[2];
		e1 = new Edge(p1, p2);
		e2 = new Edge(p2, p3);
		e3 = new Edge(p3,p1);
		this.id = currentId++;
	}
	
	public Triangle(Point p1, Point p2, Point p3, long x) {
		Point[] points = new Point[3];
		points[0] = p1; points[1] = p2; points[2] = p3;
		points = sortPoints(points);
		this.p1 = points[0];
		this.p2 = points[1];
		this.p3 = points[2];
		e1 = new Edge(p1, p2);
		e2 = new Edge(p2, p3);
		e3 = new Edge(p3,p1);
		this.id = x;
	}
	
	public Triangle() {
		this.p1 = new Point(0,0,0);
		this.p2 = new Point(0,0,0);
		this.p3 = new Point(0,0,0);
	}
	
	public Point[] triangle_coord() {
		Point[] toBeReturned = new Point[3];
		toBeReturned[0] = p1;
		toBeReturned[1] = p2;
		toBeReturned[2] = p3;
		return toBeReturned;
	}
	
	/*
	public boolean isValid() {
		Point AB = Point.subtract(p1, p2);
		Point BC = Point.subtract(p2, p3);
		//checking if AB = n*BC;
		
		if(BC.x != 0 && BC.y != 0 && BC.z != 0) {
		float a = AB.x/BC.x; float b = AB.y/BC.y; float c = AB.z/BC.z;
		if(a == b && b==c) return false;
		else return true;
		}
		
		if( BC.y != 0 && BC.z != 0) {
			float a = AB.y/BC.y; float b = AB.z/BC.z;
			if(a == b && BC.x == 0 && AB.x == 0) return false;
			else return true;
		}  
		if(BC.x != 0 && BC.z != 0) {
			float a = AB.x/BC.x; float b = AB.z/BC.z;
			if(a == b && BC.y == 0 && AB.y == 0) return false;
			else return true;
		}
        if(BC.x != 0 && BC.y != 0) {
        	float a = AB.y/BC.y; float b = AB.x/BC.x;
			if(a == b && BC.z == 0 && AB.z == 0) return false;
			else return true;
        }
        if(BC.x != 0) {
        	return !(AB.y == 0 && AB.z == 0);
        }
        if(BC.y != 0) {
        	return !(AB.x == 0 && AB.z == 0);
        }
        if(BC.z != 0) {
        	return !(AB.y == 0 && AB.x == 0);
        }
        return false;
	}
	*/
	
	public boolean isValid() {
		Point AB = Point.subtract(p1, p2);
		Point BC = Point.subtract(p2, p3);
		if(p1.compareTo(p2) == 0 || p2.compareTo(p3) == 0 || p3.compareTo(p1) == 0) return false;
		if(Point.dot(AB, BC) == 0) return true;
		double tan = Math.sqrt(Point.cross(AB, BC).modulus())/Point.dot(AB, BC);
		if(Math.abs(tan) < 0.001) return false;
		return true;
	}
	public boolean containsEdge(Edge e) {
		return (e.compareTo(e1) == 0 || e.compareTo(e2) == 0 || e.compareTo(e3) == 0);
		}
	
	public Edge[] triangle_edges() {
		Edge[] toBeReturned = new Edge[3];
		toBeReturned[0] = e1;
		toBeReturned[1] = e2;
		toBeReturned[2] = e3;
		return toBeReturned;
	}
	
	public String toString() {
		return "[" + p1.toString() + ", " + p2.toString() + ", " + p3.toString() + "]";
	}
}