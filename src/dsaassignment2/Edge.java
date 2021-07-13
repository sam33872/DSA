/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment2;

/**
 *
 * @author 184504
 */
public class Edge
{
    // instance variables - replace the example below with your own
    private String name;
    private Vertex startPoint;
    private Vertex endPoint;

    /**
     * Constructor for objects of class Edge
     */
    public Edge(Vertex startPoint, Vertex endPoint, String name)
    {
        this.name = name;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    
    /**
     * Getter for variable name
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Setter for variable name
     * @param name 
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Getter for variable startPoint
     * @return startPoint
     */
    public Vertex getStart(){
        return startPoint;
    }
    
    /**
     * Getter for variable endPoint
     * @return endPoint
     */
    public Vertex getEnd(){
        return endPoint;
    }

}
