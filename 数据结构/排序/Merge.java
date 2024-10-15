package 排序;

public class Merge {
public void merge(int L,int R,int n3){
    int Leftend=R-1;
    int P=0;
    while(L<Leftend&&R<n3){
        if(main.numlist.get(L)<main.numlist.get(R)){
            main.putout.add(main.numlist.get(L));
            ++L;
            ++P;
        }else{
            main.putout.add(main.numlist.get(R));
            ++R;
            ++P;
        }
    }
    while (L<Leftend) {
        main.putout.add(main.numlist.get(L++));
    }
    while (R<n3) {
        main.putout.add(main.numlist.get(R++));
    }
    for(int i=0;i<n3;++i,R--){
        main.numlist.set(R,main.putout.get(R));
    }
}
}
