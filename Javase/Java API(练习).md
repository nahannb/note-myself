# Java API(练习)



## 一、

```java
import java.util.Random;

public class demo2 {
        public static void main(String[] args) {
            Random r=new Random();
            for(int i=1;i<=10;++i){
System.out.println(r.nextInt(100));
            }
        }
    
    }
```



## 二、

```java
package r;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date; // 导入 Date 类
import java.util.Random;

public class demo2 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        c.add(Calendar.DATE, 100);
        Date date = c.getTime();
        String d = dateFormat.format(date);
        System.out.println(d);
    }
}
```

