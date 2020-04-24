Assignment 6
ReadMe
Varun Desai
2018EE10511

The have implemented the whole assignment mainly from the class graph. I have also implemnted my own ArrayList for this. I have imported RedBlackTree, Linked List from previous assignment.
My graph is basically an list of all vertexes of the graph. And also It contains list of all edges. In the vertex I have stored the corresponding triangle, and in the corresponding edge (of the graph) I have stored the edge with which it is connected to a different triangle.
Now I explain how I have implemented each query.
Inside Graph there are following data structure:
	RBTree<String, GraphVertex> vertexTree :- RBTree of all vertexes, keyed on .toString() of corresponding vertex.
	RBTree<String, Point> pointTree :- RBTree of all vertexes, keyed on the correspoding Point.toString(). So basically one particular node contains an arraylist of all points.
	VertexList
	edgeList

1. ADD_TRIANGLE:
	creates new triangle with given vertices using the Graph.Insert(Trinagle T) function. It creates a new vertex corresponding to the fiven triangle and adds it to the vertex list. It is followed by the addition of the respective edges. To add edges I traverse over the vertex list and check if those triangle alse have that edges(of the triangle), if the do, the adjacency list of both the vertexes are updated.
The time complexity is O(N), where N = number of triangles already existing

2. TYPE_MESH:
	Solves it using the function Graph.updateType().
Initially it assumes that the Graph is proper. And then traverses over each vertex and checks each edge. If the edge is shared by more than two triangles, the graph is improper and loop is broken. If the edge is shared by less than 2 triangles it is semiproper.
The time complexity is O(N), where N = number of triangles already existing

3. COUNT CONNECTED COMPONENTS>
	I have solved this using depth first search. It iterates over the vertexList, and then does dfs starting from that vertex, marking every node. And then looks for vertexes in the List that are not marked. O(N), where N = number of triangles already existing 
4. BOUNDARY_EDGES
	Implements it using Graph.boundary_edges().
Basically traverses over each triangle and finds edges that are shared by only one triangle.
O(N), where N = number of triangles already existing

5. NEIGHBOURS OF TRIANGLE
	First, searches for the triangle in the redBlackTree. 
basicallt return the adjacency list of the triangle. Time complexity is O(log N). N = number of triangles.

6. EDGE_NEIGHBOUR_TRIANGLE
Searches for the triangle in the redblack tree, and then returns its edges.
O(log N). N = number of triangles.
	
7. VERTEX NEIGHBOUR TRIANGLE
Searches for the triangle in the redblack tree, and then returns its points.
O(log N). N = number of triangles.  

8. EXTENDED NEIGHBOUT TRIANGLE
Searches for the points in the triangle in pointTree and then returns all commonTriangle.
Timecomplexity= O(log N) (for searching triangle) + O(log N) for searching point = O(log N)

9. IS CONNECTED
Searches for the triangle in the redblack tree. O(log N).
Starts with this vertex and then does dfs. If we reach the other triangle, then they are connected. Thus worst case complexity = O(N).

10. INCIDENT TRIANGLES
Searches for point in Tree. Return triangles. 
Time Complexity is O(log N).

11. EDGE NEIGHBOURS OF POINT
Searches for point in tree and then figures out which edges it is a part of.
Time Complexity O(log N).

12. FACE NEIGHBOURS OF POINT
Same as incident triangle.

13.TRIANGLE NEIGHBOUR OF EDGE:
Traverses over the whole graph. Checks if triangle contains that edge. O(N).

14.MAXIMUM DIAMETER:
	First I have made a function which calculates the eccentricity of the vertex (it does this using Breadth First Search. The eccentricity of a particular vertex is defined as the shortes path between it and the farthest vertex. So basically it finds the graph with maximum number of vertexes and then finds eccentricity for each point and then return the maximum eccentricity.
Finding eccentricity: O(N).
Finding graph with maximum triangles: O(N).
now we find eccentricity a total of N times. So the time complexity is O(N^2).

15. CENTROID:
	does dfs over every element stores every point and finds centroid by calculating average. It takes O(N) time.
16. CENTROID OF COMPONENT
	does search in rbtree for that component and then basically does the same this as centroid. Takes O(N) time.
17. CLOSEST COMPONENT
	I have done this by brute fore.
First of all, it creates arraylists of points which are in different components. This takes O(N) time.
And then it finds distance between every pair. This takes O(N^2) time.
18.NEIGHBOUR OF POINT
Searches for point in rbtree and then deduces which all triangles it is part of.
