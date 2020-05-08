/*
 * File: OrderedList.java
 * Class which holds a linked list, as well as methods that can add a new node, 
 * delete a node, reverse the sorting of the list, clear the lsit, and check if 
 * the list is empty. Also contains an inner class that defines a Node object.
 */
package linkedlist;

/**
 * Creates an ordered linked list that is sorted by ascending or descending 
 * order. New nodes can be added (in the correct order) and deleted.
 * @author Bryan Consuegra
 * @param <E>
 */

public class OrderedList<E extends Comparable<E>> {

    /**
     * Inner class for object Node.
     */
    class Node{
        //Declare generic object "info" and Node object "next".
        E info;
        Node next;
                
        /**
         * Constructor for Node, setting generic object "info" to generic object
         * parameter "x".
         * @param x Generic object used to set Node "info".
         */
        Node (E x){
            info = x;
        }
    }
    
    //Declare Node "head".
    private Node head;
    private boolean sortAscending = true;
    
    /**
     * Null constructor for OrderedList, setting Node "head" to null.
     */
    public OrderedList(){
        head = null;
    }
      
    /**
     * Adds a node to the end of the linked list with info as generic object 
     * "x".
     * @param x Generic object to be added as the new node's info.
     */
    public void insertAfter(E x){
        //The new Node to be added is initialized with its info set to the 
        //generic object parameter x.
        Node add = new Node(x);
        //Temporary nodes temp1, temp2, and prevTemp are initialized to the head 
        //node.
        Node temp1 = head;
        Node temp2 = head;
        Node prevTemp = head;
        //Initialize counter integer listCount to zero.
        int listCount = 0;
        //If list is empty...
        if (head == null){
            //The new node is placed at the start of the list
            head = add;
        } 
        //If the list is populated...
        else{
            //Initialize counter integer tempCount to 0 and boolean 
            //listCountChanged to false.
            int tempCount = 0;
            boolean listCountChanged = false;
            //While there are still unchecked elements in the list...
            while(temp1 != null){
                //If boolean sortAscending is true...
                if(sortAscending){
                    //If the Node being added is less than the current temp Node
                    if(add.info.compareTo(temp1.info) == 1){
                        //listCount is set to the counter tempCount, and 
                        //listCountChanged is set to true.
                        listCount = tempCount;
                        listCountChanged = true;
                    }
                }
                //Else if boolean sortAscending is false...
                else{
                    //If the Node being added is more than the current temp Node
                    if(add.info.compareTo(temp1.info) == -1){
                        //listCount is set to the counter tempCount, and 
                        //listCountChanged is set to true.
                        listCount = tempCount;
                        listCountChanged = true;
                    }
                }
                //Move to the next Node in temp1.
                temp1 = temp1.next;
                //Increment tempCount by 1
                tempCount++;
            }
            
            //Reset tempCount to zero
            tempCount = 0;
            
            //While counter tempCount is less than or equal to listCount...
            while(tempCount <= listCount){
                //If counter listCount is equal to 0 and listCount was not 
                //changed...
                if(listCount == 0 && !listCountChanged){
                    //Add the new Node add to the front of the linked list, now 
                    //making it the head.
                    add.next = head;
                    head = add;
                }
                //Else if counter tempCount is less than listCount...
                else if(tempCount < listCount){
                    //Move to the next Node in temp2.
                    temp2 = temp2.next;
                }
                //If counter tempCount is equal to listCount...
                else{
                    //The new Node add is added after the highest/lowest node in 
                    //the list, depending on sortAscending's state.
                    prevTemp = temp2;
                    add.next = prevTemp.next;
                    prevTemp.next = add;
                }
                //Counter tempCount increases by 1
                tempCount++;
            }
        }
    }
    
    /**
     * Checks which node in the linked list is the last node.
     * @return Node temp, which is the last node in the linked list.
     */
    private Node lastNode(){
        //If the linked list is empty...
        if (head == null){
            //Return no node, null
            return null;
        } 
        //If the list is populated...
        else{
            //Create another node temp.
            Node temp = head;
            //While the loop has not reached the end of the list...
            while (temp.next != null){
                //Make temp equal to the next node.
                temp = temp.next;
            }
            //Return the node temp.
            return temp;
        }
    }
    
    /**
     * Method which reverses the order in which the linked list nodes are 
     * sorted.
     */
    public void reverseOrder(){
        //Initialize two nodes temp and temp2 to equal node head and null, 
        //respectively. Also initialize integer listCounter to 0.
        Node temp = head;
        Node temp2;
        int listCounter = 0;
        //While the loops has not checked all the elements in the linked list...
        while(temp != null){
            //Integer lsitCounter is incremented by one, and node temp moves to 
            //the next node in the linked list.
            listCounter++;
            temp = temp.next;
        }
        //When the program exits this loop, listCounter will hold the number of 
        //elements in the list.
        
        //Integer counter is set to listCounter - 1
        int counter = listCounter - 1;
        
        //Nested for loops which check for every element in the linked list, 
        //removes them using the deleteAfter() method, and adds a new Node after 
        //the last node in the list.
        for(int i = 0; i < listCounter; i++){
            temp = head;
            temp2 = null;
            for(int j = 0; j <= counter; j++){
                if(j < counter){
                    temp = temp.next;
                }
                else{
                    //Have Node temp2 point to temp, then remove temp from the 
                    //list.
                    temp2 = temp;
                    deleteAfter(temp.info);
                }
            }
            //Set the last node's next node to temp2, and set temp2's next node 
            //to null;
            lastNode().next = temp2;
            temp2.next = null;
            //Integer counter is decremented by 1.
            counter--;
        }
        //Boolean sortAscending is inversed.
        sortAscending = !sortAscending;
    }
    
    /**
     * Deletes Node with specified generic object value.
     * @param x Generic object which the method searches for in the linked list.
     * @return True if object was found and deleted, false if object was not 
     * found.
     */
    public boolean deleteAfter(E x){
        //If list is empty...
        if (head == null){
            //Return false
            return false;
        }
        //If list is populated...
        else{
            Node temp = head;
            Node prev = head;
            //While loop checks all nodes until either the node with object "x"
            //is found, or the end of the list is reached.
            while(temp.info != x){
                //If the whole list has been searched and a node with the 
                //specified object has not been found...
                if(temp.next == null){
                    //Return false
                    return false;
                }
                else{
                    prev = temp;
                    temp = temp.next;
                }
            }
            //If the specified node is the first element in the list...
            if(temp == head){
                //Delete the node by having it equal its own "next" node
                head = head.next;
            }
            //If the specified node is not the first element in the list...
            else{
                //Delete the node by having the previous node's "next" node set 
                //to the current node's "next" node.
                prev.next = temp.next;
            }
            //Return true
            return true;
        }
    }
    
    /**
     * Checks if the the Linked List is empty.
     * @return True if head is null, false if head is not null.
     */
    public boolean isEmpty(){
        return head == null;
    }
    
    /**
     * Clears all the elements of the linked list.
     */
    public void clear(){
        head = null;
    }
    
    @Override
    /**
     * Overriden String method that prints the objects stored in the linked list 
     * in the order they appear.
     */
    public String toString(){
        //Declare String print, used to store printed linked list.
        String print = "";
        //If the list is empty...
        if(head == null){
            //"print" displays a message sayign the list is empty.
            print = "Linked List is empty.";
        }
        //If the list is populated...
        else{
            Node temp = head;
            //Search the linked list and add each object stored in each node's 
            //"info" into the "print" String.
            while(temp != null){
                print += temp.info + " ";
                temp = temp.next;
            }
        }        
        //Return String "print"
        return print;
    }    
}
