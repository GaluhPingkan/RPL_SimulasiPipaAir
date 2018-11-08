/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulasi_pipaair;

/**
 *
 * @author lenovo
 */
public class LinkedList {
    private ListNode head;
    private int size;
    private String nama;
    
    public LinkedList() {
        head = new ListNode();
        head.setPrev(head);
        head.setNext(head);
    }

    public ListNode addFirst(Object elemen) {
        return addBefore(elemen, head.getNext());
    }

    public ListNode addLast(Object elemen) {
        return addBefore(elemen, head);
    }

    public ListNode addBefore(Object elemen, ListNode bantu) {
        ListNode baru = new ListNode(elemen);
        baru.setNext(bantu);
        baru.setPrev(bantu.getPrev());
        bantu.setPrev(baru);
        baru.getPrev().setNext(baru);
        size++;
        return baru;
    }
    
    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        String isi = "";
        ListNode pointer = head.getNext();
        while (pointer != head) {
            isi += pointer.getData() + "\n";
            pointer = pointer.getNext();
        }
        return isi;
    }
     public ListNode remove(ListNode item) {
        ListNode point = item;
        point.getPrev().setNext(point.getNext());
        point.getNext().setPrev(point.getPrev());
        size--;
        return point;
    }

    public ListNode removeFirst() {
        return remove(head.getNext());
    }

    public ListNode removeLast() {
        return remove(head.getPrev());
    }

    public boolean free_remove(Object data) {
        ListNode pointer = head.getNext();
        while (pointer != head) {
            if (((Comparable) pointer.getData()).compareTo(data.toString()) == 0) {
                remove(pointer);
                return true;
            }
            pointer = pointer.getNext();
        }
        return false;
    }

    public String getNama() {
        return nama;
    }
    
    public boolean isEmpty () {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }
            
}
