package mips.datapath.and.control.unit.simulator;
public class Mux {
    private int firstSrc;
    private int secSrc;
    private int output;
    
    public Mux() {
        
    }
    
    public void selectOutput(int first, int second, int control) {
        firstSrc = first;
        secSrc = second;
        if(control == 1) {
            output = secSrc;
        } else {
            output = firstSrc;
        }
    }
    
    
    public int getOutput() {
        return output;
    }
}
