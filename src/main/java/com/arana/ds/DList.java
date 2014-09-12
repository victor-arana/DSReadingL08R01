package com.arana.ds;

/**
 * @(#)DList.java
 * Doubly linked list with nodes of type DNode storing strings
 *
 * @author Víctor José Arana Rodríguez
 * @version 1.00 2013/4/29
 */

public class DList {
	
	protected int size; 				// number of elements
	protected DNode header, trailer;	// sentinels
	
    /**
     * Constructor that creates an empty list with header and trailer pointing
     * to each other
     */
    public DList() {
    	this.size = 0; 
    	this.header = new DNode(null,null,null);		  // create header
    	this.trailer = new DNode(null,this.header,null);  // create trailer
    	this.header.setNext(this.trailer);				  // make header and trailer to  
    													  // point to each other.
    }
    
    /**
     * Returns the number of elements in the list 
     */
    public int size(){
    	return this.size;
    }
    
    /** 
     * Returns whether the list is empty 
     */
    public boolean isEmpty(){
    	return (size == 0);
    }
    
    /** 
     * Returns the first node of the list 
     */    
    public DNode getFirst() throws IllegalStateException{
    	if(this.isEmpty()) throw new IllegalStateException("List is empty");
    	return this.header.getNext();
    }
    
    /** 
     * Returns the last node of the list 
     */
    public DNode getLast() throws IllegalStateException{
    	if(isEmpty()) throw new IllegalStateException("List is empty");
    	return this.trailer.getPrev();
    }
    
    /** 
     * Returns the node before the given node v. An error occurs if v
     * is the header 
     */
    public DNode getPrev(DNode v) throws IllegalArgumentException{
    	if(v==header) throw new IllegalArgumentException
    		("Cannot move back past the header of the list");
    	return v.getPrev();    		
    }
    
    /** 
     * Returns the node after the given node v. An error occurs if v
     *  is the trailer 
     */
    public DNode getNext(DNode v) throws IllegalArgumentException{
    	if(v==trailer) throw new IllegalArgumentException
    		("Cannot move forward past the trailer of the list");
    	return v.getNext();
    }
    
    public void addBefore(DNode v, DNode z) throws IllegalArgumentException{
    	
    }
}