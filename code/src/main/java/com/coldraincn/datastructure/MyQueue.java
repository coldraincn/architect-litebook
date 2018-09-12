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
    private Node head=new Node(null,null);;
    private Node tail=new Node(null,null);;
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
        size--;
        return node.t;
        
    }
    public Iterator iterator(){
        return new MyIterator();
    }
    public class MyIterator implements Iterator<T>{
        Node node=head.next;
        @Override
        public boolean hasNext(){
            return node!=null;
        }

        @Override
        public T next(){
            if(node!=null){
                T vaule=node.t;
                node=node.next;
                return vaule;
            }
            return null;

        }
        
        
    }
    public static void main(String[] args){
        MyQueue<String> list = new MyQueue<>();
        list.enqueue("aa");
        list.enqueue("bb");
        list.enqueue("cc");
        
        System.out.println("===========remove");
        String dvalue = list.dequeue();
        System.out.println(dvalue);
        System.out.println("===========remove");
        for(String value : list){
            System.out.println(value);
        }
       
}
}