
public class vertNode {
  private String v_id;
  private vertNode next;

  public vertNode( String id ) { 
    v_id = id;
    next = null;
  }

  public String getID() { return v_id; }
  public void setNext( vertNode v ) { next = v; }
  public vertNode getNext() { return next; }
}