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
public class ListNode {
    private Object data;
    private ListNode next;
    private ListNode prev;

    public ListNode() {
    }

    public ListNode(Object data) {
        this.data = data;
        this.next = null;
        this.prev = null;
       
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPrev() {
        return prev;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }
}
