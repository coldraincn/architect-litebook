package com.coldraincn.datastructure;

public class MyHashMap<K,V>{
    private Node[] tables;
    private class Node<K,V>{
        K key;
        V value;
        Node next;
        Node pre;
        Node (){
            
        }
        Node (K key,V value,Node pre,Node next){
            this.key=key;
            this.value=value;
            this.pre=pre;
            this.next=next;
        }
    }
    MyHashMap(){
        tables=(Node<K,V>[])new Node[10];
    }
    private int hash(int key){
        int hashNumber=key%9;
        return hashNumber;
    }
    public void put(K key,V value){
        Node node=new Node(key,value,null,null);
        int index=hash((int)node.key);
        if(tables[index]==null){
            tables[index]=node;
        }else{
            for(Node header=tables[index];header!=null;header=header.next){
                if(header.key==key){
                    header.value=node.value;
                }
                if(header.next==null){
                    header.next=node;
                    node.pre=header;
                    break;
                }
            }
        
        }
    }
    public V get(K key){
        int index=hash((int)key);
        Node node=tables[index];
        if(node==null){
            return null;
        }
        for(Node header=node;header!=null;header=header.next){
            if(header.key==key){
                return (V)header.value;
            }
        }
        return null;
    }
    public void delete(K key){
        if(key==null) throw new IllegalArgumentException("cannot be null");
        int index=hash((int)key);
        Node node=tables[index];
        if(node==null){
            return;
        }
       
        for(Node header=node;header!=null;header=header.next){
        
            if(header.key==key){
                if(header.pre==null){
                    if(header.next==null){
                        tables[index]=null;
                    }else{
                        tables[index]=header.next;
                    }
                }else{
                    if(header.next==null){
                        header.pre.next=null;
                    }else{
                        header.pre.next=header.next;
                        header.next.pre=header.pre;
                    }
                }
            
            
                break;
            }
        }
    }
    public static void main(String[] args){
        MyHashMap<Integer,String> hashmap=new MyHashMap<>();
        System.out.println("===========start=========");
        hashmap.put(2, "2222");
        hashmap.put(3, "3333");
        hashmap.put(4, "4444");
        hashmap.put(11, "11111111");
        System.out.println("===========put3========="+hashmap.get(3));
        hashmap.delete(11);
        System.out.println("===========delete3========="+hashmap.get(3));
        System.out.println("===========delete========="+hashmap.get(11));
    }
}