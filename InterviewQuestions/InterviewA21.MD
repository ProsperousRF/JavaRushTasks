# 21. Какие бывают внутренние классы?

https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html

```java
class OuterClass {
    //...
    class InnerClass {
       // ...
    }
    static class StaticNestedClass {
       // ...
    }
    
    void foo() {
      class LocalClass {
        // ...
      }
    }
}
```



---

**Terminology:** Nested classes are divided into two categories: non-static and static. 

Non-static nested classes are called *inner classes*. 

Nested classes that are declared static are called *static nested classes*.

---


## Local and Anonymous Classes

There are two additional types of inner classes. 

You can declare an inner class within the body of a method. <br>
These classes are known as
<a class="TutorialLink" target="_top" href="localclasses.html">local classes</a>. 

You can also declare an inner class within the body of a method without naming the class.<br> 
These classes are known as
<a class="TutorialLink" target="_top" href="anonymousclasses.html">anonymous classes</a>.

---

Вложенные внутренние классы - Nested classes
- Non-static nested classes (inner classes)
  - локальный класс (local class)
  - анонимный класс (anonymous class)
- Static nested classes - статические вложенные классы.

