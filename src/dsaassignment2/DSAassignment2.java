/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment2;

import java.util.ArrayList;

/**
 *
 * @author 184504
 */
public class DSAassignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph railWay = new Graph();
        railWay.insertVertex("Brighton");
        railWay.insertVertex("London");
        railWay.insertVertex("Devon");
        railWay.insertVertex("Manchester");
        railWay.insertVertex("Cornwall");
        railWay.insertVertex("Cardiff");
        railWay.insertVertex("Liverpool");
        railWay.insertVertex("Paris");
        railWay.insertEdge(railWay.getVertex(0), railWay.getVertex(1), "Brighton-London Line");
        railWay.insertEdge(railWay.getVertex(1), railWay.getVertex(3), "London-Manchester Line");
        railWay.insertEdge(railWay.getVertex(3), railWay.getVertex(6), "Manchester-Liverpool Line");
        railWay.insertEdge(railWay.getVertex(0), railWay.getVertex(2), "Brighton-Devon Line");
        railWay.insertEdge(railWay.getVertex(2), railWay.getVertex(4), "Devon-Cornwall Line");
        railWay.insertEdge(railWay.getVertex(2), railWay.getVertex(5), "Devon-Cardiff Line");
        ArrayList<Edge> edges = railWay.mostDirectRoute(railWay.getVertex(0), railWay.getVertex(7));
        /*
        For valid path use this:
        ArrayList<Edge> edges = railWay.mostDirectRoute(railWay.getVertex(0), railWay.getVertex(6));
        */
        if(edges == null){
            System.out.println("No path found");
        }
        else{
            for(int i = 0; i < edges.size(); i++){
                System.out.println(edges.get(i).getName());
            }
        }
        
    }   
    
    /* Code to test bftraversal(Vertex v)
        Graph railWay = new Graph();
        railWay.insertVertex("Brighton");
        railWay.insertVertex("London");
        railWay.insertVertex("Devon");
        railWay.insertVertex("Manchester");
        railWay.insertVertex("Cornwall");
        railWay.insertVertex("Cardiff");
        railWay.insertVertex("Liverpool");
        railWay.insertEdge(railWay.getVertex(0), railWay.getVertex(1), "Brighton-London Line");
        railWay.insertEdge(railWay.getVertex(1), railWay.getVertex(3), "London-Manchester Line");
        railWay.insertEdge(railWay.getVertex(3), railWay.getVertex(6), "Manchester-Liverpool Line");
        railWay.insertEdge(railWay.getVertex(0), railWay.getVertex(2), "Brighton-Devon Line");
        railWay.insertEdge(railWay.getVertex(2), railWay.getVertex(4), "Devon-Cornwall Line");
        railWay.insertEdge(railWay.getVertex(2), railWay.getVertex(5), "Devon-Cardiff Line");
        railWay.bftraversal(railWay.getVertex(0));
    */
}
