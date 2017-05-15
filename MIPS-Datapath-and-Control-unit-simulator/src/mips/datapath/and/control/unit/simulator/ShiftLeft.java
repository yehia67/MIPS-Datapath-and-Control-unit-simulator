package mips.datapath.and.control.unit.simulator;

public class ShiftLeft {
    private int inputOffset;
    private int outputOffset;
    
    public ShiftLeft() {
    }
    
    public void shiftLeftTwo(int offset) {
        outputOffset = inputOffset * 2;
    }
    
    private void print() {
        System.out.println("32-bit wire going to Shift Left 2 component " +
                "holds value : " + inputOffset);
        System.out.println("32-bit wire coming out from the Shift Left 2 " +
                "component holds value : " + outputOffset);
    }
    
    public int getOutput() {
        return outputOffset;
    }
}
