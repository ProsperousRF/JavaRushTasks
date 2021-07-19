# 8. Что такое try-with-resources?

Начиная с Java 7 блок try(запрос на открытие ресурсов) с автоматическим закрытием этих ресурсов.
Ресурсы закрываются автоматически после выхода из блока try.

например 
```
static String readFirstLineFromFile(String path) throws IOException {
  try (BufferedReader br = new BufferedReader(new FileReader(path))) {
    return br.readLine();
  }
}
```
вместо
```
static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
  BufferedReader br = new BufferedReader(new FileReader(path));
    try {
      return br.readLine();
    } finally {
      br.close();
    }
}
```