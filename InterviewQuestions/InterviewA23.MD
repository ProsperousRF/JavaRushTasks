# 23. Зачем использовать ключевое слово final при создании анонимных классов?

> An anonymous class cannot access local variables in its enclosing scope that are not declared as final or effectively final.

https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html

Анонимный класс может иметь доступ только к финальным переменным окружающего его класса (Класса 
внутри которого создан этот анонимный класс)