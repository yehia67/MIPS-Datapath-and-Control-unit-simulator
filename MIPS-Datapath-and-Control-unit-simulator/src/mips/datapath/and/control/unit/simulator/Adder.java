package mips.datapath.and.control.unit.simulator;

public class Adder {
    private int firstSrc;
    private int secondSrc;
    private int output;
    
    public Adder() {
    }
    
    public void performOperation(int inputFirstSrc, int inputSecondSrc) {
        
        firstSrc = inputFirstSrc;
        secondSrc = inputSecondSrc;
        output = firstSrc + secondSrc;
    }
    
    public int getOutput() {
        return output;
    }
}
