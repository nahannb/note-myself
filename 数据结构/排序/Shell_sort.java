package 排序;

public class Shell_sort {
public Shell_sort(){
    int n=main.numlist.size();
    for(int p=n/2;p>0;p=p/2){
for(int d=p;d<n;++d){
int mid=main.numlist.get(d);
int i;
for(i=d;i>=p&&main.numlist.get(i-p)>mid;i=i-p){
main.numlist.set(i, main.numlist.get(i-p));
}
main.numlist.set(i, mid);
}
    }
}
}
