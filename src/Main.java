import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                int googleBotCount = 0;
                int yandexBotCount = 0;
                String newLine = "";
                String bot = "";

                while ((line = reader.readLine()) != null) {
                    int length = line.length();
                    countLines++;
                    if (length > 1024)
                        throw new TooManySymbolsException("Больше 1024 символов в строке");

                    if (line.contains("(") && line.contains(")")) {
                        if (line.indexOf("(") > line.indexOf(")")) {
                            Matcher matcher = Pattern.compile("[)]").matcher(line);
                            int closeBracket = 0;
                            while (closeBracket < line.indexOf("(")) {
                                matcher.find();
                                closeBracket = matcher.start();
                            }
                            newLine = line.substring(line.indexOf("(") + 1, closeBracket);
                        } else {
                            newLine = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
                        }
                    }

                    String[] parts = newLine.split(";");
                    
                    if (parts.length >= 2) {
                        String fragment = parts[1].trim();
                        if (fragment.contains("/"))
                            bot = fragment.substring(0, fragment.indexOf("/"));
                        if (bot.equals("Googlebot"))
                            googleBotCount++;
                        if (bot.equals("YandexBot"))
                            yandexBotCount++;
                    }
                }

                System.out.println("Общее количество строк в файле равно " + countLines);
                System.out.println("Количество запросов от Googlebot равно " + googleBotCount);
                System.out.println("Количество запросов от YandexBot равно " + yandexBotCount);

            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}