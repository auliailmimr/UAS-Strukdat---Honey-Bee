/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodePlus;

/**
 *
 * @author Lenovo
 */
public class Queue1 {
    private QueueLinkedList front;
    private QueueLinkedList rear;
    private int nItems;
    
    public Queue1() {
        QueueLinkedList linkQueue = null;
        rear = linkQueue;
        front = linkQueue;
        nItems = 0;
    }
    
    public void insert(String nomer) {
        QueueLinkedList temp = new QueueLinkedList(nomer);
        if (rear == null) {
            QueueLinkedList linkQueue = temp;
            rear = linkQueue;
            front = linkQueue;
            return;
        }
        rear.next = temp;
        rear = temp;
    }
    
    public QueueLinkedList remove() {
        if (front == null) {
            return null;
        }
        QueueLinkedList temp = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return temp;
    }
    
    public void displayQueue() {
        System.out.println("Queue (front-->rear) :");
        for (QueueLinkedList current = front; current != null; current = current.next) {
            System.out.println(current.nomer);
        }
        System.out.println("");
    }
    
    public boolean isEmpty() {
      return (nItems == 0);
   }
}
