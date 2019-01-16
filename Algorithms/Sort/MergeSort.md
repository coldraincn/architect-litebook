# 归并排序
## 定义
>归并排序是建立在归并操作上的一种有效的排序算法，该算法是采用分治法的一个非常典型的应用，将已有序的子序列合并，得到完全有序的序列，即先使每个子序列有序，再使子序列段间有序。
## 代码
### 合并代码
```java
private static void Merge(Comparable[] a,int lo,int mid,int hi){
        int i = lo;
        int j = mid+1;
        for(int k = lo;k<=hi;k++){

            aux[k] = a[k];
        }
        for(int k = lo;k<=hi;k++){
            if(i>mid){
                a[k] = aux[j++];
            }else if(j>hi){
                a[k] = aux[i++];
            }else if(less(aux[i],aux[j])){
                a[k] = aux[i++];
            }else{
                a[k] = aux[j++];
            }
        }      
        
    }
```
### 自顶向下排序
```java
    private static Comparable[] aux;
    public static void Sort(Comparable[] a){
        aux = new Comparable[a.length];
        Sort(a,0,a.length-1);  
    }
    private static void Sort(Comparable[] a,int lo,int hi){
        if(lo>=hi){
            return;
        }
        int mid = lo+(hi-lo)/2;
        Sort(a,lo,mid);
        Sort(a,mid+1,hi);
        Merge(a,lo,mid,hi);     
    }
```
### 自底向上排序
```java
    private static Comparable[] aux;
    public static void Sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for(int sz = 1;sz<N;sz=sz+sz){
            for(int lo = 0;lo<N-sz;lo+=sz+sz){
                Merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1))
            }
        }  
    }
```
## 分析
在merge算法中，首先将两个分别排序好的子数组复制到一个辅助数组中，然后在比较中放回原属组。  
在自定向下的归并排序中，排序需要（1/2)*NlgN至NlgN次比较  
归并排序的主要缺点是辅助数组所使用的额外空间和N的大小成正比  
当数组长度为2的幂时，自顶向下和自底向上归并排序所用的比较次数和数组访问次数相等。  
自底向上的归并排序比较适合用链表组织数据，只需要重新组织链表的链接就能将链表原地排序
