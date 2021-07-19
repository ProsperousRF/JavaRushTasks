# 6. Зачем нужен метод finalize() и как он работает?

Метод вызывается перед garbage collector чтобы освободить ресурсы.
но использование этого метода плохая практика как нас учит Joshua Bloch 
> Finalizers are unpredictable, often dangerous, and generally unnecessary.
[Item 7: Avoid finalizers](https://www.informit.com/articles/article.aspx?p=1216151&seqNum=7)

А тем более, что:
> One critical point to notice is that finalize has been deprecated starting with Java 9 – and 
will eventually be removed.