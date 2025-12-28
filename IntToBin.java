/** Returns the binary representation of a given integer. */
public class IntToBin {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("Binary representation of " + x + " is: " + toBinary(x));
    }

    /** Returns the binary representation of the given integer, as a string of 0's and 1's.  */
    public static String toBinary(int x) {
        if (x > 0)  {
            String bin = toBinary(x / 2);
            if (bin.equals("0")) return "" + (x % 2);
            return bin + (x % 2);
        }
        return "0";
    }    
 }