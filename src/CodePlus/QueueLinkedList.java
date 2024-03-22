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
public class QueueLinkedList {
    public String nomer;
    public QueueLinkedList next;
    
    public QueueLinkedList(String nomer) {
        this.nomer = nomer;
        this.next = null;
    }
}
