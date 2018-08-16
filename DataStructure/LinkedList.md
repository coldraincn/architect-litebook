# 链表、数组

#### 定义
>链表是一种物理存储单元上非连续、非顺序的存储结构，数据元素的逻辑顺序是通过链表中的指针链接次序实现的。

#### 图例（单链表）
![链表](images/danlianbiao.png)

#### 结构
1. 存储数据的域
2. 指向下个节点的指针

#### 单链表

```java
public class LinkList<T>{
    private static class Node<T>{
        T t;
        Node<T> next;
        Node<T>(T t,Node<T> next){
            this.t=t;
            this.next=next;
        }

    }
    private int size = 0;
    private Node<T> head;
    private Node<T> tail;
    public void add(T t){
        if(size=0){
            head=Node<T>(t,null);
            tail=Node<T>(t,null);
            size++;
        }else{
            Node<T> node=Node<T>(t,null);
            tail.next=node;
            tail=node;
            size++;
        }
    }
    public void remove()
}
```
