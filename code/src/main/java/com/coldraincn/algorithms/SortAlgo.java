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
        Sort(a); 
        show(a);
    }
}