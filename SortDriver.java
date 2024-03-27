import java.util.*;

public class SortString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String input = scanner.nextLine();

        System.out.println("The Sorted String is: ");
        sortString(input);
        
        scanner.close(); // Close the scanner to avoid resource leak
    }

    public static void sortString(String input) {
        // Separate uppercase and lowercase letters
        StringBuilder uppercase = new StringBuilder();
        StringBuilder lowercase = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercase.append(c);
            } else {
                lowercase.append(c);
            }
        }

        // Sort the separate sets of letters
        char[] uppercaseArray = uppercase.toString().toCharArray();
        char[] lowercaseArray = lowercase.toString().toCharArray();

        Arrays.sort(uppercaseArray);
        Arrays.sort(lowercaseArray);

        // Merge sorted uppercase and lowercase letters
        StringBuilder sortedString = new StringBuilder();

        int length1 = uppercaseArray.length;
        int length2 = lowercaseArray.length;
        int maxLength = Math.max(length1, length2);

        for (int i = 0; i < maxLength; i++) {
            if (i < length1) {
                sortedString.append(uppercaseArray[i]);
            }
            if (i < length2) {
                sortedString.append(lowercaseArray[i]);
            }
        }

        System.out.println(sortedString.toString());
    }
}
