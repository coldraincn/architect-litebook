package com.coldraincn.algorithms;

import java.util.Random;

public class SortAlgo{
    private static Random random;    // pseudo-random number generator
    private static long seed;
    static {
        // this is how the seed was set in Java 1.4
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }
    //选择排序
    public static void SelectionSort(Comparable[] a){
        for(int i = 0;i<a.length;i++){
            int min = i;
            for(int j=i+1;j<a.length;j++){
                if(less(a[j],a[min])){
                    min = j;
                }
            }
            exch(a,i,min);
        }

    }
    //插入排序
    public static void InsertionSort(Comparable[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }
    //希尔排序
    public static void HillSort(Comparable[] a){
        int N = a.length;
        int h=1;
        while(h<N/3){
            h=3*h+1;
        }
        while(h>=1){
            for(int i=h;i<N;i++){
                for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h){
                    exch(a,j,j-h);
                }
            }
            h=h/3;
        }
    }
    //原地归并排序
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
    //快速排序
    public static void QuickSort(Comparable[] a){
        shuffle(a);
        QuickSort(a,0,a.length-1);
    }
    private static void QuickSort(Comparable[] a,int lo,int hi){
        if(hi<=lo){
            return;
        }
        int j = partition(a,lo,hi);
        QuickSort(a,lo,j-1);
        QuickSort(a,j+1,hi);      
    }
    private static int partition(Comparable[] a,int lo,int hi){
        int i = lo;
        int j = hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i],v)){
                if(i>=hi){
                    break;
                }
            }
            while(less(v,a[--j])){
                if(j<=lo){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            exch(a,i,j);
        }
        exch(a,j,lo);
        return j;    

    }
    private static void shuffle(Object[] a){
        int n = a.length;
        for(int i = 0;i<n;i++){
            int r = i+random.nextInt(n-i);
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a, int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void show(Comparable[] a){
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }
    }
    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Integer[] a={3,6,8,2,5,0,7};
        //SortAlgo sort = new SortAlgo();
        QuickSort(a); 
        show(a);
    }
}