package mips.datapath.and.control.unit.simulator;
public class Mux {
    private int output;
    
    public Mux() {
        
    }
    
    public void selectOutput(int first, int second, int control) {
        selectOutput(first, second, 0, control);
    }
    
    public void selectOutput(int first, int second, int third, int control) {
        if(control == 0) {
            output = first;
        } else if(control == 1) {
            output = second;
        } else if(control == 2) {
            output = third;
        }
    }
    
    
    public int getOutput() {
        return output;
    }
}
