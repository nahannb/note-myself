package 排序;
class Bubble_sort{
    public Bubble_sort(){
        int n=main.numlist.size();
        for(int p=n;p>0;--p){
int flag=0;
for(int i=0;i<p-1;++i){
int mid=main.numlist.get(i);
if(main.numlist.get(i)>main.numlist.get(i+1)){
    main.numlist.set(i, main.numlist.get(i+1));
    main.numlist.set(i+1, mid);
    flag=1;
}
}
if(flag==0){
    break;
}
        }
    }

}