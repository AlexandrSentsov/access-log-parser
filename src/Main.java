import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int count = 0;
        while (true) {
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDictionary = file.isDirectory();
            if (!fileExists) {
                System.out.println("Путь не существует");
                continue;
            } else if (isDictionary) {
                System.out.println("Это путь к папке, а не к файлу");
                continue;
            } else {
                count += 1;
                System.out.println("Путь указан верно");
                System.out.println("Это файл номер " + count);
            }
            FileReader fileReader = new FileReader(path);
            try (BufferedReader reader = new BufferedReader(fileReader)){
                String line;
                int countLines = 0;
                int maxLenth = 0;
                int minLenth = 2147483647;
                while ((line = reader.readLine()) != null) {
                    int length = line.length();
                    countLines++;
                    if (length > maxLenth)
                        maxLenth = length;
                    if (length < minLenth)
                        minLenth = length;
                    if (length > 1024)
                        throw new TooManySymbolsException("Больше 1024 символов в строке");
                }
                System.out.println("Общее количество строк в файле равно " + countLines);
                System.out.println("Длина самой длинной строки в файле равна " + maxLenth);
                System.out.println("Длина самой короткой строки в файле равна " + minLenth);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}