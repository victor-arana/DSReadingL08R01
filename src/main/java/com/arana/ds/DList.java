package com.arana.ds;

/**
 * @(#)DList.java Doubly linked list with nodes of type DNode storing strings
 * 
 * @author Víctor José Arana Rodríguez
 * @since 2013/4/29
 * @version 2.00 2014/9/13
 */

public class DList {

	protected int size; // number of elements
	protected DNode header, trailer; // sentinels

	/**
	 * Constructor that creates an empty list with header and trailer pointing
	 * to each other
	 */
	public DList() {
		this.size = 0;
		this.header = new DNode(null, null, null); 			// create header
		this.trailer = new DNode(null, this.header, null);  // create trailer
		this.header.setNext(this.trailer); 					// make header and trailer to
															// point to each other.
	}

	/**
	 * Returns the number of elements in the list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Returns whether the list is empty
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Returns the first node of the list
	 */
	public DNode getFirst() throws IllegalStateException {
		if (this.isEmpty())
			throw new IllegalStateException("List is empty");
		return this.header.getNext();
	}

	/**
	 * Returns the last node of the list
	 */
	public DNode getLast() throws IllegalStateException {
		if (isEmpty())
			throw new IllegalStateException("List is empty");
		return this.trailer.getPrev();
	}

	/**
	 * Returns the node before the given node v. An error occurs if v is the
	 * header
	 */
	public DNode getPrev(DNode v) throws IllegalArgumentException {
		if (v == header)
			throw new IllegalArgumentException(
					"Cannot move back past the header of the list");
		return v.getPrev();
	}

	/**
	 * Returns the node after the given node v. An error occurs if v is the
	 * trailer
	 */
	public DNode getNext(DNode v) throws IllegalArgumentException {
		if (v == trailer)
			throw new IllegalArgumentException(
					"Cannot move forward past the trailer of the list");
		return v.getNext();
	}

	/**
	 * Inserts the given node z before the node v. 
	 * An error occurs if v is the header. 
	 * @param v actual node
	 * @param z given node
	 * @throws IllegalArgumentException
	 */
	public void addBefore(DNode v, DNode z)	throws IllegalArgumentException{
		DNode u = this.getPrev(v);	// Gets a reference to the node's previous node
		z.setPrev(u);
		z.setNext(v);
		v.setPrev(z);
		u.setNext(z);
		this.size++;
	}
	
	/**
	 * Inserts the given node z after the given node v.
	 * An error occurs if v is the trailer
	 * @param v actual node
	 * @param z given node
	 * 
	 * @author Víctor José Arana Rodríguez
	 * @since 14/09/13
	 */
	public void addAfter(DNode v, DNode z) throws IllegalArgumentException{
		DNode w = this.getNext(v);	// Gets a reference to the node's next node
		z.setPrev(v);
		z.setNext(w);
		w.setPrev(z);
		v.setNext(z);
		this.size++;
	}
	
	/**
	 * Inserts the given node v at the head of the list.
	 * @param v given node
	 * 
	 * @author Víctor José Arana Rodríguez
	 * @since 14/09/13
	 */
	public void addFirst(DNode v){
		addAfter(header, v);
	}
	
	/**
	 * Inserts the given node at the tail of the list.
	 * @param v
	 * 
	 * @author Víctor José Arana Rodríguez
	 * @since 14/09/13
	 */
	public void addLast(DNode v){
		addBefore(trailer,v);
	}
	
	/**
	 * Removes the given node v from the list.
	 * An error occurs if v is the header or trailer
	 * @param v Node to be removed
	 * 
	 * @author Víctor José Arana Rodríguez
	 * @since 2014/09/14
	 */
	public void remove(DNode v){
		DNode u = getPrev(v);
		DNode w = getNext(v);
		// Link out v
		w.setPrev(u);
		u.setNext(w);
		// null out the fields of v
		v.setPrev(null);
		v.setNext(null);
		// Decrement the node count.
		this.size--;
	}
	
	/**
	 * Returns whether a given node has a previous node
	 * @param v Given node
	 * @return Whether a given node has a previous node
	 * 
	 * @author Víctor José Arana Rodríguez
	 * @since 2014/09/14
	 */
	public boolean hasPrev(DNode v){
		return v != header;
	}
	
	/**
	 * Returns whether a given node has a next node
	 * @param v Given node
	 * @return Whether a given node has a next node
	 * 
	 * @author Víctor José Arana Rodríguez
	 * @since 2014/09/14
	 */
	public boolean hasNext(DNode v){
		return v != trailer;
	}
	
	public String toString(){
		String s = "[";
		DNode v = header.getNext();
		while(hasNext(v)){
			s += v.getElement();
			v = v.getNext();
			if(hasNext(v)){
				s += ",";
			}
		}
		s += "]";
		return s;
	}
}