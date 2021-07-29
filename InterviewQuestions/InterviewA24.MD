# 24. Как правильно создать объект внутреннего класса?

Внутренние классы не могут существовать без объекта внешнего класса.

```java
class OuterClass {

  class InnerClass{
    
  }

  public static void main(String[] args) {
    OuterClass outerObject = new OuterClass(); // Create outter class object
    InnerClass innerObject = outerObject.new InnerClass(); // Create inner class object
  }
}
```