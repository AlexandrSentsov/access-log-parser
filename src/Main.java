import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        while (true) {
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDictionary = file.isDirectory();
            if (fileExists == false) {
                System.out.println("Путь не существует");
                continue;
            } else if (isDictionary == true) {
                System.out.println("Это путь к папке, а не к файлу");
                continue;
            } else if (fileExists == true) {
                count += 1;
                System.out.println("Путь указан верно");
                System.out.println("Это файл номер " + count);
            }
        }
    }
}