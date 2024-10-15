package 排序;

public class Quick_Sort {

public void quick_sort(int n){
    quicksort(0, n-1);
}

public void quicksort(int left,int right){
    if(left>right){
        return;
    }
    int pivot=Median3(left, right);
    int i=left,j=right;/*定义指针,指针来遍历 */
    while(1>0){
while(main.numlist.get(i)<=pivot&&i<j){
    i++;
}
while(main.numlist.get(j)>=pivot&&i<j){
    j--;
}
if(i<j){
    swap(i, j);

}
else break;
    }
    swap(i, right);
    quicksort(left, i-1);
    quicksort(i+1, right);
}

public int Median3(int left,int right){
int center=(left+right)/2;
if(main.numlist.get(left)>main.numlist.get(right)){
swap(left,right);
}
if(main.numlist.get(left)>main.numlist.get(center)){
    swap(left,center);
    }
    if(main.numlist.get(center)>main.numlist.get(right)){
        swap(center,right);
        }
        /*l<=c<=r */
        swap(center, right);
        /*只考虑left+1……right-1*/
return main.numlist.get(right);
}

public void swap(int left,int right){
    int mid=main.numlist.get(left);
    main.numlist.set(left, main.numlist.get(right));
    main.numlist.set(right, mid);
}

}
