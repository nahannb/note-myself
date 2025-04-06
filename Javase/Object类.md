# Object类


在 Java 中，`Object` 是所有类的根类，它位于 `java.lang` 包中。因此，当你创建一个类时，如果没有显式指定它的父类，它默认继承自 `Object` 类。

`Object` 类定义了一些所有 Java 对象都具备的通用方法，包括：

- `toString()`：返回对象的字符串表示形式。
- `equals(Object obj)`：比较对象是否相等。
- `hashCode()`：返回对象的哈希码值。
- `getClass()`：返回对象的运行时类。
- `clone()`：创建并返回此对象的一个副本。
- `finalize()`：当对象被垃圾回收器回收时调用。

因此，当你使用 `Object` 类型时，你实际上可以存储任何类型的对象，因为所有对象都可以视为 `Object` 类型的对象。例如：

```
java
Copy code
Object obj = new String("Hello");
```

在这个示例中，`obj` 是一个 `Object` 类型的变量，但它实际上存储了一个 `String` 类型的对象。这是因为 `String` 类是 `Object` 类的子类，所以可以将 `String` 类的对象赋值给 `Object` 类型的变量。