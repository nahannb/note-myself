package 排序;
public class Insertion_sort {
public Insertion_sort(){
    int n=main.numlist.size();
    int j;
    for(int i=1;i<n;++i){
        int mid=main.numlist.get(i);
        for(j=i;j>0&&mid>main.numlist.get(j-1);--j){
main.numlist.set(j,main.numlist.get(j-1));
        }
        main.numlist.set(j,mid);
    }
}
}

