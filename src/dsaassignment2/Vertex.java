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
public class Vertex
{
    // instance variables - replace the example below with your own
    private String name;
    private boolean visited;

    /**
     * Constructor for objects of class Vertex
     */
    public Vertex(String name)
    {
        this.name = name;
        visited = false;
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
     * When a node is visited, the variable visited is set to true
     * This stops the same node from being visited multiple times
     */
    public void visit(){
        visited = true;
    }
    
    /**
     * Getter for variable visited
     * Used to stop same node being visited multiple times 
     * @return visited
     */
    public boolean isVisited(){
        return visited;
    }
}
