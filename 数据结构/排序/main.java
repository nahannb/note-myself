package 排序;
import java.util.ArrayList;

public class main {
    public static ArrayList<Integer> numlist= new ArrayList<>();
    public static ArrayList<Integer> numlist2= new ArrayList<>();
    public static ArrayList<Integer> putout= new ArrayList<>();
    public int k;
public static void main(String[] args) {
    // Add2 add2=new Add2();
    Add add=new Add();
    // Merge_sort merge_sort=new Merge_sort();
    // merge_sort.merge_sort(0, numlist.size()-1);
    // Merge_pass merge_pass=new Merge_pass();
    // merge_pass.merge_sort(numlist.size());
    //Bubble_sort bubble_sort=new Bubble_sort();
    // Quick_Sort quick_Sort=new Quick_Sort();
    // quick_Sort.quick_sort(numlist.size());
    // Bucket_Sort bucket_sort=new Bucket_Sort();
    Radix_Sort radix_sort=new Radix_Sort();
    // Insertion_sort insertion_sort=new Insertion_sort();
    // Shell_sort shell_sort=new Shell_sort();5
    // Selection_Sort selection_sort=new Selection_Sort();
    // System.out.println(numlist);
    System.out.println(numlist);
}
}
