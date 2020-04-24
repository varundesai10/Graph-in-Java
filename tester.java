
public class tester{
	public static void main(String args[]) {
		/*
		Graph T = new Graph();
		System.out.println("YO: " + T.connectedComponents());
		System.out.println("YOYO: " + T.boundary_edges());
		Integer[] x = new Integer[8];
		for(int i = 0; i < 8; i++) {
			x[i] = 8-i;
		}
		SortingAlgo<Integer> SORT = new SortingAlgo<Integer>();
		SORT.mergeSort(x,new IntCompare());
		for(int i = 0; i < 8; i++) {
			System.out.println(x[i]);
		}
		
		myArrayList<Integer> hey = new myArrayList<Integer>();
		hey.add(1);
		hey.add(2);
		hey.add(3);
		System.out.println(hey.get(1));
		Graph myGraph = new Graph();
		Point p1 = new Point(0,0,0);
		Point p2 = new Point(1,1,1);
		Point p3 = new Point(1,2,3);
		Point p4 = new Point(1,4,7);
		
		Point p5 = new Point(3,2,1);
		Point p6 = new Point(6,4,5);
		Point p7 = new Point(7,7,7);
		
		Triangle t1 = new Triangle(p1,p2,p3);
		Triangle t2 = new Triangle(p5,p6,p7);
		Triangle t3 = new Triangle(p1,p2,p4);
		Triangle t4 = new Triangle(p5,p2,p1);
		
		myGraph.insert(t1);
		myGraph.insert(t2);
		myGraph.insert(t3);
		//myGraph.insert(t4);
		myGraph.print();
		System.out.println("Connected Components: " + myGraph.connectedComponents());
		
		GraphVertex searchedVertex = myGraph.vertexTree.search(t4.toString()).getValue();
		//System.out.println(searchedVertex.node);
		
		Edge[] neighbours = T.boundary_edges();
		System.out.println("Printing neighbours: " + (neighbours == null));
	//	for(int i = 0; i < neighbours.length; i++) {
		//	System.out.println(neighbours[i] + " " + neighbours[i].length());
		//}
		System.out.println(myGraph.isConnected(t1, t2));
		System.out.println(myGraph.isConnected(t1, t4));
		System.out.println(myGraph.pointTree.search(p1.toString()).getValues());
		System.out.println(myGraph.centroidOf(new Point(3,2,1)));
		System.out.println("THE MAN THE MYTH THE LEGEND THE CLOSEST COMPONENT QUERY IS HERE :)");
		Point closest[] = myGraph.closestComponents();
		System.out.println(closest[0] + ", " + closest[1]);
		System.out.println("MAXIMUM DIAMETER BEHENCHOD: ");
		System.out.println(myGraph.maxDiameter()); */
		
		myArrayList<Integer> yo= new myArrayList<Integer>();
		for(int i = 0; i < 1000; i++) {
			yo.add(i);
		}
		for(int i = 0; i < 1000; i++) {
			System.out.println(i + ": " + yo.get(i));
		}
		Point p1 = new Point(0,0,0);
		Point p2 = new Point(1,1,1);
		Point p3 = new Point(2.1f,2f,2f);
		Triangle T = new Triangle(p1,p2,p3);
		System.out.println(T.isValid());
	}
}