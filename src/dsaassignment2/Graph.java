/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment2;

import java.util.*;
/**
 *
 * @author 184504
 */
public class Graph
{
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    
    /**
     * Constructor for objects of class Graph
     * @param vertices ArrayList of Vertex objects
     * @param edges ArrayList of Edge objects
     */
    public Graph(ArrayList<Vertex> vertices, ArrayList<Edge> edges)
    {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        this.vertices = vertices;
        this.edges = edges;
    }
    
    /**
     * Constructor for Graph without inputting two ArrayList
     * Creates a completely blank graph
     */
    public Graph(){
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }
    
    /***  Insert a new vertex with name n into the graph. Return the new vertex object
       *  @param n String
       *  @return the new Vertex
       */
    public Vertex insertVertex(String n){
        Vertex newVert = new Vertex(n);
        vertices.add(newVert);
        return newVert;
    }
    
    /***  Remove the given vertex from the graph. The name of the vertex is returned, or null if the
       *  graph does not contain the vertex.
       *  @param v Vertex
       *  @return the name of the vertex or null.
       */  
    public String removeVertex(Vertex v){
        String name = v.getName();
        if(vertices.remove(v)){
            return name;
        }
        else{
            return null;
        }
    }
    
    /***  Build a new edge with end vertices v and w and name n and insert into the graph. Return the new Edge object.
       *  NB: The vertices u and v must already be in the graph.
       *  @param v Vertex
       *  @param w Vertex
       *  @param n String
       *  @return the new Edge
       */
    public Edge insertEdge(Vertex v, Vertex w, String n){
        Edge newEdge = new Edge(v,w,n);
        edges.add(newEdge);
        return newEdge;
    }
    
    /***  Remove the edge e from the graph. The name of the edge is returned (or null if the edge is not
       *  in the graph).
       *  @param e the edge to be removed
       *  @return the name or null if e does not exist
       */
    public String removeEdge(Edge e){
        String name = e.getName();
        if(edges.remove(e)){
            return name;
        }
        else{
            return null;
        }
    }
    
    /***  Return the endpoint vertex of edge e that is 'opposite' its other endpoint vertex v. Return null if e
       *  does not exist or does not have endpoint v
       *  @param e Edge
       *  @param v Vertex
       *  @return a vertex or null
       */
    public Vertex opposite(Edge e, Vertex v){
        if(!edges.contains(e)){
            return null;
        }
        else if(e.getStart().getName().equals(v.getName())){
            return e.getEnd();
        }
        else if(e.getEnd().getName().equals(v.getName())){
            return e.getStart();
        }
        else{
            return null;
        }
    }
    
    /***  Return a collection containing of all of the vertices in the graph.
       *  @return a list of vertices
       */
    public ArrayList<Vertex> vertices(){
        return vertices;
    }
    
    /***  Return a collection of all of the edges in the graph.
       *  @return a list of edges
       */
    public ArrayList<Edge> edges(){
        return edges;
    }
    
    /***  Checks whether two vertices are adjacent (i.e. joined by a single edge) or not.
       *  @param v a vertex
       *  @param w a vertex
       *  @return true if v and we are adjacent and false otherwise.
       **/
    public boolean areAdjacent(Vertex v, Vertex w){
        boolean ret = false;
        int i = 0;
        while(i < edges.size()){
            Edge test = edges.get(i);
            if(test.getStart() == v)
            {
                if(test.getEnd() == w){
                    ret = true;
                    i = edges.size();
                }
            }
            if(test.getEnd() == v)
            {
                if(test.getStart() == w){
                    ret = true;
                    i = edges.size();
                }
            }
            i++;
        }
        return ret;
    }
    
    /***  Finds and returns the set of edges that are incident to a given vertex.
       *  @param v the vertex
       *  @return a list of edges
       */
    public ArrayList<Edge> incidentEdges(Vertex v){
        ArrayList<Edge> newList = new ArrayList<Edge>();
        for(int i = 0; i < edges.size(); i++){
            Edge test = edges.get(i);
            if((test.getStart() == v) || (test.getEnd() == v)){
                newList.add(test);
            }
        }
        return newList;
    }
    
    /***  Rename vertex v as n; returns the old vertex name
       *  @param v a vertex
       *  @param n the new name
       *  @return the old edge name
       */
    public String rename(Vertex v, String n){
        int index = vertices.indexOf(v);
        Vertex vert = vertices.get(index);
        String old = vert.getName();
        vert.setName(n);
        vertices.set(index,vert);
        return old;
    }
    
    /***  Rename edge e as n; returns the old edge name
       *  @param e an edge
       *  @param n the new name
       *  @return the old edge name
       */
    public String rename(Edge e, String n){
        int index = edges.indexOf(e);
        Edge edge = edges.get(index);
        String old = edge.getName();
        edge.setName(n);
        edges.set(index,edge);
        return old;
    }
    
    /***
     * Breadth-first search through graph starting at Vertex v
     * @param v Vertex to begin search from
     */
    public void bftraversal(Vertex v){
        ArrayList<Edge> alreadyFound = new ArrayList<>();
        ArrayList<Vertex> nodes = new ArrayList<>();
        nodes.add(v);
        while(!nodes.isEmpty()){
            Vertex test = nodes.get(0);
            if(test.isVisited() == false){
                System.out.println("Visited " + test.getName());
                test.visit();
                int index = vertices.indexOf(test);
                nodes.remove(0);
            }
            
            ArrayList<Edge> paths = incidentEdges(test);
            for(int i = 0; i < paths.size(); i++){
                Edge path = paths.get(i);
                if(!(alreadyFound.contains(path))){
                    Vertex end = opposite(path, test);
                    nodes.add(end);
                }
            }
            alreadyFound.addAll(paths);
            nodes.remove(null);
        }
    }
    
