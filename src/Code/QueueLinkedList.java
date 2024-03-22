/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author Lenovo
 */
public class QueueLinkedList {
    public int nomer;
    public String antrian;
    public QueueLinkedList next;
    
    public QueueLinkedList(int nomer, String antrian) {
        this.nomer = nomer;
        this.antrian = antrian;
        this.next = null;
    }
}
