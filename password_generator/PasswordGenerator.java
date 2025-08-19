import java.util.Random;
import java.util.Scanner;

/**
 * PasswordGenerator - A utility to generate secure passwords
 * This class creates strong passwords with a mix of character types
 */
public class PasswordGenerator {
    
    // Character pools for password generation
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:,.<>?";
    
    // Random number generator
    private static final Random random = new Random();
    
    /**
     * Main method - Entry point of the program
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Secure Password Generator ===");
        System.out.print("Enter password length (press Enter for default 12): ");
        String input = scanner.nextLine().trim();
        
        // Set password length (default 12 if no input)
        int length = 12;
        if (!input.isEmpty()) {
            try {
                length = Integer.parseInt(input);
                if (length < 8) {
                    System.out.println("Warning: Short passwords are less secure. Using minimum length of 8.");
                    length = 8;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Using default length of 12.");
            }
        }
        
        // Generate and display the password
        String password = generatePassword(length);
        System.out.println("\nGenerated Password: " + password);
        System.out.println("Password length: " + password.length());
        
        scanner.close();
    }
    
    /**
     * Generates a secure password with specified length
     * 
     * @param length The desired password length
     * @return A string containing the generated password
     */
    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        
        // Ensure we have at least one character from each category
        password.append(getRandomChar(LOWERCASE_CHARS));
        password.append(getRandomChar(UPPERCASE_CHARS));
        password.append(getRandomChar(NUMBERS));
        password.append(getRandomChar(SPECIAL_CHARS));
        
        // All character types combined
        String allChars = LOWERCASE_CHARS + UPPERCASE_CHARS + NUMBERS + SPECIAL_CHARS;
        
        // Fill the rest of the password with random characters
        for (int i = 4; i < length; i++) {
            password.append(getRandomChar(allChars));
        }
        
        // Shuffle the password to avoid predictable patterns
        // (first 4 chars would always be in same order otherwise)
        return shuffleString(password.toString());
    }
    
    /**
     * Retrieves a random character from the given character pool
     * 
     * @param charPool String containing possible characters
     * @return A randomly selected character
     */
    private static char getRandomChar(String charPool) {
        int randomIndex = random.nextInt(charPool.length());
        return charPool.charAt(randomIndex);
    }
    
    /**
     * Shuffles the characters in a string
     * 
     * @param input The string to shuffle
     * @return A shuffled version of the input string
     */
    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        
        // Fisher-Yates shuffle algorithm
        for (int i = characters.length - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            // Swap characters
            char temp = characters[randomIndex];
            characters[randomIndex] = characters[i];
            characters[i] = temp;
        }
        
        return new String(characters);
    }
}

