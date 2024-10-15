package 排序;

public class Radix_Sort {
public Radix_Sort(){
    int []mun=new int[11];

    int max=main.numlist.get(0);
    for(int i=0;i<main.numlist.size();++i){
        if(max<main.numlist.get(i)){
            max=main.numlist.get(i);
        }
    }

    int maxlength=(max+"").length();
int [][]buckets=new int[10][main.numlist.size()];

for(int i=0,n=1;i<maxlength;++i,n*=10){
    for (int j = 0; j < 10; ++j) {
        mun[j] = 0;
    }
for(int j=0;j<main.numlist.size();++j){
    int mid=(main.numlist.get(j)/n)%10;
    buckets[mid][mun[mid]]=main.numlist.get(j);
++mun[mid];

}
int index=0;
for(int k=0;k<11;++k){

for(int j=0;j<mun[k];++j){
    main.numlist.set(index, buckets[k][j]);
    ++index;
}
mun[k]=0;
}

}


}
}
