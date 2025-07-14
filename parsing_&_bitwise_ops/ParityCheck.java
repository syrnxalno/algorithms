public class ParityCheck {
    public static void main(String args[]) {
        // Binary words
        String words[] = { "11010110011010011001110010101101",
                "10011010111100000110011011001100",
                "00101101110010101011010100011110",
                "11101001100110010011010011110000",
                "01110010111010011100100101011001" };

        int corruptedIndex = -1;
        for (int i = 0; i < words.length; i++) {
            if(!hasEvenParity(words[i])){
                corruptedIndex = i;
                break;
            }
        }
        if(corruptedIndex==-1){
            System.out.println("All words have even parity");
        }
        System.out.println("Corrupted index:"+corruptedIndex);
        String corruptedMessage = words[corruptedIndex];

        for (int i = 0; i < 32; i++) {
            String flipped = flipBitAt(corruptedMessage, i);
            if (hasEvenParity(flipped)) {
                System.out.println("Incorrect bit position: " + (i + 1));
                System.out.println("Corrected message: " + flipped);
                break;
            }
        }
    }

    // check even parity of every bit
    public static boolean hasEvenParity(String binary) {
        int count = 0;
        for (char c : binary.toCharArray()) {
            if (c == '1') count++;
        }
        return count % 2 == 0;
    }

    // flip the corrupted bit
    public static String flipBitAt(String binary, int index) {
        char[] bits = binary.toCharArray();
        bits[index] = bits[index] == '1' ? '0' : '1';
        return new String(bits);
    }
}