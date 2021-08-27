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
``` 
What is a Thread Pool
In simple words, Thread Pool is a group of worker threads. 
Worker threads are waiting for the task( or job). It can be reused many times.   

Why do we need Thread Pool
Creating a new thread in java is an expensive operation since it requires 
an Operating System to provide resources needed for the thread. 
In a large-scale application, there will be a significant memory management 
overhead for allocating and deallocating many thread objects. 
Using worker threads in the application minimizes the overhead 
due to thread creation. 
As a result, we use Thread Pool for large-scale operations.
```
https://www.youtube.com/watch?v=ZcKt5FYd3bU

https://www.baeldung.com/thread-pool-java-and-guava

https://javahungry.blogspot.com/2020/09/thread-pool-example.html

3. Что такое ThreadPoolExecutor и зачем он нужен?
```
ThreadPoolExecutor – реализация ExecutorService. 
Он выполняет переданную задачу (Callable или Runnable), используя одну из 
внутренних доступных нитей из пула. 
Пул потоков содержит в себе ThreadPoolExecutor, который может содержать 
изменяющееся число нитей. 
Число нитей в пуле задается с помощью corePoolSize и maximumPoolSize.
``` 
https://www.youtube.com/watch?v=nU3Yf8UVWVc&t=572s

4. Что такое Concurrency?
```
Concurrency это работа с многопоточным кодом.
```

[На русском стековерфлоу](https://ru.stackoverflow.com/questions/448111/%D0%A7%D1%82%D0%BE-%D1%82%D0%B0%D0%BA%D0%BE%D0%B5-concurrency-%D0%B8-%D0%BA%D0%B0%D0%BA%D0%B8%D0%B5-%D0%B5%D1%81%D1%82%D1%8C-concurrency-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D1%8B)

5. Что такое «атомарные типы» в Java?
6. Зачем нужен класс ThreadLocal?
7. Что такое модификатор volatile?
8. Что такое Executor?
9. Что такое ExecutorService?
10. Зачем нужен ScheduledExecutorService?