# Учимся гуглить.
## Как запустить отдельный процесс
### Java Multithreading
#### Уровень 5, Лекция 12

1. Что такое ThreadGroup и зачем он нужен?
```
A ThreadGroup in Java represents a group of threads or thread groups and 
belongs to the java.lang.ThreadGroup class. 
The main advantage of a thread group is that we can perform operations 
like suspend, resume, or interrupt for all threads using a single function call. 
Every thread in a thread group has a parent thread except the initial thread 
and hence it represents a tree structure. 
It can access all the information about its own thread group. 
ThreadGroup class is very useful when we want to perform the same operation 
on multiple threads.
```
https://www.tutorialcup.com/java/threadgroup-in-java.htm

https://www.geeksforgeeks.org/java-lang-threadgroup-class-java/

2. Что такое ThreadPool и зачем он нужен?
3. Что такое ThreadPoolExecutor и зачем он нужен?
4. Что такое Concurrency?
5. Что такое «атомарные типы» в Java?
6. Зачем нужен класс ThreadLocal?
7. Что такое модификатор volatile?
8. Что такое Executor?
9. Что такое ExecutorService?
10. Зачем нужен ScheduledExecutorService?