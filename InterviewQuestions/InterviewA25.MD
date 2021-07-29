# 25. Как правильно создать объект вложенного класса?

Мы говорим о StaticNestedClass

```java
class OuterClass {
    //...
    class InnerClass {
       // ...
    }
    static class StaticNestedClass {
       // ...
    }


  OuterClass.StaticNestedClass nestedObl = new OuterClass.StaticNestedClass();
}
```
