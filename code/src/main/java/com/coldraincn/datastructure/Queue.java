package com.coldraincn.datastructure;
import java.util.Iterator;
public class MyQueue<T> implements Iterable<T>{
    private class Node{
        T t;
        Node next;
        Node(T t,Node next){
            this.t=t;
            this.next=next;
        }
    }
    private Node head;
    private Node tail;
    private int size=0;
    public int Size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void enqueue(T value){
        Node node = new Node(value,null);
        if(size==0){
            head.next=node;
            tail.next=node;
            size++;
        }else{
            Node tmp = tail.next;
            tmp.next=node;
            tail.next=node;
            size++;
        }
    }
    public T dequeue(){
        
        if(size==0){
            return null;
        }
        Node node=head.next;
        head.next=node.next;
        if(size==1){
            tail.next=null;
        }
        return node.t;
        size--;
    }
    public Iterator iterator(){
        return new MyIterator();
    }
    public class MyIterator implements Iterator<T>{
        
    }
}