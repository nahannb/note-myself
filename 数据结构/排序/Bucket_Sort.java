package 排序;

public class Bucket_Sort {

public Bucket_Sort(){
    int []bucket;
    int max=main.numlist.get(0);

for(int i=0;i<main.numlist.size();++i){
if(max<main.numlist.get(i)){
    max=main.numlist.get(i);
}
}


bucket=new int[max+1];

for(int i=0;i<main.numlist.size();++i){
++bucket[main.numlist.get(i)];
}

int flag=0;
for(int i=1;i<=max;++i){
    for(int j=0;j<bucket[i];++j){
main.numlist.set(flag, i);
flag++;
    }
}

}

}
