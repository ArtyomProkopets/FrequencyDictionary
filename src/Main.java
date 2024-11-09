import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите путь к входному файлу: ");
            String inputFilePath = scanner.nextLine();

            if (!isFileAvailable(inputFilePath)) {
                System.out.println("Файл не найден. Проверьте правильность пути.");
                return;
            }

            System.out.print("Введите путь для сохранения результатов: ");
            String outputFilePath = scanner.nextLine();

            Map<Character, Integer> characterFrequency = CharacterFrequencyAnalyzer.calculateCharacterFrequency(inputFilePath);
            CharacterFrequencyAnalyzer.exportFrequencyData(characterFrequency, outputFilePath);

            System.out.println("Анализ завершен. Результаты сохранены в файл: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Ошибка при обработке файла: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static boolean isFileAvailable(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}
