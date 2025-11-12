import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    // Define the possible character sets for the password.
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    // Special characters, you can customize this set as needed.
    private static final String SPECIAL = "!@#&()–{}[]:;',?/*~$^+=<>";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder characterPool = new StringBuilder();

        // Ask user which character types to include in the password
        System.out.print("Include uppercase letters? (Y/N): ");
        if (sc.nextLine().trim().equalsIgnoreCase("Y")) characterPool.append(UPPER);

        System.out.print("Include lowercase letters? (Y/N): ");
        if (sc.nextLine().trim().equalsIgnoreCase("Y")) characterPool.append(LOWER);

        System.out.print("Include digits? (Y/N): ");
        if (sc.nextLine().trim().equalsIgnoreCase("Y")) characterPool.append(DIGITS);

        System.out.print("Include special characters? (Y/N): ");
        if (sc.nextLine().trim().equalsIgnoreCase("Y")) characterPool.append(SPECIAL);

        // Ask user for the desired password length
        System.out.print("Enter desired password length: ");
        int length;
        try {
            length = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid length. Please enter a valid number.");
            return;
        }

        // Validate user input: ensure at least one character set is selected and the length is positive
        if (characterPool.length() == 0 || length < 1) {
            System.out.println("You must select at least one character type and a positive length.");
            return;
        }

        // Call the function to generate the password and print it
        String password = generatePassword(characterPool.toString(), length);
        System.out.println("Generated Password: " + password);
    }

    /**
     * Generates a random password using the specified character pool and length.
     * @param pool The string containing possible characters.
     * @param length The desired password length.
     * @return A random password string.
     */
    private static String generatePassword(String pool, int length) {
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            // Randomly pick a character from the pool and append to password
            int randomIndex = RANDOM.nextInt(pool.length());
            password.append(pool.charAt(randomIndex));
        }
        return password.toString();
    }
}
