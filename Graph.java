

public class Graph{
	
	myArrayList<GraphEdge> edgeList;
	myArrayList<GraphVertex> vertexList;
	long number_vertexes;
	RBTree<String, GraphVertex> vertexTree;
	RBTree<String, GraphVertex> pointTree;
	String typeofMesh = "proper";
	
	public Graph() {
		edgeList = new myArrayList<GraphEdge>();
		vertexList = new myArrayList<GraphVertex>();
		vertexTree = new RBTree<String, GraphVertex>();
		pointTree = new RBTree<String, GraphVertex>();
		number_vertexes = 0;
	}
	
	public void update_typeMesh() {
		typeofMesh = "proper";
		boolean breakloop = false;
		for(int i = 0; i < vertexList.size() && !breakloop; i++) {
			Edge[] edges = vertexList.get(i).node.triangle_edges();
			myArrayList<GraphEdge> adj_list = vertexList.get(i).adjlist;
			Integer occur[] = new Integer[3]; occur[0] = 0; occur[1] = 0; occur[2] = 0;
			for(int j = 0; j < adj_list.size(); j++) {
				Edge E = adj_list.get(j).e;
				for(int k = 0; k < 3; k++) {
					if(E.compareTo(edges[k]) == 0){occur[k] = occur[k] +1;}
				}
			}
			for(int p = 0; p < 3; p++) {
				//ArrayPrinter.print(occur); 
				if(occur[p] < 1) typeofMesh = "semiproper";
				if(occur[p] > 1) {
					typeofMesh = "improper";
					breakloop = true;
					break;
				}
			}
		}
	}
	
	
	public int type() {
		update_typeMesh();
		switch(typeofMesh) {
		case "proper": return 1;
		case "semiproper":return 2;
		case "improper":return 3;
		default: return 0;
		}
	}
	
	// make sure you do this at end of each traversal.
	public void unmarkAll() {
		for(int i = 0; i < vertexList.size(); i++) {
			vertexList.get(i).unmark();
		}
	}
	
	public void insert(Triangle T) {
		Edge[] edges = T.triangle_edges();
		
		GraphVertex newVertex = new GraphVertex(T);
		vertexTree.insert(newVertex.node.toString(), newVertex);
		number_vertexes++;
		pointTree.insert(T.triangle_coord()[0].toString(), newVertex);
		pointTree.insert(T.triangle_coord()[1].toString(), newVertex);
		pointTree.insert(T.triangle_coord()[2].toString(), newVertex);
		
		for(int i = 0; i < vertexList.size(); i++) {
			GraphVertex p = vertexList.get(i);
			if(p.node.containsEdge(edges[0])) {
				
				//adding to its adjacency list!
				GraphEdge newEdge = new GraphEdge(edges[0], p, newVertex);//creating new Edge
				p.adjlist.add(newEdge);//adding it to p //O(1).
				newVertex.adjlist.add(new GraphEdge(edges[0], newVertex, p));//adding it to newVertex
				//adding in to main edge list. //O(1) 
				edgeList.add(newEdge);
			
			}
			else if(p.node.containsEdge(edges[1])) {
				
				//adding to its adjacency list!
				GraphEdge newEdge = new GraphEdge(edges[1], p, newVertex);//creating new Edge
				p.adjlist.add(newEdge);//adding it to p
				newVertex.adjlist.add(new GraphEdge(edges[1], newVertex, p));//adding it to newVertex
				//adding in to main edge list.
				edgeList.add(newEdge);
			
			}
			else if(p.node.containsEdge(edges[2])) {
				
				//adding to its adjacency list!
				GraphEdge newEdge = new GraphEdge(edges[2], p, newVertex);//creating new Edge
				p.adjlist.add(newEdge);//adding it to p
				newVertex.adjlist.add(new GraphEdge(edges[2], newVertex, p));//adding it to newVertex
				//adding in to main edge list.
				edgeList.add(newEdge);
			
			}
		}
		vertexList.add(newVertex);
	}
	
	public void dfs_traverse(GraphVertex vertex) {
		vertex.mark();
		for(int i = 0; i < vertex.adjlist.size(); i++) {
			GraphVertex next = vertex.adjlist.get(i).dest;
			if(!next.marked()) {
				dfs_traverse(next);
			}
		}
	}
	public int connectedComponents() {
		int connected = 0;
		for(int i = 0; i < vertexList.size(); i++) {
			GraphVertex V = vertexList.get(i);
			if(!V.marked) {
				connected += 1;
				dfs_traverse(V);
			}
		}
		unmarkAll();
		return connected;
	}
	
