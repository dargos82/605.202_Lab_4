
/** Class LinkedList would be the "parent" list that would hold data of type Node.
 * 
 * Ref: https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
 * 
 */
public class LinkedList {
	
	public Node data;
	private LinkedList next;
	private LinkedList head;
	
	LinkedList() {
		
		this.data = null;
		this.next = null;
		
	}
	
	public LinkedList(Node orderedList) {
		
		this.data = orderedList;
		this.next = null;
	}


	public LinkedList insert(LinkedList list, Node data) 
    { 
        // Create a new node with given data 
        LinkedList newList = new LinkedList(data); 
         
   
 
        if (list.head == null) { 
            list.head = newList; 
        } 
        else { 
   
            LinkedList last = list.head; 
            while (last.next != null) { 
                last = last.next; 
            } 
   
            // Insert the new_node at last node 
            last.next = newList; 
        } 
   
        // Return the list by head 
        return list; 
    } 

}
