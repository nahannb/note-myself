package 图的创建;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Graph {

  public ArrayList<String> namesArrayList;//储存元素的集合
  public String[] name;//元素名字
  public int n;//元素的个数
  public int m;//边的个数
  public int[][]square;
  public int[]father;
  //public int[]son;
    public static void main(String[] args) {
      Topology graph=new Topology();
      graph.clear_f();
        graph.initialize_graph();
graph.insert();
graph.TopSort();
// graph.show_graph();


    }

    public void clear_f(){
        Scanner s=new  Scanner(System.in);
        n=s.nextInt();
        name=new String[n];
        for(int i=0;i<n;++i){
            name[i]=s.next();
        }

    }

public void initialize_graph(){
square=new int[n][n];
father=new int[n];
//son=new int[n];

namesArrayList=new ArrayList<String>(n);

for(int i=0;i<n;++i){
namesArrayList.add(name[i]);
}
}

public void insert(){
    System.out.println("How many edges?");
    Scanner s=new  Scanner(System.in);
    m=s.nextInt();
    for(int i=0;i<m;++i){
String k1=s.next();
String k2=s.next();
int h3=s.nextInt();
insert_square(k1, k2, h3);
    }
    s.close();
}

public void insert_square(String k1,String k2,int h3){
int v1=namesArrayList.indexOf(k1);
int v2=namesArrayList.indexOf(k2);
square[v1][v2]=h3;

father[v2]=v1;
//son[v1]=v2;
}

public void show_graph(){
    for(int[] i:square){
        System.out.println(Arrays.toString(i));
    }
}

}



