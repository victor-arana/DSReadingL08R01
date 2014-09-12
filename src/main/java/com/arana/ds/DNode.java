package com.arana.ds;

/**
 * @(#)DNode.java
 * Node of a doubly linked list of strings
 *
 * @author Víctor José Arana Rodríguez
 * @since 25/4/2013
 * @version 2.00 12/9/2014
 */
public class DNode {
	
	protected String element; // String element stored by a node
	protected DNode next, prev; // Pointers to next and previous nodes
	
    /**
     * Constructor that creates a node with given fields
     * @param element
     * @param prev
     * @param next
     */
    public DNode(String element, DNode prev, DNode next) {
    	this.element = element;
    	this.prev = prev;
    	this.next = next;    	
    }   
    
    /**
     * Returns the element of this node
     * @return
     */
    public String getElement(){
    	return element;
    }
    
    /**
     * Returns the previous node of this node
     * @return
     */
    public DNode getPrev(){
    	return prev;
    }
    
    /**
     * Returns the next node of this node
     * @return
     */
    public DNode getNext(){
    	return next;
    }
    
    /**
     * Sets the element of this node
     * @param newElemen
     */
    public void setElement(String newElement){
    	element = newElement;
    }
        
    /**
     * Sets the previous node of this node
     * @param newPrev
     */
    public void setPrev(DNode newPrev){
    	prev = newPrev;
    }
        
    /**
     * Sets the next node of this node
     * @param newNext
     */
    public void setNext(DNode newNext){
    	next = newNext;
    }    
}