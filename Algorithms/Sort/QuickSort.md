# 快速排序
## 定义
>快速排序是一种分治的排序算法，它将一个数组分成两个子数组，将两部分独立地排序。快速排序和归并排序是互补的，归并排序将数组分成两个子数组分别排序，并降有序的子数组归并以将整个数组排序；而快速排序将数组排序的方式则是两个子数组都有序时，整个数组也就自然有序了。
## 代码
```java
private static int partition(Comparable[] a,int lo,int hi){
        int i = lo;
        int j = hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i],v)){
                if(i==hi){
                    break;
                }
            }
            while(less(v,a[--j])){
                if(j==lo){
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
```
```java
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
```
## 分析
快速排序的关键在于切分，该过程使得数组满足下面三个条件
1. 对于某个j，a[j]已经排序
2. a[lo]到a[j-1]中的所有元素都不大于a[j]
3. a[j+1]到a[hi]中的所有元素都不小于a[j]  

通过递归的调用切分，总能排定一个元素。在切分前，一般需要将带排序数组随机打乱。首先，取a[lo]作为切分元素，然后从数组的左端开始向右扫描直到找到一个大于等于它的元素，再从数组的右端开始向左扫描知道找到一个小于等于它的元素，这两个元素显然是没有排定的，因此，我们交换他们的位置。如此继续，我们可以保证左指针i的左侧元素都不大于切分元素，右指针j的右侧元素都不小于切分元素。当两个指针相遇时，只需要将切分元素a[lo]和左子数组最右侧的元素a[j]交换，然后返回j  
快速排序切分方法的内循环会使用一个递增索引将数组元素和一个特定的值比较，无需移动数据。
