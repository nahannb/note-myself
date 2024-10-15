import java.util.Scanner;

public class Hashtable {
    static int n=11;
    static int[] a=new int[11];
    static boolean[]b=new boolean[11];

public static void main(String[] args) {
    int mid;
    Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();
    Hashtable hashtable=new Hashtable();
    for(int i=0;i<N;++i){
        mid=sc.nextInt();
        hashtable.insert(mid);
    }

    int t=sc.nextInt();
    hashtable.explore(t);

}

public int km(int n1){
int m1;

m1=n1%11;
return m1;
}

public int find (int n1){
int CNum=0;
int m1=km(n1);
int newpos=m1;
int currentpows=m1;
while (a[newpos]!=0&&a[newpos]!=n1) {
 if(++CNum%2!=0){
newpos=currentpows+(CNum+1)/2*(CNum+1)/2;
while (newpos>=n) {
    newpos=newpos-n;
}
 }else{
newpos=currentpows-CNum/2*CNum/2;
while (newpos<0) {
    newpos=newpos+n;
}
 }
}
return newpos;
}

public void insert(int i1){
int pos=find(i1);
if(b[pos]!=true){
b[pos]=true;
a[pos]=i1;
}
}

public void deleted(int n1){
    int pos=find(n1);
    a[pos]=0;
}

public void explore(int n1){
    int CNum=0;
int m1=km(n1);
int newpos=m1;
int currentpows=m1;
while (b[newpos]&&a[newpos]!=n1) {
 if(++CNum%2!=0){
newpos=currentpows+(CNum+1)/2*(CNum+1)/2;
while (newpos>=n) {
    newpos=newpos-n;
}
 }else{
newpos=currentpows-CNum/2*CNum/2;
while (newpos<0) {
    newpos=newpos+n;
}
 }
}

if(b[newpos]){
    System.out.println(newpos);
}else{
    System.out.println("No target number!");
}

}

}
