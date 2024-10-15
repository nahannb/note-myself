package 图的创建;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Topology extends Graph{

public Topology(){
    super();
}

public void TopSort(){

    for(int i=0;i<n;++i){
int v=find_zero();
if(v==-1){
    Error("图中有回路");
    break;
}
System.out.println(name[v]);
operate_son(v);
    }
}

private void Error(String string) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'Error'");
}

public int find_zero(){
   for(int i=0;i<n;++i){
    if(father[i]==0){
        return i;
    }
   }
   return -1;//如果找不到father，返回-1，避免进入死循环。
}

public void operate_son(int v1){
    for(int i=0;i<n;++i){
     if(square[v1][i]==1){
         father[i]=0;
     }
    }

father[v1]=-1;

 }

}
