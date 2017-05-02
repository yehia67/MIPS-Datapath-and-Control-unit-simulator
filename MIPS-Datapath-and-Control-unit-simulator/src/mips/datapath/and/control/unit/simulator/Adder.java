package mips.datapath.and.control.unit.simulator;

public class Adder {
    private int firstSrc;
    private int secondSrc;
    private int output;
    
    public Adder(int inputFirstSrc, int inputSecondSrc) {
        firstSrc = inputFirstSrc;
        secondSrc = inputSecondSrc;
        performOperation();
    }
    
    private void performOperation() {
        output = firstSrc + secondSrc;
    }
    
    public int getOutput() {
        return output;
    }
}
