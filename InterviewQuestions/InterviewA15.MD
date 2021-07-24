# 15. Как преобразовать строку в кодировку Windows-1251?

(https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html)

> String(byte[] bytes, String charsetName)
> 
> Constructs a new String by decoding the specified array of bytes using the specified charset.

 
```
 String utf8 = "Строка в utf8";
 byte[] bytes1251 = utf8.getBytes("windows-1251"); 
 String w1251 = new String(bytes1251,"windows-1251");
```