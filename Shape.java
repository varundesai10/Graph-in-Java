

public class Shape implements ShapeInterface
{	
	Graph myGraph = new Graph();
	public Shape() {
		myGraph = new Graph();
	}
	public boolean ADD_TRIANGLE(float [] triangle_coord){
		Point p1 = new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
		Point p2 = new Point(triangle_coord[3], triangle_coord[4], triangle_coord[5]);
		Point p3 = new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
		Triangle T = new Triangle(p1,p2,p3);
		if(T.isValid()) { 
			if(myGraph.vertexTree.search(T.toString()).getValue() != null) return false; //if it already exists.
			myGraph.insert(T);
			return true;
		}
		return false;
		}
	public int TYPE_MESH(){ return myGraph.type(); }
	
	public int COUNT_CONNECTED_COMPONENTS(){return myGraph.connectedComponents();}
	
	public Triangle[] NEIGHBORS_OF_TRIANGLE(float [] triangle_coord){
		Triangle T = new Triangle(new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]),
				                  new Point(triangle_coord[3], triangle_coord[4], triangle_coord[5]),
				                  new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]));
		return myGraph.neighbors(T);
	}
	
	public EdgeInterface [] BOUNDARY_EDGES(){return myGraph.boundary_edges();}
	
	public EdgeInterface [] EDGE_NEIGHBOR_TRIANGLE(float [] triangle_coord){return myGraph.edgeNeighbours(new Triangle(new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]),
				                  new Point(triangle_coord[3], triangle_coord[4], triangle_coord[5]),
				                  new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]), -1));}
	public PointInterface [] VERTEX_NEIGHBOR_TRIANGLE(float [] triangle_coord){return myGraph.pointNeighbours(new Triangle(new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]),
				                  new Point(triangle_coord[3], triangle_coord[4], triangle_coord[5]),
				                  new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]), -1));}
	public TriangleInterface [] EXTENDED_NEIGHBOR_TRIANGLE(float [] triangle_coord){return myGraph.extendedNeighbours(new Triangle(new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]),
				                  new Point(triangle_coord[3], triangle_coord[4], triangle_coord[5]),
				                  new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]), -1));}
	public TriangleInterface [] INCIDENT_TRIANGLES(float [] point_coordinates){return myGraph.incidentTriangles(new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]));}
	
	public PointInterface [] NEIGHBORS_OF_POINT(float [] point_coordinates){return myGraph.NeighbourOfPoint(new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]));}
	
	public EdgeInterface [] EDGE_NEIGHBORS_OF_POINT(float [] point_coordinates){return myGraph.edgeNeighbourOfPoint(new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]));}
	
	public TriangleInterface [] FACE_NEIGHBORS_OF_POINT(float [] point_coordinates){ return myGraph.incidentTriangles(new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]));}
	
	public boolean IS_CONNECTED(float [] triangle_coord_1, float [] triangle_coord_2){return myGraph.isConnected(new Triangle(new Point(triangle_coord_1[0], triangle_coord_1[1], triangle_coord_1[2]),
            new Point(triangle_coord_1[3], triangle_coord_1[4], triangle_coord_1[5]),
            new Point(triangle_coord_1[6], triangle_coord_1[7], triangle_coord_1[8]), -1), new Triangle(new Point(triangle_coord_2[0], triangle_coord_2[1], triangle_coord_2[2]),
            new Point(triangle_coord_2[3], triangle_coord_2[4], triangle_coord_2[5]),
            new Point(triangle_coord_2[6], triangle_coord_2[7], triangle_coord_2[8]), -1));}
	public TriangleInterface [] TRIANGLE_NEIGHBOR_OF_EDGE(float [] edge_coordinates){ return myGraph.NeighbourOfEdge(new Edge( new Point(edge_coordinates[0], edge_coordinates[1], edge_coordinates[2]), new Point(edge_coordinates[3], edge_coordinates[4], edge_coordinates[5])));
	}
	
	public int MAXIMUM_DIAMETER(){return myGraph.maxDiameter();}
	
	public PointInterface [] CENTROID (){
		return myGraph.Centroid();
		}
	
	public PointInterface CENTROID_OF_COMPONENT (float [] point_coordinates){

		return myGraph.centroidOf(new Point(point_coordinates[0], point_coordinates[1], point_coordinates[2]));
		}
	
	public 	PointInterface [] CLOSEST_COMPONENTS(){
		return myGraph.closestComponents();
		}
}

