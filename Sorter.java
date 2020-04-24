public interface Sorter<E>{
	public int compare(E e1, E e2);
}

class EdgeCompare_length implements Sorter<Edge>{
	public int compare(Edge e1, Edge e2) {
		if(e1.length() > e2.length()) return 1;
		if(e2.length() > e1.length()) return -1;
		return 0;
	}
}

class IntCompare implements Sorter<Integer>{
	public IntCompare(){
		
	}
	public int compare(Integer a, Integer b) {
		return a-b;
	}
}

class TriangleCompare_insertion implements Sorter<Triangle>{
	public TriangleCompare_insertion() {}
	public int compare(Triangle A, Triangle B) {
		if(A.id > B.id) return 1;
		if(A.id < B.id) return -1;
		return 0;
	}
}

class PointCompare_coord implements Sorter<Point>{
	public PointCompare_coord() {}
	public int compare(Point q, Point p) {
		if(q.x != p.x) {
			if(q.x - p.x < 0) return -1;
			else return 1;
		}
		else if(q.y != p.y) {
				if(q.y - p.y < 0) return -1;
				else return 1;
			}
		else {
			if(q.z - p.z < 0) return -1;
			if(q.z - p.z > 0) return 1;
			else return 0;
		}
	}
}