	public Edge[] boundary_edges() {
		myArrayList<Edge> toBeReturned = new myArrayList<Edge>();
		
		for(int i = 0; i < vertexList.size(); i++) {
			GraphVertex p = vertexList.get(i);
			myArrayList<GraphEdge> A = p.adjlist;
			if(true) { //this triangle belongs to the boundary.
				
				Triangle T = p.node;
				Edge[] edges = T.triangle_edges();
				for(int j = 0; j < 3; j++) { //checking if the edge is connected.
					boolean shouldIAdd = true;
					for(int k = 0; k < A.size(); k++) {
						if(A.get(k).e.compareTo(edges[j]) == 0) {
							shouldIAdd = false;
							break;
						}
						
					}
					if(shouldIAdd) toBeReturned.add(edges[j]);
				}
			}
		
		}
		if(toBeReturned.size() == 0) return null;
		Edge[] actuallyReturned = new Edge[toBeReturned.size()];
		for(int i = 0; i < toBeReturned.size(); i++) {
			actuallyReturned[i] = toBeReturned.get(i);
		}
		SortingAlgo<Edge> edgeSorter = new SortingAlgo<Edge>();
		edgeSorter.mergeSort(actuallyReturned, new EdgeCompare_length());
		return actuallyReturned;
	}
	
	public void print() {
		//System.out.println("Printing Edges: ");
		//System.out.println(edgeList);
		//System.out.println("Printing Vertexes: ");
		//System.out.println(vertexList);
	}
	
	public Triangle[] neighbors(Triangle T) {
		myArrayList<Triangle> q = new myArrayList<Triangle>();
		if(vertexTree.search(T.toString()).getValue() == null) return null;
		myArrayList<GraphEdge> p = vertexTree.search(T.toString()).getValue().adjlist;
		for(int i = 0; i < p.size(); i++) {
			q.add(p.get(i).dest.node);
		}
		if(q.size() == 0) return null;
		Triangle[] toBeReturned = new Triangle[q.size()];
		for(int i = 0; i< q.size(); i++) {
			toBeReturned[i] = q.get(i);
		}
		(new SortingAlgo<Triangle>()).mergeSort(toBeReturned, new TriangleCompare_insertion());
		return toBeReturned;
	}
	
	private boolean dfs_isConnected(GraphVertex p, Triangle B) {
		p.mark();
		if(p.node.toString().compareTo(B.toString()) == 0) {
			return true;
		}
		else {
			myArrayList<GraphEdge> list = p.adjlist;
			for(int i = 0; i<list.size(); i++) {
				GraphVertex V = list.get(i).dest;
				if (!V.marked()){
					boolean hi = dfs_isConnected(V, B);
					if(hi) return hi;
				}
			}
			return false;
		}
	}
	public boolean isConnected(Triangle A, Triangle B) {
		//Assuming A and B already exist in the graph.
		GraphVertex A_vertex = vertexTree.search(A.toString()).getValue();
		if(A_vertex == null) return false;
		//now doing dfs on A, hoping will find it.
		boolean hi = dfs_isConnected(A_vertex, B);
		unmarkAll();
		return hi;
		
	}
	
	public Edge[] edgeNeighbours(Triangle T) {
		GraphVertex p = vertexTree.search(T.toString()).getValue();
		if(p == null) return null;
		else return p.node.triangle_edges();
	}
	
	public Point[] pointNeighbours(Triangle T) {
		GraphVertex p = vertexTree.search(T.toString()).getValue();
		if(p == null) return null;
		else return p.node.triangle_coord();
	}
	
	public Triangle[] extendedNeighbours(Triangle T) {
		
		myArrayList<Triangle> helper = new myArrayList<Triangle>();
		GraphVertex T_vertex = vertexTree.search(T.toString()).getValue();
		if(T_vertex == null) return null;
		T_vertex.mark();
		for(int i = 0; i < 3; i++) {
			
			myArrayList<GraphVertex> p = pointTree.search(T.triangle_coord()[i].toString()).getValues();
			for(int j = 0; j < p.size(); j++) {
				if(!p.get(j).marked()) {
				p.get(j).mark();
				helper.add(p.get(j).node);
				}
				
			}
		}
		if(helper.size() == 0) return null;
		
		Triangle[] toBeReturned = new Triangle[helper.size()];
		for(int i = 0; i < helper.size(); i++) {
			toBeReturned[i] = helper.get(i);
		}
		unmarkAll();
		(new SortingAlgo<Triangle>()).mergeSort(toBeReturned, new TriangleCompare_insertion());
		return toBeReturned;
	}
	
