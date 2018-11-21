package com.coldraincn.datastructure;

import java.util.Iterator;

public class MyLinkList<T> implements Iterable<T>{
    //node内部类
    private  class Node{
        T t;
        Node next;
        Node(T t,Node next){
            this.t=t;
            this.next=next;
        }
    }
    //大小
    private int size = 0;
    //头结点
    private Node head;
    public void add(T t){
        Node node=new Node(t,null);
        if(size==0){
            head=node;
            size++;
        }else{           
            node.next=head;
            head=node;
            size++;
        }
    }
    public T remove(){
        if(size==0){
            return null;
        }
        Node node = head;
        head=head.next;
        T t=node.t;
        node=null;
        size--;
        return t;
    }
    public int size(){
        return size;
    }
    @Override
    public Iterator iterator(){
        return new LinkIterator();
    }
    private class LinkIterator implements Iterator<T>{
        Node nextNode=head;
        @Override
        public boolean hasNext(){
            return nextNode!=null;
        }
        @Override
        public T next(){
            if(nextNode!=null){
                T value=nextNode.t;
                nextNode=nextNode.next;
                return value;
            }
            return null;
           
        }
    } 
    public void reverse(){
        this.head=reverse(this.head);
    }
    //反转列表
    private Node reverse(Node node){
        Node nextNode=node;
        Node headNode=null;
        while(nextNode!=null){
            Node foo=nextNode.next;
            nextNode.next=headNode;
            headNode=nextNode;
            nextNode=foo;
        }
        return headNode;
    }
    public static void main(String[] args){
            MyLinkList<String> list = new MyLinkList<>();
            list.add("aa");
            list.add("bb");
            list.add("cc");
            
            System.out.println("===========remove");
            //list.remove();
            list.add("cc");
            list.add("dd");
            for(String value : list){
                System.out.println(value);
            }
            System.out.println("===========reverse");
            list.reverse();
            for(String value : list){
                System.out.println(value);
            }
    }
}