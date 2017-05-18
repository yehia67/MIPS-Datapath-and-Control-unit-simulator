package mips.datapath.and.control.unit.simulator;

public class ToBinary {
    public static String convertToBinary(int num, int numOfBits) {
        String result = Integer.toBinaryString(num);
        while(result.length() < numOfBits) {
            result = "0" + result;
        }
        if(result.length() > numOfBits) {
            return result.substring(result.length() - 16, result.length());
        }
        return result;
    }
}
