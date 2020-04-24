
public class Point implements PointInterface, Comparable<Point>{
	float x;
	float y;
	float z;
	
	public Point() {
		x = y = z = 0f;
	}
	public Point(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public float getX() {
		return x;
	} 
	public float getY() {
		return y;
	}
	public float getZ() {
		return z;
	}
	public float [] getXYZcoordinate() {
		float[] toBeReturned = new float[3];
		toBeReturned[0] = x;
		toBeReturned[1] = y;
		toBeReturned[2] = z;
		return toBeReturned;
	}
	static public Point subtract(Point p1, Point p2) {
		return new Point(p1.x - p2.x, p1.y - p2.y, p1.z - p2.z);
	}
	public int compareTo(Point p) {
		if(this.x != p.x) {
			if(this.x - p.x < 0) return -1;
			else return 1;
		}
		else if(this.y != p.y) {
				if(this.y - p.y < 0) return -1;
				else return 1;
			}
		else {
			if(this.z - p.z < 0) return -1;
			if(this.z - p.z > 0) return 1;
			else return 0;
		}
	}
	static float square(float x) { return x*x; }
	
	static float distace(Point p1, Point p2) {
		float d = square(p1.x - p2.x) + square(p1.y - p2.y) + square(p1.z - p2.z);
		return d;
	}
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
	
	static Point add(Point p1, Point p2) {
		return new Point(p1.x + p2.x, p1.y + p2.y, p1.z + p2.z);
	}
	
	public void divideBy(float a) {
		x = x/a;
		y = y/a;
		z = z/a;
	}
	static Point Centroid(myArrayList<Point> points) {
		long size = points.size();
		Point centroid = new Point(0,0,0);
		for(int i = 0; i < size; i++) {
			centroid = Point.add(centroid, points.get(i));
		}
		centroid.divideBy(size);
		return centroid;
	}
	
	public float modulus() {
		return square(x) + square(y) + square(z);
	}
	
	static Point cross(Point p1, Point p2) {
		return new Point( (p1.y)*(p2.z) - (p1.z)*(p2.y), p1.x*p2.z - p1.z*p2.x, p1.x*p2.y - p1.y*p2.x);
	}
	
	static float dot(Point p1, Point p2) {
		return p1.x*p2.x + p1.y*p2.y + p1.z*p2.z;
	}
}