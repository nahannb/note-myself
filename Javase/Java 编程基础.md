# Java 编程基础



## 1、

```java
 	public class test {
 		public static void main(String[] args) {
 			int sum = 0;
 			for (int i = 1; i < 100; i++) {
 				if (i % 2 != 0)
 					sum += i;
 			}
 			System.out.println(sum);
 		}
 	}

```



## 2、

```java
 	public class test {
 	    public static void main(String[] args) {
 	        int i = 1;
 	        long sum = 1;
 	        do {
 	             sum *= i;
 	             i++;
 	        } while (i <= 5);
 	              System.out.println(sum);
 	    }
  }

```

