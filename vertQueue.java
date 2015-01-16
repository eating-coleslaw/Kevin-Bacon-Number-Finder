
class vertQueue { //adapted from your WormBody solution
	private vertNode last;
	private vertNode first;

	public vertQueue() {
		last = null;
		first = null;
	}
	
  public void addToEnd( vertNode v ) { // adds v to the end of the queue
    if( first == null ) {
    	last = first = v;
    	return;
    }
    last.setNext( v );
    last = v;
  }

  public vertNode rmFirst(){ //pops and returns the node at the front of the queue
    	vertNode v = first;
	    first = first.getNext();    
	    v.setNext( null );
	    return v;
  }

  public boolean empty() { return first == null; }
  public vertNode getLast() { return last; }
  public vertNode getFirst() { return first; }

}