    /***
     * Breadth-first search through graph
     * To work with or without edges
     */
    public void bftraversal(){
        for(int i = 0; i < vertices.size(); i++){
            Vertex node = vertices.get(i);
            System.out.println("Visited: " + node.getName());
        }
    }
    
    /***
     * Generates a list of reachable vertices from point v
     * @param v Starting Vertex
     * @return ArrayList of Vertex filled with reachable vertices
     */
    public ArrayList<Vertex> allReachable(Vertex v){
        ArrayList<Vertex> reachable = searchGraph(v);
        return reachable;
    }
    
    /***
     * Check to see if all Vertices are connected by edges
     * @return true if all are connected to edges, false otherwise
     */
    public boolean allConnected(){
        ArrayList<Vertex> connected = searchGraph(vertices.get(0));
        if(connected.size() == vertices.size()){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Private method used in multiple advanced methods
     * @param v
     * @return an array list full of all the connected vertices in the graph
     */
    private ArrayList<Vertex> searchGraph(Vertex v){
        ArrayList<Vertex> found = new ArrayList<>();
        ArrayList<Edge> alreadyFound = new ArrayList<>();
        ArrayList<Vertex> nodes = new ArrayList<>();
        nodes.add(v);
        while(!nodes.isEmpty()){
            Vertex test = nodes.get(0);
            if(test.isVisited() == false){
                System.out.println("Visited " + test.getName());
                found.add(test);
                test.visit();
                int index = vertices.indexOf(test);
                nodes.remove(0);
            }
            
            ArrayList<Edge> paths = incidentEdges(test);
            for(int i = 0; i < paths.size(); i++){
                Edge path = paths.get(i);
                if(!(alreadyFound.contains(path))){
                    Vertex end = opposite(path, test);
                    nodes.add(end);
                }
            }
            alreadyFound.addAll(paths);
            nodes.remove(null);
        }
        return found;
    }
    /***
     * Finds most efficient route from u to v
     * Had to research how to do this and used the below link as an algorithm 
     * to base my method off
     * <http://www.gitta.info/Accessibiliti/en/html/Dijkstra_learningObject1.html>
     * @param u Starting position
     * @param v End position
     * @return ArrayList of Vertices that represent the shortest path of 
     *         vertices from u to v
     */
    public ArrayList<Edge> mostDirectRoute(Vertex u, Vertex v){
        ArrayList<Integer> distance = new ArrayList<>();
        ArrayList<Vertex> nodesReference = new ArrayList<>();
        ArrayList<Vertex> nodes = new ArrayList<>();
        ArrayList<Vertex> previous = new ArrayList<>();
        ArrayList<Edge> route = new ArrayList<>();
        
        // Set initial values of nodes
        for(int i = 0; i < vertices.size(); i++){
            distance.add(1000);
            nodes.add(vertices.get(i));
            nodesReference.add(vertices.get(i));
            previous.add(null);
        }
        distance.set(vertices.indexOf(u), 0);
        // while nodes is not empty
        while(!nodes.isEmpty()){
            
            int pos = 0;
            int index = nodesReference.indexOf(nodes.get(0));
            int dist = distance.get(index);
            for(int j = 1; j < nodes.size(); j++){
                if(distance.get(j) < dist){
                    pos = j;
                }
            }
            Vertex x = nodes.get(pos);
            nodes.remove(x);
            
            // Find neighbours
            ArrayList<Edge> paths = incidentEdges(x);
            ArrayList<Vertex> oppo = new ArrayList<>();
            for(int k = 0; k < paths.size(); k++){
                Vertex opp = opposite(paths.get(k), x);
                oppo.add(opp);
            }
            
            // for each neighbour
            for(int l = 0; l < oppo.size(); l++){
                int alt = distance.get(nodesReference.indexOf(x)) + 1;
                if(alt < distance.get(nodesReference.indexOf(oppo.get(l)))){
                    distance.set(nodesReference.indexOf(oppo.get(l)), alt);
                    previous.set(nodesReference.indexOf(oppo.get(l)), x);
                }
            } 
        }
        int a = 0;
        int found = 0;
        int pos = nodesReference.indexOf(v);
        Vertex node = nodesReference.get(pos);
        // backtrack through graph and add the path to route
        while(a == 0){
            if((previous.isEmpty())||(pos < 0)){
                a = 1;
            }
            else{
                Vertex prev = previous.get(pos);
                if(prev == u){
                    a = 1;
                    found = 1;
                }
                Edge between = getEdge(node,prev);
                route.add(between);
                node = prev;
                pos = nodesReference.indexOf(prev);
            }
            
        }
        // if the nodes aren't connected return null
        // if they are connected, return route
        if(route.isEmpty()){
            return null;
        }
        
        else{
            if(found == 1){
                return route;
            }
            else{
                return null;
            }
            
        }
    }
    
    /**
     * For testing purposes only
     * @param i 
     * @return a vertex to be used in a method call
     */
    public Vertex getVertex(int i){
        return vertices.get(i);
    }
    
    /**
     * A minor manipulation of areAjacent code to get the edge 
     * connecting two vertices
     * @param v
     * @param w
     * @return the edge connecting nodes v and w
     */
    public Edge getEdge(Vertex v, Vertex w){
        Edge ret = null;
        int i = 0;
        while(i < edges.size()){
            Edge test = edges.get(i);
            if(test.getStart() == v)
            {
                if(test.getEnd() == w){
                    ret = test;
                    i = edges.size();
                }
            }
            if(test.getEnd() == v)
            {
                if(test.getStart() == w){
                    ret = test;
                    i = edges.size();
                }
            }
            i++;
        }
        return ret;
    }
}