	public Triangle[] incidentTriangles(Point P) {
		myArrayList<GraphVertex> helper = pointTree.search(P.toString()).getValues();
		if(helper == null) return null;
		if(helper.size() == 0) return null;
		Triangle[] toBeReturned = new Triangle[helper.size()];
		for(int i = 0; i < helper.size(); i++) {
			toBeReturned[i] = helper.get(i).node;
		}
		(new SortingAlgo<Triangle>()).mergeSort(toBeReturned, new TriangleCompare_insertion());
		return toBeReturned;
	}
	
	public Edge[] edgeNeighbourOfPoint(Point P) {
		myArrayList<GraphVertex> helper = pointTree.search(P.toString()).getValues();
		if(helper == null) return null;
		myArrayList<Edge> allEdges = new myArrayList<Edge>();
		for(int i = 0; i < helper.size(); i++) {
			Triangle T = helper.get(i).node;
			for(int k = 0; k < 3; k++) {
				if(T.triangle_edges()[k].containsPoint(P)) { //now, we dont want duplicate edges.
					if(!allEdges.contains(T.triangle_edges()[k])) allEdges.add(T.triangle_edges()[k]); 
				}
			}
		}
		if(allEdges.size() == 0) return null;
		Edge[] toBeReturned = new Edge[allEdges.size()];
		for(int i = 0; i < allEdges.size(); i++) {
			toBeReturned[i] = allEdges.get(i);
		}
		return toBeReturned;
		
	}
	
	public Point[] NeighbourOfPoint(Point P) {
		myArrayList<GraphVertex> helper = pointTree.search(P.toString()).getValues();
		myArrayList<Point> allPoints = new myArrayList<Point>();
		if (helper == null) return null;
		for(int i = 0; i < helper.size(); i++) {
			Triangle T = helper.get(i).node;
			for(int k = 0; k < 3; k++) {
				if(T.triangle_coord()[k].compareTo(P) != 0) { //now, we dont want duplicate edges.
					if(!allPoints.contains(T.triangle_coord()[k])) allPoints.add(T.triangle_coord()[k]); 
				}
			}
		}
		if(allPoints.size() == 0) return null;
		Point[] toBeReturned = new Point[allPoints.size()];
		for(int i = 0; i < allPoints.size(); i++) {
			toBeReturned[i] = allPoints.get(i);
		}
		return toBeReturned;
		
	}
	
	public Triangle[] NeighbourOfEdge(Edge E) {
		myArrayList<Triangle> helper = new myArrayList<Triangle>();
		for(int i = 0; i < vertexList.size(); i++) {
			if(vertexList.get(i).node.containsEdge(E)) {
				helper.add(vertexList.get(i).node);
			}
		}
		if(helper.size() == 0) return null;
		Triangle[] toBeReturned = new Triangle[helper.size()];
		for(int i = 0; i < helper.size(); i++) {
			toBeReturned[i] = helper.get(i);
		}
		(new SortingAlgo<Triangle>()).mergeSort(toBeReturned, new TriangleCompare_insertion());
		return toBeReturned;
	}
	
	void dfs_centroid(GraphVertex p, RBTree<String, Point> points){
		p.mark(); //process current Vertex.
		Triangle T = p.node;
		for(int j = 0; j < 3; j++) {
			if( (points.search(T.triangle_coord()[j].toString()).getValue() == null) ) {
				points.insert(T.triangle_coord()[j].toString(), T.triangle_coord()[j]);
			}
		}
		myArrayList<GraphEdge> A = p.adjlist;
		for(int i = 0; i < A.size(); i++) {
			GraphVertex V = A.get(i).dest;
			if(!V.marked()) {
				dfs_centroid(V, points);
			}
		}
		
	}

		
	
	
	public Point[] Centroid() {
		//Now make different Graphs for different connected components.
		myArrayList<Point> helper = new myArrayList<Point>();
		for(int i = 0; i < vertexList.size(); i++) {
			if(!vertexList.get(i).marked()) {
				GraphVertex p = vertexList.get(i);
				RBTree<String, Point> points = new RBTree<String, Point>();
				dfs_centroid(p, points);
				//now points contains all points, and we need to find average of it.
				myArrayList<Point> allPoints = points.returnIterator();
				helper.add(Point.Centroid(allPoints));
			}
		}
		Point[] toBeReturned = new Point[helper.size()];
		for(int i = 0; i < helper.size(); i++) {
			toBeReturned[i] = helper.get(i);
		}
		unmarkAll();
		(new SortingAlgo<Point>()).mergeSort(toBeReturned, new PointCompare_coord());
		return toBeReturned;
	}
	
	public Point centroidOf(Point P) {
		GraphVertex p = pointTree.search(P.toString()).getValue();
		RBTree<String, Point> points = new RBTree<String, Point>();
		if(p!=null) {
		dfs_centroid(p, points);
		//now points contains all points, and we need to find average of it.
		myArrayList<Point> allPoints = points.returnIterator();
		unmarkAll();
		return (Point.Centroid(allPoints));
		}
		else return null;
	}
	
