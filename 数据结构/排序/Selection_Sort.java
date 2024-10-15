package 排序;

public class Selection_Sort {
  public Selection_Sort(){
    int n=main.numlist.size();
    int sqence;
    for(int i=0;i<n;++i){
sqence=find(i, n-1);
swap(i, sqence);
    }
  }

 public int find(int i,int n){
    int min=99999;
    int seqence=0;
    for(int p=i;p<=n;++p){
if(main.numlist.get(p)<min){
    min=main.numlist.get(p);
seqence=p;
}
    }
    return seqence;
 }
 public void swap(int i,int p){
    int mid=main.numlist.get(i);
    main.numlist.set(i,main.numlist.get(p));
    main.numlist.set(p, mid);
 }
}
