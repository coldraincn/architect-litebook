package com.coldraincn.algorithms;

public class SortAlgo{
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
        InsertionSort(a); 
        show(a);
    }
}