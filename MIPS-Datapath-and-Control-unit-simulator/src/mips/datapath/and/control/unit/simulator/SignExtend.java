package mips.datapath.and.control.unit.simulator;

public class SignExtend {
    private static int inputOffset;
    private static StringBuffer extendedOutputBits;
    
    public SignExtend() {
    }
    
    public void extendInput() {
        char leftMostChar;
        if(inputOffset >= 0) {
            leftMostChar = '0';
        } else {
            leftMostChar = '1';
        }
        extendedOutputBits = new StringBuffer(Integer.toBinaryString(inputOffset));
        int sz = extendedOutputBits.length();
        while(sz <= 32) {
            extendedOutputBits.insert(0, leftMostChar);
            sz++;
        }
    }
    
    public int getOutput() {
        return inputOffset;
    }
}
