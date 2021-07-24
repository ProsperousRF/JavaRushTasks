# Учимся гуглить. Как сменить кодировку строки
### Java Multithreading
#### 2 уровень, 14 лекция

1. **Как отсортировать массив строк в алфавитном порядке?**
   > Arrays.sort(someStringArray);
2. **Регулярное выражение для проверки email?**
   
   Забей на регулярки после вникания в 
   [эту](https://stackoverflow.com/questions/2049502/what-characters-are-allowed-in-an-email-address) и 
   [эту](https://habr.com/ru/post/175375/) тему.
   
   Но если конкретно приперло, пользуйся чем то простым.
   >^[a-zA-Z\d\"].*@.*\..{1,6}
3. **Регулярное выражение для проверки url?**
   
   Тут тоже не все так безоблачно. Вот короткое решение, но оно не учитывает 
   домены в локальных кодировках.. 
   > (\b(https?|ftp|file)://)?[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]
4. **Регулярное выражение для разбиения строки на слова?**
   
   Самый, самый простой вариант 
   > String.split(" ");

5. **Как развернуть строку задом наперед?**
```Java
// Java program to ReverseString using StringBuilder
import java.lang.*;
import java.io.*;
import java.util.*;
 
// Class of ReverseString
class ReverseString {
    public static void main(String[] args)
    {
        String input = "Geeks for Geeks";
 
        StringBuilder input1 = new StringBuilder();
 
        // append a string into StringBuilder input1
        input1.append(input);
 
        // reverse StringBuilder input1
        input1.reverse();
 
        // print reversed String
        System.out.println(input1);
    }
}
```   
6. **Как узнать имя текущей кодировки?**
   >Charset currentCharset = Charset.defaultCharset();
   
7. **Как создать папку на диске?**
   
   [How to create directory in Java](https://mkyong.com/java/how-to-create-directory-in-java/)
   
```
try {

    Path path = Paths.get("/home/mkyong/a/b/c/");

    //java.nio.file.Files;
    Files.createDirectories(path);

    System.out.println("Directory is created!");

  } catch (IOException e) {

    System.err.println("Failed to create directory!" + e.getMessage());

  }
```

8. **Как проверить – Есть ли определенная папка на диске?**
   >[Files.exists(Path)](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html#exists(java.nio.file.Path,java.nio.file.LinkOption...)) method   

9. **Как скопировать файл?**
   
   >Files.copy(source, destination);


10. **Как скопировать директорию?**

    >Files.copy(source, destination);