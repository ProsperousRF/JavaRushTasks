# Учимся гуглить | 1 уровень | 11 лекция
### Java Collections
#### 1 уровень, 11 лекция

### Найди в интернете:
1. Примеры работы с классом File
   <https://www.bestprog.net/ru/2020/06/11/java-work-with-files-in-java-class-file-basic-working
   -methods-ru/>
   
2. Как получить список всех файлов в директории и ее поддиректориях?
   <https://gist.github.com/ProsperousRF/7dd475fa96b2b43b8898a062766fecfc>
3. Как получить список всех файлов в директории с расширением zip?
```
    List<String> allZips = Files.walk(Paths.get(pathToDir), Integer.MAX_VALUE)
        .map(String::valueOf)
        .filter(s -> s.toLowerCase().endsWith(".zip"))
        .sorted()
        .collect(Collectors.toList());

```
4. Как заархивировать файл?
<https://www.baeldung.com/java-compress-and-uncompress>

5. Как заархивировать много файлов?
<https://www.baeldung.com/java-compress-and-uncompress>

6. Как заархивировать много файлов и директорий?
<https://www.baeldung.com/java-compress-and-uncompress>

7. Как разархивировать файл?
<https://www.baeldung.com/java-compress-and-uncompress>
   
8. Как задать кодировку файла?
<https://www.geeksforgeeks.org/how-to-get-and-set-default-character-encoding-or-charset-in-java/>
   
9. Как узнать кодировку файла в архиве? - Никак.
   
10. Как поменять данные (свойства) в объекте типа Properties?
~~~    
properties.setProperty("name","Sergio"); 
properties.store(fos,"какие-то комментарии"); 
//fos - FileOutPutStream к тому же самому файлу
~~~