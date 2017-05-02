package mips.datapath.and.control.unit.simulator;

public class SignExtend {
    private int inputOffset;
    private StringBuffer extendedOutputBits;
    
    public SignExtend(int offset) {
        inputOffset = offset;
        extendInput();
        print();
    }
    
    private void extendInput() {
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
    
    private void print() {
        System.out.println("Wires [16, 0] going to Sign Extend component " + 
                "holds value : " + inputOffset);
        System.out.println("32-bit wire coming out from the Sign Extend " +
                "component holds value : " + extendedOutputBits + "(" + 
                inputOffset + ")");
    }
    
    private int getOutput() {
        return inputOffset;
    }
}
