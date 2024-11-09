import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CharacterFrequencyAnalyzer {
    public static Map<Character, Integer> calculateCharacterFrequency(String inputFile) throws IOException {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                char symbol = (char) currentChar;
                if (isAlphabetCharacter(symbol)) {
                    charFrequencyMap.put(symbol, charFrequencyMap.getOrDefault(symbol, 0) + 1);
                }
            }
        }

        return charFrequencyMap;
    }

    public static void exportFrequencyData(Map<Character, Integer> charFrequencyMap, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
                writer.write(entry.getKey() + " => " + entry.getValue());
                writer.newLine();
            }
        }
    }

    private static boolean isAlphabetCharacter(char character) {
        return (character >= 'A' && character <= 'Z') ||
                (character >= 'a' && character <= 'z') ||
                (character >= '\u0410' && character <= '\u044F');
    }
}
