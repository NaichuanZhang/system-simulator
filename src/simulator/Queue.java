package simulator;

public class Queue<T> extends Event {
    
    private Node front = null; 
    private Node rear = null; 
    
    public class Node { 
        public T item; 
        public Node next; 
        
        // constructors 
        public Node() { 
            item = null; 
            next = null; 
        } 
        
        public Node(T n) { 
            item = n; 
            next = null; 
        } 
        
        public Node(T n, Node p) { 
            item = n; 
            next = p;         
        } 
    }
    
   public void initqueue (T event_item){
	 Node node_item = new Node(event_item);
	 Queue.front = node_item;
	 
   }
}