	public int eccentricity(GraphVertex p) {
		int max_dist = 0;
		p.mark();
		Queue<Pair<Integer, GraphVertex>> bfsQueue = new Queue<Pair<Integer, GraphVertex>>();
		bfsQueue.enqueue(new Pair<Integer, GraphVertex>(0, p));
		
		while(bfsQueue.hasAny()) {
			//add all adj of p
			Pair<Integer, GraphVertex> V = bfsQueue.dequeue();
			for(int i = 0; i < V.b.adjlist.size(); i++) {
				if(!V.b.adjlist.get(i).dest.marked()) {
					V.b.adjlist.get(i).dest.mark();
					bfsQueue.enqueue(new Pair<Integer, GraphVertex>(V.a + 1,V.b.adjlist.get(i).dest));
				}
			}
			if(V.a > max_dist) max_dist = V.a;
		}
		unmarkAll();
		return max_dist;
	}
	
	
	public int maxDiameter() {
		//finding graph with maximum number of triangles!
		Graph G = new Graph();
		//now we do dfs, iterative!
		for(int i = 0; i < vertexList.size(); i++) {
			if(!vertexList.get(i).marked()) {
				Graph newGraph = new Graph();
				GraphVertex p = vertexList.get(i);
				Stack<GraphVertex> stack = new Stack<GraphVertex>();
				
				stack.push(p);
				
				while(stack.hasAny()) {
					GraphVertex V = stack.pop();
					newGraph.insert(V.node);
					V.mark();
					
					for(int j = 0; j < V.adjlist.size(); j++) {
						if(!V.adjlist.get(j).dest.marked()) stack.push(V.adjlist.get(j).dest);
					}
				
				}
				if(newGraph.number_vertexes > G.number_vertexes) G = newGraph;
			}
		}
		unmarkAll();
		//Graph with maximum number of vertices has been found.
		
		int max_diameter = 0;
		for(int i = 0; i < G.vertexList.size(); i++) {
			int temp = G.eccentricity(G.vertexList.get(i));
			if(temp > max_diameter) max_diameter = temp;
		}
		return max_diameter;
	}
	public Point[] closestComponents() {
		float min_dist = Float.MAX_VALUE;
		
		Pair<Point, Point> minPoints = new Pair<Point, Point>();
		//myArrayList<Graph> allGraphs = new myArrayList<Graph>();
		myArrayList<RBTree<String, Point>> allPoints = new myArrayList<RBTree<String, Point>>(); 
		
		//separating each component into a different graph.
		for(int i = 0; i < vertexList.size(); i++) {
			
			if(!vertexList.get(i).marked()) {
				
				GraphVertex p = vertexList.get(i);
				Stack<GraphVertex> stack = new Stack<GraphVertex>();
				stack.push(p);
				//Graph G = new Graph();
				RBTree<String, Point> points = new RBTree<String, Point>();
				
				while(stack.hasAny()) {
					GraphVertex q = stack.pop();
					//G.insert(q.node);
					for(int k = 0; k < 3; k++) {
						if(points.search(q.node.triangle_coord()[k].toString()).getValue() == null) {
							points.insert(q.node.triangle_coord()[k].toString(), q.node.triangle_coord()[k]);
						}
					}
					q.mark();
					for(int j = 0; j < q.adjlist.size(); j++) {
						if(!q.adjlist.get(j).dest.marked()) {
							stack.push(q.adjlist.get(j).dest);
						}
					}
				}
				//allGraphs.add(G);
				allPoints.add(points);
			}
		}
		unmarkAll();
		//we now have an arraylist of graphs of different components. Now we apply brute force.
		for(int i = 0; i < allPoints.size(); i++) {
			for(int j = i + 1; j < allPoints.size(); j++) {
				myArrayList<Point> A = allPoints.get(i).returnIterator();
				myArrayList<Point> B = allPoints.get(j).returnIterator();
				////System.out.println("Comparing: " + A + " AND " + B);
				//now comparing each point separately.
				for(int x = 0; x < A.size(); x++) {
					for(int y = 0; y < B.size(); y++) {
						Point a = A.get(x);
						Point b = B.get(y);
						if(Point.subtract(a, b).modulus() < min_dist) {
							minPoints = new Pair<Point, Point>(a,b);
							min_dist = Point.subtract(a,b).modulus();
						}
					}
				}
			}
			
		}
		Point[] toBeReturned = new Point[2];
		toBeReturned[0] = minPoints.a;
		toBeReturned[1] = minPoints.b;
		return toBeReturned;
	}
	
}